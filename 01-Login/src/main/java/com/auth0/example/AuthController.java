package com.auth0.example;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthController {

    private final AuthenticationController controller;

    @Autowired
    public AuthController(AppConfig config) {
        // JwkProvider required for RS256 tokens. If using HS256, do not use.
        JwkProvider jwkProvider = new JwkProviderBuilder(config.getDomain()).build();
        controller = AuthenticationController.newBuilder(config.getDomain(), config.getClientId(), config.getClientSecret())
                .withJwkProvider(jwkProvider)
                .build();
    }

    Tokens handle(HttpServletRequest request, HttpServletResponse response) throws IdentityVerificationException {
        return controller.handle(request, response);
    }

    String buildAuthorizeUrl(HttpServletRequest request, HttpServletResponse response, String redirectUri) {
        return controller
                .buildAuthorizeUrl(request, response, redirectUri)
                .build();
    }

}
