package com.qa.dfespringbootproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringbootproject.entities.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private List<Patient> patients = new ArrayList<>();

//GET - READ
//ReadAll
	@GetMapping("/readAll")
	public List<Patient> readAll() {
		return this.patients;

	}

//	ReadByID
	@GetMapping("/readById/{id}")
	public Patient readById(@PathVariable int id) {
		return this.patients.get(id);

	}

//POST - CREATE
	@PostMapping("/create")
		public Patient create(@RequestBody Patient patient) {
			this.patients.add(patient);
			
//			Returning the latest entry to the added list
			return this.patients.get(this.patients.size() -1);
	}
//PUT - UPDATE
@PutMapping("/update/{id}")
public Patient update(@PathVariable int id, @RequestBody Patient patient) {
//	removing the original patient
	this.patients.remove(id);
	
//	Adding
	this.patients.add(id,patient);
	return this.patients.get(id);
	
}	
//DELETE - DELETE
	@DeleteMapping("/delet/{id}")
	public Patient delet(@PathVariable int id) {
		return this.patients.remove(id);

	}

}
