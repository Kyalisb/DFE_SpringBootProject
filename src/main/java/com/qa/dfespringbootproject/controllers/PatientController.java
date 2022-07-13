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
	public Patient readById(@PathVariable int id) {
		return this.service.readById(id);

	}

//POST - CREATE
	@PostMapping("/create")
	public Patient create(@RequestBody Patient patient) {
		return this.service.create(patient);
	}

//PUT - UPDATE
	@PutMapping("/update/{id}")
	public Patient update(@PathVariable int id, @RequestBody Patient patient) {
		return this.service.update(id, patient);
	}

//DELETE - DELETE
	@DeleteMapping("/delet/{id}")
	public Patient delet(@PathVariable int id) {
		return this.service.delet(id);

	}

}
