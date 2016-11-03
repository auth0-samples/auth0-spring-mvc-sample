# Starter Seed for Auth0-Java Spring MVC Quickstart Guides

This is a simple Java Spring MVC web application that is meant to be used as the starting point for [Auth0 Java Spring MVC Quickstart](https://auth0.com/docs/quickstart/webapp/java-spring-mvc). 

Start by renaming the `auth0.properties.example` file in `src/main/resources` to `auth0.properties` and provide your application's domain, issuer, clientID, and client secret.

In order to run this example you will need to have Java 7+ and Maven installed.

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

Documentation: [Introduction](https://auth0.com/docs/quickstart/webapp/java-spring-mvc)

