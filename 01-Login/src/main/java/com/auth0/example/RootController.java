package com.auth0.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RootController extends HttpServlet {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected String getRoot(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        return "login";
    }
}
