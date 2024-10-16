# File Store Access

The file store access through SFTP is now configurable, allowing the user to
pick a supporting library to upload and delete files in the file store.

## History

The original version of the Clarity Client used _spring-integration-sftp_ directly
in the client to access the file store. This at the time used
[JCraft's `JSch`](http://www.jcraft.com/jsch) library to do the low level SSH
communication. The update for this second version of the Clarity Client moved the
dependency on to Spring Integrations 6.3 and with it a change from `JSch` under
the hood to [Apache Mina SSHD](https://mina.apache.org/sshd-project). This
should have been almost invisible, hiding the detail behind the Spring wrapper of
[DefaultSftpSessionFactory](https://docs.spring.io/spring-integration/api/org/springframework/integration/sftp/session/DefaultSftpSessionFactory.html).

All so far so good: there were some changes to the dependencies but it should work.
Except of course it didn't. We found Apache Mina to behave very strangely, timing
out accessing a server where we knew that the SSH daemon was running and we had the
correct credentials. Indeed, the command line _sftp_ program worked as did the same
test in JSch.

To this end, the SFTP access to the file store has been abstracted away from the
client's code and put into classes that implement the new
[`ClaritySFTPUploader`](apidocs/org.cruk.clarity.api/org/cruk/clarity/api/sftp/ClaritySFTPUploader.html)
interface. Implementations are provided for Apache Mina and for JSch.

It is recommended to use Apache Mina SSHD if you can, as it is up to date whereas
JSch is very old now. If you have time out problems with Mina SSHD but the server
is accessible by other tools, then try switching to the JSch implementation.

## Picking an Implementation

### Apache Mina

Add the _clarity-client2-sftp-mina_ artefact to your project.

```XML
<dependency>
    <groupId>org.cruk.clarity</groupId>
    <artifactId>clarity-client2-filestore-mina</artifactId>
    <scope>runtime</scope>
</dependency>
```

This artefact will bring in the dependencies `org.apache.sshd:sshd-osgi`
and `org.apache.sshd:sshd-sftp`.

### JCraft JSch

Add the _clarity-client2-sftp-jsch_ artefact to your project.

```XML
<dependency>
    <groupId>org.cruk.clarity</groupId>
    <artifactId>clarity-client2-filestore-jsch</artifactId>
    <scope>runtime</scope>
</dependency>
```

This artefact will bring in the dependency `com.jcraft:jsch`.

### No Implementation

It should be noted that the client should work for uploading and downloading
files to and from the file store without SFTP access, instead sending uploads
through the Clarity API's file upload mechanism. There are however some
advantages of SFTP access:

1. The uploads can take place after a process has been completed. The HTTP
mechanism won't let files be uploaded to completed processes.
2. Files can be deleted from the file store. There isn't a mechanism for doing
this through HTTP (to my knowledge).

If your code does not to upload files to or delete files from the file store,
it would be sensible not to include either SFTP file store implementation.
