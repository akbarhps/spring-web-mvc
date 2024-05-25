package com.charuniverse.springwebmvc.controller;

import com.charuniverse.springwebmvc.Service.HelloService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(path = "/hello")
    public void helloWorld(@RequestParam(name = "name", required = false) String name,
                           HttpServletResponse response) throws IOException {
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/web/hello")
    public ModelAndView helloWorld(@RequestParam(name = "name", required = false) String name) {
        if (name == null) {
            return new ModelAndView("redirect:/web/hello?name=Guest");
        }

        return new ModelAndView("hello", Map.of(
                "title", "View menggunakan kumis",
                "name", name
        ));
    }
}
