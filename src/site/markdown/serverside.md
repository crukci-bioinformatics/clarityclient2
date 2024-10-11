## Using The CRUK-CI Client Within A Jakarta EE 10 Application Server

### Using the cache in an application server

There isn't anything inherently wrong with using the cache in a service
deployed in the application server, but if you leave the time objects can
remain in the cache too long you're more likely to get stale information
back from the client. We've found in practice that the cache is still very
useful on the server, but you don't want objects to live in it for much
longer than it takes to process individual calls to your service: one or
two minutes is fine. Remember that the cache is shared, so multiple
independent requests may hit the same objects in the cache when deployed
in a server. A stand alone program is not going to have the same
interference from different sources.

The cache definitions can be changed by creating a subclass of
`org.cruk.clarity.api.cache.spring.ClarityClientCacheConfiguration`
and changing the size and time definitions or the cache manager bean.
This is discussed in the (Caching page)[caching.html].
