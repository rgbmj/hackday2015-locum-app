package com.bmj.hackday.locumapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.service.CandidatesService;
import com.bmj.hackday.locumapp.service.SearchParams;

@RestController
public class SearchController {
	
	@Autowired
    private CandidatesService candidatesService;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<UserDetail> getCandidates(@RequestBody SearchParams searchParams) {
        return candidatesService.getSoughtCandidates(searchParams);
    }


}
