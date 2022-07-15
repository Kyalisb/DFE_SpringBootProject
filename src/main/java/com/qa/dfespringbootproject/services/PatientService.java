package com.qa.dfespringbootproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringbootproject.entities.Patient;
import com.qa.dfespringbootproject.repos.PatientRepo;

@Service
public class PatientService {

	private PatientRepo repo;

	public PatientService(PatientRepo repo) {
		this.repo = repo;
	}

//	GET - READALL
	public List<Patient> readAll() {
		return this.repo.findAll();

	}

//	ReadByID
	public Patient readById(long id) {
		return this.repo.findById(id).get();
	}
//
//	ReadByFirstName
	public List<Patient> readByFirstName(String firstName) {
		return this.repo.findPatientByFirstName(firstName);
	}

//POST - CREATE

	public Patient create(Patient patient) {
		return this.repo.saveAndFlush(patient);
	}
//PUT - UPDATE

public Patient update(long id,Patient patient) {
	Patient existing = this.repo.findById(id).get();
	existing.setFirstName(patient.getFirstName());
	existing.setLastName(patient.getLastName());
	existing.setEmail(patient.getEmail());
	existing.setAge(patient.getAge());
	
//	save
	return this.repo.saveAndFlush(existing);
//	return this.repo.findById(id).get();
   }
//	Adding
//	this.patients.add(id,patient);return this.patients.get(id);

//DELETE - DELETE

	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
