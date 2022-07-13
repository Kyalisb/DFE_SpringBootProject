package com.qa.dfespringbootproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringbootproject.entities.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	private List<Patient> patients = new ArrayList<>();
	
	
//GET - READ
//	@GetMapping()
//	public String 
	
//POST - CREATE
	@PostMapping("/create")
		public Patient create(@RequestBody Patient patient) {
			this.patients.add(patient);
			
//			Returning the latest entry to the added list
			return this.patients.get(this.patients.size() -1);
			
			
		}
	}
	
//PUT - UPDATE
	
//DELETE - DELETE
	
	
	
}
