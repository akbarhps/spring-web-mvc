package com.charuniverse.springwebmvc.controller;

import com.charuniverse.springwebmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class PersonController {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request,
                                               BindingResult bindingResult) {
        System.out.println(request);
        System.out.println(request.getAddress());
        System.out.println(request.getHobbies());
        System.out.println(request.getSocialMedias());

        List<FieldError> errors = bindingResult.getFieldErrors();
        if (!errors.isEmpty()) {
            errors.forEach(error -> System.out.println(error.getField() + " : " + error.getDefaultMessage()));
            return ResponseEntity.badRequest().body("You send invalid data");
        }

        String response = "Success create person " +
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
        return ResponseEntity.ok(response);
    }
}
