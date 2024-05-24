package com.charuniverse.springwebmvc.controller;

import com.charuniverse.springwebmvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    @PostMapping(
            path = "/person",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createPerson(@ModelAttribute CreatePersonRequest request) {
        System.out.println(request);
        System.out.println(request.getAddress());
        System.out.println(request.getHobbies());
        System.out.println(request.getSocialMedias());

        return "Success create person " +
                request.getFirstName() + " " +
                request.getMiddleName() + " " +
                request.getLastName() + " with email " +
                request.getEmail() + " and phone " +
                request.getPhone() + " and address " +
                request.getAddress().getStreet() + " " +
                request.getAddress().getCity() + " " +
                request.getAddress().getCountry() + " " +
                request.getAddress().getPostalCode() + " " +
                request.getSocialMedias();
    }
}
