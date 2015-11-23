package com.bmj.hackday.locumapp.model;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmj.hackday.locumapp.TestApplicationConfiguration;
import com.bmj.hackday.locumapp.role.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplicationConfiguration.class)
@ActiveProfiles("test")
public class MatcherRepositoryTest {

	
	@Autowired
	MatcherRepository repository;  
	
	@Before
	public void setUp() throws Exception {
		repository.clear();
	}
	
	@Test
	public void testGetChoices_NullInEmptyOut() {
		String id = "ravinder";
		CandidatesChoices choices = null;
		repository.saveChoices(choices);
		List<String> result = repository.getDoctorMatches(id);

		assertNotNull("Result is null,", result);
		assertTrue("Results is not empty", result.size() == 0);
	}


	
	@Test
	public void testGetChoices_NonNullInNonNullOut() {
		String docId = "doc1";		
		CandidatesChoices docChoices = createChoices(docId, DOCTOR, "hospital1", "hospital2");
		repository.saveChoices(docChoices);
		
		String hospitalId = "hospital1";		
		CandidatesChoices hospitalChoices = createChoices(hospitalId, HOSPITAL, "doc1", "doc2");
		repository.saveChoices(hospitalChoices);
		
		List<String> hospitalChoosers = repository.getDoctorMatches(docId);
		List<String> doctorChoosers = repository.getHospitalMatches(hospitalId);

		assertResult(hospitalId, hospitalChoosers);
		assertResult(docId, doctorChoosers);
	}



	private void assertResult(String chosenToTest, List<String> choosers) {
		assertNotNull("Result is null,", choosers);
		
		assertTrue("Result does not contain " + chosenToTest, choosers.contains(chosenToTest));
	}



	private CandidatesChoices createChoices(String id, UserRole userRole, String... choices) {
		CandidatesChoices candidatesChoices = new CandidatesChoices(id, userRole);
		
		for (String choice : choices)
			candidatesChoices.addChoice(choice);
		
		return candidatesChoices;
	}
}
