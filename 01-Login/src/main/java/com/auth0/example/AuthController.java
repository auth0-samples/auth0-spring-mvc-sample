package com.auth0.example;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthController {

    private final AuthenticationController controller;
    private final String userInfoAudience;

    @Autowired
    public AuthController(AppConfig config) {
        controller = AuthenticationController.newBuilder(config.getDomain(), config.getClientId(), config.getClientSecret())
                .build();
        userInfoAudience = String.format("https://%s/userinfo", config.getDomain());
    }

    public Tokens handle(HttpServletRequest request) throws IdentityVerificationException {
        return controller.handle(request);
    }

    public String buildAuthorizeUrl(HttpServletRequest request, String redirectUri) {
        return controller
                .buildAuthorizeUrl(request, redirectUri)
                .withAudience(userInfoAudience)
                .build();
    }

}
