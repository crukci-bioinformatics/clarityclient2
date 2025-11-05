package org.cruk.clarity.api;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.MediaType;

import com.genologics.ri.Linkable;
import com.genologics.ri.savedquery.SavedQuery;

/**
 * The summary of a result of running a saved query.
 *
 * @since 2.34
 */
public class SavedQuerySummary implements Serializable
{
    @Serial private static final long serialVersionUID = 3011564738031403103L;

    /**
     * The query that was run.
     * @serial
     */
    private final Linkable<SavedQuery> query;

    /**
     * The mime type and character set returned from the server.
     * @serial
     */
    private final MediaType mediaType;

    /**
     * The length in bytes of the response.
     * @serial
     */
    private final long length;

    /**
     * A place holder for the result file.
     */
    private transient File reportFile;

    /**
     * Constructor.
     *
     * @param query The query run.
     * @param mediaType The media type.
     * @param length The response size.
     */
    public SavedQuerySummary(Linkable<SavedQuery> query, MediaType mediaType, long length)
    {
        requireNonNull(query, "The query run must be recorded.");
        this.query = query;
        this.mediaType = mediaType;
        this.length = length;
    }

    /**
     * Get
     * @return
     */
    public MediaType getMediaType()
    {
        return mediaType;
    }

    /**
     * Get the length in bytes of the response.
     *
     * @return The response size.
     */
    public long getLength()
    {
        return length;
    }

    /**
     * Get the file the report was saved as.
     *
     * @return The report file.
     */
    public File getReportFile()
    {
        return reportFile;
    }

    /**
     * Set the file the report was saved as. Note that this is not populated by
     * the API during the call. This is for client convenience if the report was
     * written to a file and that is useful to record here. It is also never
     * serialized.
     *
     * @param reportFile The report file.
     */
    public void setReportFile(File reportFile)
    {
        this.reportFile = reportFile;
    }

    /**
     * Print the content type and length of the response.
     *
     * @return The response fields as a human readable string.
     */
    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        sb.append("query", query);
        sb.append("contenttype", mediaType);
        sb.append("length", length);
        return sb.toString();
    }
}
