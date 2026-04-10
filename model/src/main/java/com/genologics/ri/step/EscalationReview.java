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

package com.genologics.ri.step;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.genologics.ri.jaxb.LongTimestampAdapter;

import com.genologics.ri.Linkable;
import com.genologics.ri.researcher.Researcher;

/**
 * Represents an escalation review in a step.
 *
 * @since 2.18
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "escalation-review", propOrder = { "author", "date", "comment" })
public class EscalationReview implements Serializable
{
    /**
     * Class version for serialisation.
     */
    @Serial private static final long serialVersionUID = -4529608991906508233L;

    /**
     * The author of the escalation review.
     */
    @XmlElement
    protected UserLink author;

    /**
     * The date of the escalation review.
     */
    @XmlElement
    @XmlSchemaType(name = "dateTime")
    @XmlJavaTypeAdapter(LongTimestampAdapter.class)
    protected Date date;

    /**
     * Comment for the escalation review.
     */
    @XmlElement
    protected String comment;

    /**
     * Gets the author.
     *
     * @return The author.
     */
    public UserLink getAuthor()
    {
        return author;
    }

    /**
     * Sets the author.
     *
     * @param link The linkable researcher.
     */
    public void setAuthor(Linkable<Researcher> link)
    {
        this.author = new UserLink(link);
    }

    /**
     * Gets the date.
     *
     * @return The date.
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date The date.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Gets the comment.
     *
     * @return The comment.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment The comment.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

}
