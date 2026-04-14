/*
 * CRUK-CI Clarity REST API Java Client.
 * Copyright (C) 2013 Cancer Research UK Cambridge Institute.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.genologics.ri.exception;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 *
 * Exception is a descriptive error message that is returned instead of the
 * standard response for any request that the system was unable to process.
 * <p>
 * Exception will include a code corresponding to the HTTP response code of the
 * error. Typical response codes are 400, indicating that the submitted request
 * was not valid and cannot be reattempted without corrective action being
 * taken, or 500 indicating that there was an internal error in the server when
 * attempting to process the request. Refer to the section on HTTP response
 * codes in the API reference documentation for further details about the
 * categories and meanings of HTTP response codes.
 * </p>
 * <p>
 * Exception will include a message element with a textual summary of the error,
 * and may also provide a suggested-actions element with details on how to
 * correct the problem.
 * </p>
 */
@XmlRootElement(name = "exception")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exception", propOrder = { "message", "suggestedActions" })
public class Exception implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = 8552752622433159544L;

    /**
     * A textual summary of the error that occurred.
     */
    @XmlElement(name = "message")
    protected String message;

    /**
     * Details on how to correct the problem that caused the exception.
     */
    @XmlElement(name = "suggested-actions")
    protected String suggestedActions;

    /**
     * The category of the exception.
     */
    @XmlAttribute(name = "category")
    protected String category;

    /**
     * The HTTP response code corresponding to the error (e.g., 400 for bad request, 500 for internal server error).
     */
    @XmlAttribute(name = "code")
    protected String code;

    /**
     * Creates a new Exception instance.
     */
    public Exception()
    {
    }

    /**
     * Gets the error message.
     *
     * @return The textual summary of the error.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Sets the error message.
     *
     * @param message The textual summary of the error to set.
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Gets the suggested actions to correct the error.
     *
     * @return Details on how to correct the problem, or null if not provided.
     */
    public String getSuggestedActions()
    {
        return suggestedActions;
    }

    /**
     * Sets the suggested actions to correct the error.
     *
     * @param suggestedActions Details on how to correct the problem.
     */
    public void setSuggestedActions(String suggestedActions)
    {
        this.suggestedActions = suggestedActions;
    }

    /**
     * Gets the category of the exception.
     *
     * @return The exception category.
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Sets the category of the exception.
     *
     * @param category The exception category to set.
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * Gets the HTTP response code of the error.
     *
     * @return The HTTP response code (e.g., "400", "500").
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Sets the HTTP response code of the error.
     *
     * @param code The HTTP response code to set.
     */
    public void setCode(String code)
    {
        this.code = code;
    }

}
