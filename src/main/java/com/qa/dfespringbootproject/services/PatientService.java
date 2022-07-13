package com.qa.dfespringbootproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
i
import com.qa.dfespringbootproject.entities.Patient;

@Service
public class PatientService {
	private List<Patient> patients = new ArrayList<>();
	public List<Patient> readAll() {
		return this.patients;
	}

//	ReadByID
	
	public Patient readById(int id) {
		return this.patients.get(id);

	}

//POST - CREATE
	
		public Patient create(Patient patient) {
			this.patients.add(patient);
			
//			Returning the latest entry to the added list
			return this.patients.get(this.patients.size() -1);
	}
//PUT - UPDATE
  
public Patient update(int id,Patient patient) {
//	removing the original patient
	this.patients.remove(id);
	
//	Adding
	this.patients.add(id,patient);
	return this.patients.get(id);
	
}	
//DELETE - DELETE
	
	public Patient delet(int id) {
		return this.patients.remove(id);

	}

}


}
