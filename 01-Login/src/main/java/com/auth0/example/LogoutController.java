package com.auth0.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
public class LogoutController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String domain;
    private final String clientId;

    public LogoutController(AppConfig config){
        domain = config.getDomain();
        clientId = config.getClientId();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected String logout(final HttpServletRequest req) {
        logger.debug("Performing logout");
        invalidateSession(req);
        String returnTo = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
        String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s", domain, clientId, returnTo);
        return "redirect:" + logoutUrl;
    }

    private void invalidateSession(HttpServletRequest request) {
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
    }

}
