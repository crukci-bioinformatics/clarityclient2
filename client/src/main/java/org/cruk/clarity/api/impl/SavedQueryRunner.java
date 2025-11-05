package org.cruk.clarity.api.impl;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.cruk.clarity.api.ClarityAPI;
import org.cruk.clarity.api.ClarityException;
import org.cruk.clarity.api.InvalidURIException;
import org.cruk.clarity.api.SavedQuerySummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.genologics.ri.Linkable;
import com.genologics.ri.savedquery.SavedQuery;

/**
 * Extraction of code to run a saved query to simplify {@code ClarityAPIImpl}. This
 * class needs to handle an error response and convert the XML returned as an exception
 * when there is an error to a {@link ClarityException}.
 *
 * @since 2.34
 */
@Component
public class SavedQueryRunner
{
    /**
     * Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(ClarityAPI.class);

    /**
     * Client request factory.
     */
    protected ClientHttpRequestFactory httpRequestFactory;

    /**
     * The error handler.
     */
    protected ResponseErrorHandler errorHandler;

    /**
     * Constructor.
     */
    public SavedQueryRunner()
    {
    }

    /**
     * Set the request factory.
     *
     * @param factory The HTTP request factory.
     */
    @Autowired
    @Qualifier("clarityClientHttpRequestFactory")
    public void setHttpRequestFactory(ClientHttpRequestFactory factory)
    {
        requireNonNull(factory, "HTTP request factory cannot be null.");
        this.httpRequestFactory = factory;
    }

    /**
     * Set the error handler.
     *
     * @param handler The error handler.
     */
    @Autowired
    @Qualifier("clarityExceptionErrorHandler")
    public void setErrorHandler(ResponseErrorHandler handler)
    {
        requireNonNull(handler, "Error handler cannot be null.");
        this.errorHandler = handler;
    }

    /**
     * Run a saved query and write the result to the given output stream.
     *
     * @param query The saved query to run.
     * @param out The stream to write to. Must be open.
     * @param maximumResults The maximum number of results to return. If negative, don't set a limit.
     *
     * @return A summary of the report returned.
     *
     * @throws IOException if there is a problem writing to the output stream.
     * @throws ClarityException if there is an error reported back from Clarity.
     * @throws InvalidURIException in the near impossible case of the query URI being invalid.
     *
     * @see ClarityAPI#runSavedQuery(Linkable, OutputStream, long)
     */
    public SavedQuerySummary runSavedQuery(Linkable<SavedQuery> query, OutputStream out, long maximumResults) throws IOException
    {
        URI exportUri;
        try
        {
            StringBuilder sb = new StringBuilder();
            sb.append(query.getUri()).append("/export");
            if (maximumResults >= 0)
            {
                sb.append("?size=").append(maximumResults);
            }

            exportUri = new URI(sb.toString());
        }
        catch (URISyntaxException e)
        {
            // This should never happen, as we're creating the URI from an existing, valid
            // URI object.
            throw new InvalidURIException("Could not recreate a URI: ", e);
        }

        ClientHttpRequest request = httpRequestFactory.createRequest(exportUri, HttpMethod.GET);

        try (ClientHttpResponse response = request.execute())
        {
            if (response.getStatusCode().is2xxSuccessful())
            {
                long copied = IOUtils.copyLarge(response.getBody(), out);

                return new SavedQuerySummary(query, response.getHeaders().getContentType(), copied);
            }
            else
            {
                errorHandler.handleError(exportUri, HttpMethod.GET, response);

                // Shouldn't ever get here, but if we do, throw something.
                var ee = new com.genologics.ri.exception.Exception();
                ee.setMessage("Running saved query failed but the error handler hasn't fired its own exception.");
                throw new ClarityException(ee, response.getStatusCode());
            }
        }
    }
}
