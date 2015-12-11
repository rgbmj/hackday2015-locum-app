package com.bmj.hackday.locumapp.model;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bmj.hackday.locumapp.SpringJunitTestFixture;

public class UsersRepositoryTest extends SpringJunitTestFixture {

	@Autowired
	UsersRepository usersRepository ;
	
	@Test
	public void testGetAllHospitalsGrades() {
		Set<String> results = usersRepository.getAllHospitalsGrades();

		assertNotNull(results);
		assertEquals(2, results.size());
		
		Set<String> expected = new TreeSet<>();
		expected.add("consultant");
		expected.add("registrar");
		
		assertEquals(expected, results);
	}
	
	
	@Test
	public void testGetAllDoctorsGrades() {
		Set<String> results = usersRepository.getAllDoctorsGrades();
		
		assertNotNull(results);
		assertEquals(3, results.size());
		
		Set<String> expected = new TreeSet<>();
		expected.add("consultant");
		expected.add("foundation_2");
		expected.add("registrar");
		
		assertEquals(expected, results);
	}

}
