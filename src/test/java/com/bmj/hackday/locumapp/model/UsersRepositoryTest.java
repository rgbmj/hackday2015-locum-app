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
		Set<Grade> results = usersRepository.getAllHospitalsGrades();

		assertNotNull(results);
		assertEquals(2, results.size());
		
		Set<Grade> expected = new TreeSet<>();
		expected.add(new Grade("consultant"));
		expected.add(new Grade("registrar"));
		
		assertEquals(expected, results);
	}
	
	
	@Test
	public void testGetAllDoctorsGrades() {
		Set<Grade> results = usersRepository.getAllDoctorsGrades();
		
		assertNotNull(results);
		assertEquals(3, results.size());
		
		Set<Grade> expected = new TreeSet<>();
		expected.add(new Grade("consultant"));
		expected.add(new Grade("foundation_2"));
		expected.add(new Grade("registrar"));
		
		assertEquals(expected, results);
	}

	
	@Test
	public void testGetAllHospitalsSpecialties() {
		Set<String> results = usersRepository.getAllHospitalsSpecialties();
		
		assertNotNull(results);
		assertEquals(2, results.size());
		
		Set<String> expected = new TreeSet<>();
		expected.add("geriatrics");
		expected.add("paediatrics");
		
		assertEquals(expected, results);
	}
	
	
	@Test
	public void testGetAllDoctorsSpecialties() {
		Set<String> results = usersRepository.getAllDoctorsSpecialties();
		
		assertNotNull(results);
		assertEquals(5, results.size());
		
		Set<String> expected = new TreeSet<>();
		expected.add("geriatrics");
		expected.add("neurology");
		expected.add("oncology");
		expected.add("paediatrics");
		expected.add("rheumatology");
		
		assertEquals(expected, results);
	}

}
