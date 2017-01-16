package com.auth0.example;

import com.auth0.web.Auth0Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Auth0Config auth0Config;

    @Autowired
    public HomeController(Auth0Config auth0Config) {
        this.auth0Config = auth0Config;
    }
}
