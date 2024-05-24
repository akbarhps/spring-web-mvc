package com.charuniverse.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @ResponseBody
    @GetMapping(path = "/date")
    public String getDate(@RequestParam(name = "date") Date date) {
        return "Date: " + dateFormat.format(date);
    }
}
