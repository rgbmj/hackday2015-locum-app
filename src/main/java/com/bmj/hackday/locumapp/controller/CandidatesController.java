package com.bmj.hackday.locumapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.hackday.locumapp.model.Candidate;
import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.service.CandidatesService;

@RestController
public class CandidatesController {
	
	@Autowired
    private CandidatesService candidatesService;

	@RequestMapping(value = "/getcandidates", method = RequestMethod.POST)
    public List<Candidate> getCandidates(@RequestBody UserName username) {
        return candidatesService.getCandidates(username);
    }


}
