# CRUK-CI Clarity API Java Client

The Cancer Research UK Cambridge Institute (CRUK-CI) Clarity Java Client
provides the Java or Groovy developer a means to work with
[Clarity's REST API](https://d10e8rzir0haj8.cloudfront.net/6.3/REST.html) using objects
rather than XML or DOM document trees.

It provides a single interface to perform (almost) all the operations
supported by the Clarity REST API with XML to Java object conversion,
error handling and, optionally, client side caching. The developer works
with Java objects that map onto the XML documents described by Illumina's
Clarity API documentation.

It uses the JAXB object to XML binding mechanism to convert the XML
messages sent to and received from Clarity's REST API. The communication
uses Apache's HTTP Java client and Spring's REST client. Spring is used
throughout this tool.

## Features

1. Automatic conversion between XML and Java objects.
2. Automatic handling of exceptions from the server.
3. Automatic and transparent use of batch retrieve, update and create
mechanisms where available.
4. Creation of files with the upload to the file store (likewise file
removal).
5. Optional transparent caching mechanism.
6. Debugging classes to show traffic and timings between the client
and server.


## Building

Having got this check out of the code, run:

```
mvn install
```

This will build and install the project into your local Maven cache.
You'll need Maven 3.6.3 or newer.

Alternatively, you can add our Maven repository to your POM and let
Maven do the work. Add a &lt;repositories&gt; section containing:

```XML
<repository>
    <id>crukci-bioinformatics</id>
    <url>https://content.cruk.cam.ac.uk/bioinformatics/maven</url>
    <releases>
        <enabled>true</enabled>
    </releases>
    <snapshots>
        <enabled>false</enabled>
    </snapshots>
</repository>
```

### Building the Site

Building the site needs a different profile to building the source code,
and needs to aggregate into a multi module Maven site. The command to build
the site is:

```
mvn -P sitebuild clean site site:stage
```

The site is built into the `target/staging` directory. This then forms the
site deployed on the project's
[GitHub Pages](https://crukci-bioinformatics.github.io/clarityclient2).

## Usage (for Maven)

Add the BOM artifact to the `dependencyManagement` section of your POM:

```XML
<dependencyManagement>
    <dependency>
        <groupId>org.cruk.clarity</groupId>
        <artifactId>clarity-client2-bom</artifactId>
        <version>...</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
</dependencyManagement>
```

_Fill in the <version> tag with the version of the API._

Add the JAR files to your `dependencies` section:

```XML
<dependencies>
    <dependency>
        <groupId>org.cruk.clarity</groupId>
        <artifactId>clarity-client2</artifactId>
    </dependency>
    <dependency>
        <groupId>org.cruk.clarity</groupId>
        <artifactId>clarity-client2-cache</artifactId>
    </dependency>
    <dependency>
        <groupId>org.cruk.clarity</groupId>
        <artifactId>clarity-client2-recorder</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

The `clarity-client2-cache` artefact is optional but will usually
be recommended to make the client more performant. The
`clarity-client2-recorder` artefact should only ever be included
in the _test_ scope: it is for recording messages from a real server
and playing them back as repeatable unit tests.

For details of using the client, please refer to the documentation at
https://crukci-bioinformatics.github.io/clarityclient2

## Clarity 6

The 2.34.x versions of the library work with Clarity 6.3,
supporting the corresponding versions of the
[Clarity API](https://d10e8rzir0haj8.cloudfront.net/6.3/REST.html).

## Java Version

The Clarity client is built with Java 17 source and bytecode. Jakarta EE 10
brings some dependencies compiled for this version of Java, so that is the
oldest version now supported.

## JAXB Implementation

The Java EE modules used by the client, specifically JAXB, comply
with [Jakarta EE 10](https://jakarta.ee/release/10) specifications.

The POM will pull in the Jakarta JAXB API (version 4) that the code needs to
compile. One should add a JAXB implementation to the final POM, such as:

```XML
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>4.0.6</version>
    <scope>runtime</scope>
</dependency>
```

The scope should be `runtime` for building stand alone applications
using the client. Where one has created another tool that uses the API
but isn't itself a final application, the scope should be `test` if
unit tests need to use the client (if not, this dependency isn't needed).
Where the client is part of an EE container, the container will supply
the JAXB implementation.
