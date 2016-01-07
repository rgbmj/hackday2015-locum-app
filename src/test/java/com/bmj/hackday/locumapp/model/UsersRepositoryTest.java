package com.bmj.hackday.locumapp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bmj.hackday.locumapp.SpringJunitTestFixture;
import com.bmj.hackday.locumapp.model.bean.Grade;
import com.bmj.hackday.locumapp.model.bean.Specialty;

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
		Set<Specialty> results = usersRepository.getAllHospitalsSpecialties();
		
		assertNotNull(results);
		assertEquals(2, results.size());
		
		Set<Specialty> expected = new TreeSet<>();
		expected.add(new Specialty("geriatrics"));
		expected.add(new Specialty("paediatrics"));
		
		assertEquals(expected, results);
	}
	
	
	@Test
	public void testGetAllDoctorsSpecialties() {
		Set<Specialty> results = usersRepository.getAllDoctorsSpecialties();
		
		assertNotNull(results);
		assertEquals(5, results.size());
		
		Set<Specialty> expected = new TreeSet<>();
		expected.add(new Specialty("geriatrics"));
		expected.add(new Specialty("neurology"));
		expected.add(new Specialty("oncology"));
		expected.add(new Specialty("paediatrics"));
		expected.add(new Specialty("rheumatology"));
		
		assertEquals(expected, results);
	}

}
