package com.auth0.example;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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

    Tokens handle(HttpServletRequest request) throws IdentityVerificationException {
        return controller.handle(request);
    }

    String buildAuthorizeUrl(HttpServletRequest request, String redirectUri) {
        return controller
                .buildAuthorizeUrl(request, redirectUri)
                .build();
    }

}
