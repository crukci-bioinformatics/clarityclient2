## Setting up the Record and Playback Wrappers

### Spring Configuration

You need to configure the code to include the main client configuration
class plus either the recording or playback configuration classes.

Thus for recording:

```Java
@Configuration
@Import({
    org.cruk.clarity.api.spring.ClarityClientConfiguration.class,
    org.cruk.clarity.api.record.spring.ClarityClientRecordConfiguration.class,
    ...
})
public class MyRecordingConfiguration
{
}
```

And for play back:

```Java
@Configuration
@Import({
    org.cruk.clarity.api.spring.ClarityClientConfiguration.class,
    org.cruk.clarity.api.playback.spring.ClarityClientPlaybackConfiguration.class,
    ...
})
public class MyPlaybackConfiguration
{
}
```

It is recommended to use the Spring Test module (`spring-test`). Our tests
are written for JUnit 5, and for these there are some convenience Spring
configuration classes provided to help with this. A test class needs to be annotated
to use the Spring test system and initialised with a recording or playback configuration:

```Java
@SpringJUnitConfig({
    ClarityClientConfiguration.class,
    ClarityClientRecordConfiguration.class or ClarityClientPlaybackConfiguration.class
})
```

The cache might be useful when recording but serves no purpose on playback.

Typically one may use the recording class to get the actual results from
a real Clarity server, then switch to the playback configuration to run the tests
from the recorded files. Don't forget to check the recorded files into source control.

Test classes annotated as above become Spring beans themselves, and as such can
have dependencies injected. For example:

```Java
@Autowired
ClarityAPI api;
```

### Setting the Message Directory

The record and playback wrappers around the Clarity client need no additional
configuration beyond what is supplied in the Spring files. The one property that
the user might want to change is the directory the server's messages are written
to, or the pretend server reads from.

By default, both the recording and playback aspects write and read into a
directory `serverexchanges` in the current working directory. This can be
configured by setting the `messageDirectory` property in Spring configuration,
or injecting the aspect into the unit test class code and setting the property:

```Java
@SpringJUnitConfig({
    ClarityClientConfiguration.class,
    ClarityClientPlaybackConfiguration.class
})
public class MyUnitTest
{
    @Autowired(required = false)
    ClarityAPIPlaybackAspect playbackAspect;

    File recordedMessageDirectory = new File("src/test/servermessages");

    @PostConstruct
    public void setPlaybackDirectory()
    {
        if (playbackAspect != null)
        {
            playbackAspect.setMessageDirectory(recordedMessageDirectory);
        }
    }
}
```

This mechanism works for recording too. Just inject `ClarityAPIRecordingAspect`
instead of `ClarityAPIPlaybackAspect`. This directory is not automatically created,
so when recording make sure that it exists before communicating with the server.

### Setting the Updates Directory during Playback

The playback wrapper returns results from previously recorded calls to
the API's load, retrieve, load, find and list methods, finding the matching
file in the messages directory, unmarshalling its XML and returning the object
as the real API would. It quietly ignores create, delete and upload methods.
Update calls can either by also quietly ignored, or they can be recorded
in a separate directory. If one sets the `updatesDirectory`, any update calls
will have the new versions of the entities written here with an incrementing
index number.

For example, a sample with the id `S1234` has been read from the server
and is recorded in the messages directory in a file `Sample-S1234.xml`.
Each call to the API's `update` or `updateAll` methods for this sample will
result in a file being added to the updates directory. The first will be
`Sample-S1234.000.xml`, a second update will write `Sample-S1234.001.xml`
and so forth. These updates can be checked as part of unit tests.

Update calls are ignored unless the `updatesDirectory` is set, either in
Spring configuration or in code. Following from the example above, the latter
would be done thus:

```Java
@PostConstruct
public void setPlaybackDirectory()
{
    if (playbackAspect != null)
    {
        playbackAspect.setMessageDirectory(recordedMessageDirectory);
        playbackAspect.setUpdatesDirectory(new File("target/updates"));
    }
}
```

### Recording Searches

The results of the `find` call of the API are also recorded alongside the
entities themselves and are used on playback to list the entities found by that
search so the tests can run without going back to the real server which,
assuming it is still available, may return different results from when the
unit tests were created. These searches are recorded in files named
`search_&lt;hash&gt;.xml`, where the hash is the hexadecimal hash of the
type of entity searched for and the names and values of the search terms.

By default, searches that return no results are not written to a file on
recording and corresponding on playback a search that is not recorded quietly
returns no results. It was found that some test code would execute a lot of
searches with nothing returned for them resulting in a lot of search files
saved that serve little purpose. Assuming a search that is not recorded just
returned nothing saves having to store most of these files.

The "not recorded means no results" behaviour can be made more strict, so all searches
are recorded and a missing search file results in an error.
The recorder can be set to record all searches with the
`setRecordSearchesWithoutResults` method on `ClarityAPIRecordingAspect`,
and the play back set to demand a search is recorded with the
`setFailOnMissingSearch` method on `ClarityAPIPlaybackAspect`.
