# Adaptation of commons-beanutils

The Apache Commons `commons-beanutils` library is used by the client to access
some bean style getter and setter methods using its `PropertyUtils` class and
some type conversions using `ConvertUtils`. This library was very old and certainly
didn't fit well with the Java 9+ module system.

We've taken a copy of the `commons-beanutils` 1.9.4 code and updated it to
both be in a proper module and to use newer dependencies. The changes in our 1.10.x
versions are these:

1. Compile with OpenJDK 11.
2. Addition of `module-info.java` to the code, putting the code into a package
`org.apache.commons.beanutils`.
3. Removed dependencies on _commons-logging_ and _commons-collections_.
4. Added dependency on _commons-collections4_. This is marked as optional in the
POM; whether it is optional will depend on which parts of the library you are using.
5. Commented out all logging calls, which were going to _commons-logging_.
6. Changed _commons-collection_ classes to their _commons-collections4_
equivalents.
7. Changed references to `org.apache.commons.collections.FastHashMap` from
_commons-collection_ to `java.util.concurrent.ConcurrentHashMap`. This is as
advised in the
[Commons Collections 4 release note](https://commons.apache.org/proper/commons-collections/release_4_0.html).
8. Changed references to `WeakFastHashMap` in `PropertyUtils` to use
`java.util.WeakHashMap`.

This code is deployed as a Maven artefact with source JAR in our publicly available
repository as described on [the installation page](installing.html). The code is
not deployed on GitHub as the original code is not either. If anyone needs to see
the source we can supply it.

The web site for `commons-beanutils` is https://commons.apache.org/proper/commons-beanutils
