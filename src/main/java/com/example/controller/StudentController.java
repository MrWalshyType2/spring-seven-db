package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService sService;
	
	@GetMapping(value="/all", produces="application/json")
	public List<Student> getAllRecords() {
		return sService.readAll();
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public Optional<Student> getRecord(@PathVariable int id) {
		return sService.readById(id);
	}

	@PostMapping(produces="application/json")
	public void saveRecord(@RequestBody Student s) {
		sService.create(s);
	}
	
	@PutMapping(produces="application/json")
	public void updateRecord(@RequestBody Student s) {
		sService.update(s);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteRecord(@PathVariable int id) {
		sService.deleteById(id);
	}
	
}
