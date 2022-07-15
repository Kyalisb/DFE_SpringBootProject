package com.qa.dfespringbootproject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfespringbootproject.entities.Patient;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PatientControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Patient entry = new Patient("Ruth", "Kyalisiima", 10, "ruth@gmail.com");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Patient result = new Patient(2L, "Ruth", "Kyalisiima", 10, "ruth@gmail.com");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/patient/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));

	}

	@Test
	public void readAllTest() throws Exception {
		List<Patient> output = new ArrayList<>();
		Patient entry = new Patient(1L, "Brenda", "Kyalisiima", 30, "kyalisb@gmail.com");
		output.add(entry);

		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/patient/readAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));

	}

	@Test
	public void readByIdTest() throws Exception {
		Patient entry = new Patient(1L, "Brenda", "Kyalisiima", 30, "kyalisb@gmail.com");
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		mvc.perform(get("/patient/readById/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));
	}
//	@Test
//	public void readByFirstName() throws Exception {
//		List<Patient> output = new ArrayList<>();
//		Patient entry = new Patient(1L, "Brenda", "Kyalisiima", 30, "kyalisb@gmail.com");
//		output.add(entry);
//
//		String outputAsJSON = mapper.writeValueAsString(output);
//
//		mvc.perform(get("/patient/readByFirstName").contentType(MediaType.APPLICATION_JSON))
//				.andExpect(content().json(outputAsJSON));
//
//	}
//

	@Test
	public void updateTest() throws Exception {
		Patient entry = new Patient("B", "K", 30, "bk@gmail.com");
		Patient result = new Patient(1L, "B", "K", 30, "bk@gmail.com");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(put("/patient/update/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}

	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/patient/delete/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("true"));
	}
}


