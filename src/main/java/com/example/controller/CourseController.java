package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Course;
import com.example.entity.Student;
import com.example.service.CourseService;
import com.example.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService cService;
	
	@GetMapping(value="/all", produces="application/json")
	public List<Course> getAllRecords() {
		return cService.readAll();
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public Optional<Course> getRecord(@PathVariable int id) {
		return cService.readById(id);
	}

	@PostMapping(produces="application/json")
	public void saveRecord(@RequestBody Course c) {
		cService.create(c);
	}
	
	@PutMapping(produces="application/json")
	public void updateRecord(@RequestBody Course c) {
		cService.update(c);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteRecord(@PathVariable int id) {
		cService.deleteById(id);
	}
}
