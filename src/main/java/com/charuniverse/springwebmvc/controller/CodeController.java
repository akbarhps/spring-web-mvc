package com.charuniverse.springwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CodeController {

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/products/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
    }
}
