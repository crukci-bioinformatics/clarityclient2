## Spring Configuration

The main Spring configuration class for the client is:

```
org.cruk.clarity.api.spring.ClarityClientConfiguration
```

Add this file to your Spring application context path. If you wish to use
the caching feature too, you'll also need to add the class:

```
org.cruk.clarity.api.cache.spring.ClarityClientCacheConfiguration
```

See the [caching page](caching.html) for more information on using
the cache.

In Spring annotation configuration, autowiring is correct for the normal
bean initialisation. Your combined `@Configuration` for your own program
would start looking like:

```Java
@Configuration
@Import({
    org.cruk.clarity.api.spring.ClarityClientConfiguration.class,
    org.cruk.clarity.api.cache.spring.ClarityClientCacheConfiguration.class,
    ...
})
public class MyClarityProgramConfiguration
{
}
```

Initialisation of the bean using properties or the setter methods can be
done with a `@PostConstruct` annotated method.
