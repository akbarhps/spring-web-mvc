package com.charuniverse.springwebmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping(path = "/error")
    public ResponseEntity<String> error(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        String html = """
                <html>
                    <head>
                        <title>Error Page</title>
                    </head>
                    <body>
                        <h1>Error Page</h1>
                        <p>Status Code: $code</p>
                        <p>Message: $message</p>
                    </body> 
                """.replace("$code", status.toString()).replace("$message", message);
        return ResponseEntity.status(status).body(html);
    }

}
