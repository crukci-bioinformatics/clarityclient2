## CRUK-CI Clarity API Java Client

The Cancer Research UK Cambridge Institute (CRUK-CI) Clarity Java Client
provides the Java or Groovy developer a means to work with Clarity's REST
API using objects rather than XML or DOM document trees.

It provides a single interface to perform (almost) all the operations
supported by the Clarity REST API with XML to Java object conversion,
error handling and, optionally, client side caching. The developer works
with Java objects that map onto the XML documents described by Illumina's
API documentation.

It uses the JAXB object to XML binding mechanism to convert the XML
messages sent to and received from Clarity's REST API. The communication
uses Apache's HTTP Java client and Spring's REST client. Spring is used
throughout this tool.

### Features

1. Automatic conversion between XML and Java objects.
2. Automatic handling of exceptions from the server.
3. Automatic and transparent use of batch retrieve, update and create mechanisms where available.
4. Creation of files with the upload to the file store (likewise file removal).
5. Optional transparent caching mechanism.
6. Debugging classes to show traffic and timings between the client and server.

## Clarity Client version 2

Version 2 of the client is a port of the original project updated to work
with Jakarta EE10. It is written for Java 17 and has embraced the Java 9+
module system. It is also refactored to be a multi-module project for Maven
with the model classes derived from the XML schemas now in their own artefact
and the cache also moved into its own artefact, allowing a more modular
use of the code. The artifacts and modules are:

1. `clarity-client2-model`: The model classes derived from the schemas and
annotated for serialisation with JAXB. The Java module for these classes is
`com.genologics.ri`.
2. `clarity-client2`: The main client classes, Java module `org.cruk.clarity.api`.
3. `clarity-client2-cache`: The caching classes and configuration,
Java module `org.cruk.clarity.api.cache`.
4. `clarity-client2-recorder`: The recording and playback classes to support
repeatable unit tests, Java module `org.cruk.clarity.api.recorder`.
5. `clarity-client2-filestore-mina`: An SFTP file store implementation using
Apache Mina SSHD as the underlying library.
6. `clarity-client2-filestore-jsch`: An SFTP file store implementation using
JCraft JSch as the underlying library.

The client has kept the `com.genologics.ri` namespace for the model classes because
that namespace is still what is used in the XSD files provided by Illumina. It follows
from the namespace that the Java module for these classes is therefore
`com.genologics.ri`.
