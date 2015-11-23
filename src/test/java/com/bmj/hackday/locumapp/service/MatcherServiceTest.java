package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmj.hackday.locumapp.TestApplicationConfiguration;
import com.bmj.hackday.locumapp.model.CandidatesChoices;
import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.role.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplicationConfiguration.class)
@ActiveProfiles("test")
public class MatcherServiceTest {

	@Autowired
	private MatcherService matcherService;

	@Test
	public void testGetMatches() {

		String hospitalId = "hospital1";
		String docId = "doc1";

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
		boolean contains = false;
		for (UserDetail choice : chosen)
			contains = choice.getId().equals(idToTest);

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
