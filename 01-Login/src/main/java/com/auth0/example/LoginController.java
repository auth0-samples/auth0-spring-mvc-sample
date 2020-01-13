package com.auth0.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@Controller
public class LoginController {

    @Autowired
    private AuthController controller;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    protected String login(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Performing login");
        String redirectUri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/callback";
        String authorizeUrl = controller.buildAuthorizeUrl(request, response, redirectUri);
        return "redirect:" + authorizeUrl;
    }

}
