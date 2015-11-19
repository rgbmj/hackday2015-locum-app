/**
 * This class has been generated by Fast Code Eclipse Plugin 
 * For more information please go to http://fast-code.sourceforge.net/
 * @author : rgill
 * Created : 10/22/2015 12:54:23
 */

package com.bmj.hackday.locumapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmj.hackday.locumapp.TestApplicationConfiguration;
import com.bmj.hackday.locumapp.model.Candidate;
import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.role.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplicationConfiguration.class)
@ActiveProfiles("test")
public class CandidatesServiceTest {

	@Autowired
	private CandidatesService candidatesService;

	/**
	 *
	 * @see com.bmj.hackday.locumapp.service.CandidatesService#getAllCandidates(UserName)
	 */
	@Test
	public void testGetCandidates_NullOrEmptyName_GivesEmptyList() {
		List<Candidate> candidates = candidatesService.getAllCandidates(null);
		assertTrue("candidates should be not null and length equal to 0", candidates != null && candidates.size() == 0);
	}
	
	@Test
	public void testGetCandidates_NullRoleToSearch_GivesEmptyList() throws Exception {
		UserRole roleToSearch = null;
		List<Candidate> candidates = candidatesService.getAllCandidates(roleToSearch);
		assertTrue("candidates should be not null and length equal to 0", candidates != null && candidates.size() == 0);
	}

	
	@Test
	public void testGetCandidates_HospitalRoleToSearch_GivesListOfHospitals() throws Exception {
		UserRole userrole = UserRole.HOSPITAL;
		List<Candidate> candidates = candidatesService.getAllCandidates(userrole);
		assertEquals("Candidates list size does not match", 5, candidates.size());
		
		
	}

	
	
}
