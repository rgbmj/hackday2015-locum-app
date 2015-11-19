package com.bmj.hackday.locumapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmj.hackday.locumapp.TestApplicationConfiguration;
import com.bmj.hackday.locumapp.model.Candidate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplicationConfiguration.class)
@ActiveProfiles("test")
public class SearchHandlerTest {

	@Autowired
	SearchHandler searchHandler;

	@Test
	public void testGetSearchCandidates_NullRole_GivesEmpty() {
		SearchParams searchParams = createSearchParams("consultant", "B4 7EA", null, "geriatrics");

		List<Candidate> result = searchHandler.getSearchedCandidates(searchParams);
		assertNotNull("result is null", result);
		assertEquals("result is not empty", 0, result.size());
	}

	
	@Test
	public void testGetSearchCandidates_Doctors() {
		SearchParams searchParams = createSearchParams("registrar", "B4 7EA", "doctor", "geriatrics");

		List<Candidate> candidates = searchHandler.getSearchedCandidates(searchParams);
		assertNotNull("result is null", candidates);
		assertEquals("result size does not match", 3, candidates.size());
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
