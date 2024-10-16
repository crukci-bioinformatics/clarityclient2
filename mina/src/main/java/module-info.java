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

import org.cruk.clarity.api.filestore.ClaritySFTPUploader;
import org.cruk.clarity.api.filestore.mina.ClarityMinaSSHFileUploader;

/**
 * Apache Mina SSHD implementation of SFTP access for the Clarity Client.
 *
 * @see <a href="https://mina.apache.org/sshd-project">Apache Mina SSHD project</a>
 */
module org.cruk.clarity.api.filestore.mina
{
    provides ClaritySFTPUploader with ClarityMinaSSHFileUploader;

    requires transitive com.genologics.ri;
    requires transitive org.cruk.clarity.api;

    requires org.apache.sshd.osgi;
    requires org.apache.sshd.sftp;

    requires org.apache.commons.io;
    requires org.apache.commons.lang3;

    requires org.slf4j;

    requires transitive spring.context;

    opens org.cruk.clarity.api.filestore.mina to spring.beans, spring.core;
}
