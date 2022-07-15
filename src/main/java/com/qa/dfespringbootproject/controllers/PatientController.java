package com.qa.dfespringbootproject.controllers;

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
import com.qa.dfespringbootproject.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	private PatientService service;

//	Dependency injection
	public PatientController(PatientService service) {
		this.service = service;
	}

//GET - READ
//ReadAll
	@GetMapping("/readAll")
	public List<Patient> readAll() {
		return this.service.readAll();
	}

//	ReadByID
	@GetMapping("/readById/{id}")
	public Patient readById(@PathVariable long id) {
		return this.service.readById(id);
	}

///ReadByFirstName
	@GetMapping("/readbyFirstName/{firstName}")
	public List<Patient> readByfirstName(@PathVariable String firstName) {
		return this.service.readByFirstName(firstName);

	}

//POST - CREATE
	@PostMapping("/create")
	public Patient create(@RequestBody Patient patient) {
		return this.service.create(patient);
	}

//PUT - UPDATE
	@PutMapping("/update/{id}")
	public Patient update(@PathVariable long id, @RequestBody Patient patient) {
		return this.service.update(id, patient);
	}

//DELETE - DELETE
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}
}
