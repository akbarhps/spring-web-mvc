package com.charuniverse.springwebmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @ResponseBody
    @PostMapping(
            path = "/form/hello",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    public String hello(@RequestParam(name = "name") String name) {
        return """
                <html>
                    <body>
                        <h1>Hello $name</h1>
                    </body>
                </html> 
                """.replace("$name", name);
    }
}