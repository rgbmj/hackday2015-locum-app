package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bmj.hackday.locumapp.SpringJunitTestFixture;
import com.bmj.hackday.locumapp.model.CandidatesChoices;
import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.role.UserRole;

public class MatcherServiceTest extends SpringJunitTestFixture {

	@Autowired
	private MatcherService matcherService;

	@Test
	public void testGetMatches() {

		String hospitalId = "bch";
		String docId = "adrian";

		CandidatesChoices hospitalChoices = createCandidatesChoices(hospitalId, HOSPITAL, docId, "someDoctor");
		CandidatesChoices doctorChoices = createCandidatesChoices(docId, DOCTOR, hospitalId, "someHospital");

		matcherService.saveChoices(hospitalChoices);
		matcherService.saveChoices(doctorChoices);

		List<UserDetail> hospitalChoosers = matcherService.getHospitalMatches(hospitalId);
		List<UserDetail> doctorChoosers = matcherService.getDoctorMatches(docId);

		assertMatches(hospitalId, docId, hospitalChoosers, doctorChoosers);
	}

	
	private void assertMatches(String hospitalId, String docId, List<UserDetail> hospitalChoosers, List<UserDetail> doctorChoosers) {
		assertChosen("Hospital", hospitalId, doctorChoosers);
		assertChosen("Doctor", docId, hospitalChoosers);
	}


	private void assertChosen(String type, String idToTest, List<UserDetail> chosen) {
		assertNotNull("Chosen is null", chosen);

		boolean contains = false;
		for (UserDetail choice : chosen) {
			assertNotNull("Choice is null", choice);
			contains = choice.getId().equals(idToTest);
		}

		assertTrue(type + " ID '" + idToTest + "' not found in matches.", contains);

	}

	
	private CandidatesChoices createCandidatesChoices(String id, UserRole userRole, String... idChoices) {
		if (idChoices == null || idChoices.length == 0)
			throw new IllegalArgumentException("No choices were declared");
		
		CandidatesChoices choices = new CandidatesChoices(id, userRole);
		
		for (String choice : idChoices)
			choices.addChoice(choice);
		
		return choices;
	}

}
