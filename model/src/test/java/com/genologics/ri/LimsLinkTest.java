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

package com.genologics.ri;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.genologics.ri.artifact.Artifact;
import com.genologics.ri.artifact.ArtifactLink;
import com.genologics.ri.artifactgroup.ArtifactGroup;
import com.genologics.ri.artifactgroup.ArtifactGroupLink;
import com.genologics.ri.sample.Sample;
import com.genologics.ri.sample.SampleLink;

public class LimsLinkTest
{
    static final String BASE = "https://claritydev.cruk.cam.ac.uk/api/v2/";

    public LimsLinkTest() { }

    static <E extends Locatable> void set(LimsLink<E> link, String id)
    {
        Class<E> clazz = link.getEntityClass();
        ClarityEntity anno = clazz.getAnnotation(ClarityEntity.class);
        requireNonNull(anno, clazz.getName() + " is not annotated with ClarityEntity.");
        URI u = URI.create(BASE + anno.uriSection() + "/" + id);
        link.setUri(u);
        if (link instanceof LimsEntityLinkable linkable)
        {
            linkable.setLimsid(id);
        }
    }

    static URI setPort(URI u, int port) throws URISyntaxException
    {
        return new URI(u.getScheme(), u.getUserInfo(), u.getHost(), port, u.getPath(), u.getQuery(), u.getFragment());
    }

    static URI setScheme(URI u, String scheme) throws URISyntaxException
    {
        return new URI(scheme, u.getUserInfo(), u.getHost(), u.getPort(), u.getPath(), u.getQuery(), u.getFragment());
    }

    @Test
    public void equalsDifferentEntityClass()
    {
        LimsEntityLink<Sample> sl = new SampleLink();
        set(sl, "1");

        LimsEntityLink<Artifact> al = new ArtifactLink(sl.getUri(), sl.getLimsid());

        assertEquals(sl.getUri(), al.getUri());

        assertFalse(LimsLink.equals(sl, al), "Links to different types of entities are equivalent.");
    }

    @Test
    public void equalsSameEntityClass()
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new com.genologics.ri.artifact.SampleLink(sl1.getUri(), sl1.getLimsid());

        assertEquals(sl1.getEntityClass(), sl2.getEntityClass());
        assertEquals(sl1.getUri(), sl2.getUri());

