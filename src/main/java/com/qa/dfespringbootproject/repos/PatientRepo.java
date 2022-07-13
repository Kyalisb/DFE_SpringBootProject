package com.qa.dfespringbootproject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfespringbootproject.entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{
	List<Patient> findPatientByFirstName(String first_name);
	

}
