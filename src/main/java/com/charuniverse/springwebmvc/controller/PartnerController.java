package com.charuniverse.springwebmvc.controller;

import com.charuniverse.springwebmvc.model.Partner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PartnerController {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/partner/current")
    public String getPartner(Partner partner) {
        return partner.getId() + " : " + partner.getName();
    }
}