        assertTrue(LimsLink.equals(sl1, sl2), "Links to same types of entities but different link classes not are equivalent.");
    }

    @Test
    public void equalsDifferentURI()
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new SampleLink();
        set(sl2, "2");

        assertFalse(LimsLink.equals(sl1, sl2), "Links to different entities are equivalent.");
    }

    @Test
    public void equalsDifferentQuery()
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new SampleLink();
        set(sl2, "1");

        assertTrue(LimsLink.equals(sl1, sl2), "Links to the same entity are different.");

        sl1.setUri(URI.create(sl1.getUri().toString() + "?state=1234"));

        assertTrue(LimsLink.equals(sl1, sl2), "Links to the same entity with one query are different.");

        sl2.setUri(URI.create(sl2.getUri().toString() + "?state=2345"));

        assertTrue(LimsLink.equals(sl1, sl2), "Links to the same entity with two different queries are different.");
    }

    @Test
    public void equalsWithDefaultPort() throws URISyntaxException
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");
        URI u = sl1.getUri();

        LimsEntityLink<Sample> sl2 = new SampleLink();
        set(sl2, "1");

        assertTrue(LimsLink.equals(sl1, sl2), "Same URI is not equivalent.");

        sl1.setUri(setPort(u, 80));

        assertFalse(LimsLink.equals(sl1, sl2), "URI with port 80 for HTTPS is equivalent.");

        sl1.setUri(setPort(u, 443));

        assertTrue(LimsLink.equals(sl1, sl2), "URI with port 443 for HTTPS is not equivalent.");
    }

    @Test
    public void defaultPortsByScheme() throws URISyntaxException
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new SampleLink(sl1.getUri(), sl1.getLimsid());

        sl1.setUri(setPort(sl1.getUri(), 443));

        assertTrue(LimsLink.equals(sl1, sl2), "HTTPS with port 443 is not equal.");

        // Set scheme to HTTP but keep port 443.

        sl1.setUri(setScheme(sl1.getUri(), "http"));
        sl2.setUri(setScheme(sl2.getUri(), "http"));

        assertFalse(LimsLink.equals(sl1, sl2), "HTTP with port 443 is equal.");

        sl1.setUri(setPort(sl1.getUri(), 80));

        assertTrue(LimsLink.equals(sl1, sl2), "HTTP with port 80 is not equal.");

        // Likewise, try sftp with port 80.

        sl1.setUri(setScheme(sl1.getUri(), "sftp"));
        sl2.setUri(setScheme(sl2.getUri(), "sftp"));

        assertFalse(LimsLink.equals(sl1, sl2), "SFTP with port 80 is equal.");

        sl1.setUri(setPort(sl1.getUri(), 22));

        assertTrue(LimsLink.equals(sl1, sl2), "SFTP with port 22 is not equal.");
    }

    @Test
    public void hashCodeDifferentEntityClass()
    {
        LimsEntityLink<Sample> sl = new SampleLink();
        set(sl, "1");

        LimsEntityLink<Artifact> al = new ArtifactLink(sl.getUri(), sl.getLimsid());

        assertEquals(sl.getUri(), al.getUri());

        assertFalse(LimsLink.hashCode(sl) == LimsLink.hashCode(al), "Hash codes of different types of entities are equivalent.");
    }

    @Test
    public void hashCodeSameEntityClass()
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new com.genologics.ri.artifact.SampleLink(sl1.getUri(), sl1.getLimsid());

        assertEquals(sl1.getEntityClass(), sl2.getEntityClass());
        assertEquals(sl1.getUri(), sl2.getUri());

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code of same types of entities but different link classes not are equivalent.");
    }

    @Test
    public void hashCodeDifferentURI()
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new SampleLink();
        set(sl2, "2");

        assertFalse(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code of different entities are equivalent.");
    }

    @Test
    public void hashCodeDifferentQuery()
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new SampleLink();
        set(sl2, "1");

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code of the same entity are different.");

        sl1.setUri(URI.create(sl1.getUri().toString() + "?state=1234"));

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code of the same entity with one query are different.");

        sl2.setUri(URI.create(sl2.getUri().toString() + "?state=2345"));

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code of the same entity with two different queries are different.");
    }

    @Test
    public void hashCodeDefaultPorts() throws URISyntaxException
    {
        LimsEntityLink<Sample> sl1 = new SampleLink();
        set(sl1, "1");

        LimsEntityLink<Sample> sl2 = new SampleLink();
        set(sl2, "1");

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code of the same entity are different.");

        sl1.setUri(setPort(sl1.getUri(), 443));

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code with explicit port are different.");

        sl1.setUri(setScheme(sl1.getUri(), "http"));
        sl2.setUri(setScheme(sl2.getUri(), "http"));

        assertFalse(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code with HTTP and port 443 are the same.");

        sl1.setUri(setPort(sl1.getUri(), 80));

        assertTrue(LimsLink.hashCode(sl1) == LimsLink.hashCode(sl2), "Hash code with HTTP and port 80 are different.");
    }

    @Test
    public void testToString()
    {
        LimsEntityLink<Sample> sl = new SampleLink();
        set(sl, "1");

        assertEquals("LimsLink<Sample>[1]", LimsLink.toString(sl));

        // Try clearing the explicit id. Should still get it from the URI.

        sl.setLimsid(null);
        assertEquals("LimsLink<Sample>[1]", LimsLink.toString(sl));

        // Try with a link that doesn't implement LimsEntityLink. Should
        // still get an id from the URI.

        LimsLink<ArtifactGroup> agl = new ArtifactGroupLink();
        set(agl, "40");

        assertEquals("LimsLink<ArtifactGroup>[40]", LimsLink.toString(agl));
    }
}
