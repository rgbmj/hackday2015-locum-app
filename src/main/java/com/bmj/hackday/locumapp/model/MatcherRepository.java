package com.bmj.hackday.locumapp.model;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.role.UserRole;

@Component
public class MatcherRepository {

	
	/**
	 * Holds chosen ids made by various {@link UserRole}s .
	 * <p>
	 * Each UserRole  has many ids that are the chose.  Each chosen id 
	 * holds a list of ids who chose them.
	 */
	final Map<UserRole, Map<String, List<String>>> choices;
	
	
	public MatcherRepository() {
		this.choices = new HashMap<>();
	}

	public void saveChoices(CandidatesChoices candidatesChoices) {
		if (candidatesChoices != null) {
			UserRole userRole = candidatesChoices.getRole();
			Map<String, List<String>> chosenMap = getUserMap(userRole);

			for (String chosen : candidatesChoices.getChoices()) {
				List<String> choosers = getChoosers(chosenMap, chosen);
				choosers.add(candidatesChoices.getId());
			}
		}
	}

	/**
	 * Returns those who have chosen the hospital with the given id.
	 * @param id
	 * @return
	 */
	public List<String> getHospitalMatches(String id) {
		return getChoosers(id, DOCTOR);
	}
	
	/**
	 * Returns those who have chosen doctor with given id.
	 * @param id
	 * @return
	 */
	public List<String> getDoctorMatches(String id) {
		return getChoosers(id, HOSPITAL);
	}

	private List<String> getChoosers(String id, UserRole userRole) {
		Map<String, List<String>> map = choices.get(userRole);
		List<String> choosers = null;
		
		if (map != null)
			choosers = map.get(id);

		if (choosers == null)
			return new ArrayList<>();
		else
			return choosers;
	}


	
	private Map<String, List<String>> getUserMap(UserRole userRole) {
		Map<String, List<String>> chosen = choices.get(userRole);
		
		if (chosen == null) {
			chosen = new HashMap<>();
			choices.put(userRole, chosen);
		}
		
		return chosen;
	}

	private List<String> getChoosers(Map<String, List<String>> roleMap, String chosen) {
		List<String> choosers = roleMap.get(chosen);
		if (choosers == null) {
			choosers = new ArrayList<>();
			roleMap.put(chosen, choosers);
		}
		return choosers;
	}

	public void clear() {
		choices.clear();
	}
}
