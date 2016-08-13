package com.auth0.example;

import com.auth0.web.Auth0Config;
import com.auth0.web.Auth0Filter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Holds the default configuration for the library
 * Taken from properties files
 * <p>
 * Also initialises the Filter Servlet (Auth0Filter) for
 * secured URL endpoint interception
 */
@Component
@Configuration

public class AppConfig extends Auth0Config {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        final FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Auth0Filter(this));
        registration.addUrlPatterns(securedRoute);
        registration.addInitParameter("redirectOnAuthError", loginRedirectOnFail);
        registration.setName("Auth0Filter");
        return registration;
    }

}
