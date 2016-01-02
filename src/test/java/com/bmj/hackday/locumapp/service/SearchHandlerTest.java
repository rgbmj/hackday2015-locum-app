package com.bmj.hackday.locumapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bmj.hackday.locumapp.SpringJunitTestFixture;
import com.bmj.hackday.locumapp.model.UserDetail;

public class SearchHandlerTest extends SpringJunitTestFixture {

	@Autowired
	SearchHandler searchHandler;

	@Test
	public void testGetSearchCandidates_NullRole_GivesEmpty() {
		SearchParams searchParams = createSearchParams("consultant", "B4 7EA", null, "geriatrics");

		List<UserDetail> result = searchHandler.getSearchedCandidates(searchParams);
		assertNotNull("result is null", result);
		assertEquals("result is not empty", 0, result.size());
	}

	
	@Test
	public void testGetSearchCandidates_Doctors() {
		SearchParams searchParams = createSearchParams("registrar", "B4 7EA", "doctor", "geriatrics");

		List<UserDetail> candidates = searchHandler.getSearchedCandidates(searchParams);
		assertNotNull("Candidates list is null", candidates);
		assertEquals("result size does not match", 2, candidates.size());
	}


	
	
	
	private SearchParams createSearchParams(String grade, String postcode, String roleToSearch, String specialty) {
		SearchParams searchParams = new SearchParams();
		searchParams.setGrade(grade);
		searchParams.setPostcode(postcode);
		searchParams.setRole(roleToSearch);
		searchParams.setSpecialty(specialty);
		return searchParams;
	}

}
