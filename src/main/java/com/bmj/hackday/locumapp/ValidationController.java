package com.bmj.hackday.locumapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.service.ValidatorService;
import com.bmj.hackday.locumapp.validation.ValidationResponse;

@RestController
public class ValidationController {

	@Autowired
    private ValidatorService validatorService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ValidationResponse validateUser(@RequestBody UserName username) {
        return validatorService.getValidationDetails(username);
    }

}