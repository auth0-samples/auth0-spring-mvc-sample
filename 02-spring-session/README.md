# Spring Session example

This is a simple Java Spring MVC web application that is meant to be used as the starting point for [Auth0 Java Spring MVC Quickstart](https://auth0.com/docs/quickstart/webapp/java-spring-mvc). 

However, this sample builds on the Login Example by illustrating how to easily integrate with [Spring Session](http://projects.spring.io/spring-session/)

Since this sample is a Spring Boot application, it follows the []Spring Session for Spring Boot instructions](http://docs.spring.io/spring-session/docs/current/reference/html5/guides/boot.html#boot-sample)

In order to run this example you will need to have Java 7+, Maven, and Redis Server installed.

Check that your redis server is installed correctly:

```
redis-cli
```

There is a Dockerfile provided with this sample, so you can simply run Redis in a container to keep things simple if you prefer (rather than have to install on you host OS)


Check that your maven version is 3.0.x or above:

```sh
mvn -v
```

In order to build and run the project you must execute:

```sh
mvn spring-boot:run
```

Then, go to [http://localhost:3099/login](http://localhost:3099/login).

Shut it down manually with Ctrl-C.

Documentation: [Login](https://auth0.com/docs/quickstart/webapp/java-spring-mvc/01-login)


### How does Spring-Session work:

We just have to add the following maven (pom.xml) dependencies;

```
    <dependency>
        <groupId>org.springframework.session</groupId>
        <artifactId>spring-session</artifactId>
        <version>1.2.1.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-redis</artifactId>
    </dependency>
```

And we add an extra configuration class:

```
package com.auth0.example;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// tag::class[]
@EnableRedisHttpSession
public class HttpSessionConfig {
}
```

Now, session state will be stored in `Redis`. 

You can see this using `redis-cli` and inspecting the various keys, in particular the hash entry.

```
> type key  # hash
> hvals key  # corresponding to hash
```
