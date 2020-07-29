package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Student;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository cRepo;
	
	public void create(Course c) {
		cRepo.save(c);
	}
	
	public List<Course> readAll() {
		return cRepo.findAll();
	}
	
	public Optional<Course> readById(int id) {
		return cRepo.findById(id);
	}
	
	public void update(Course c) {
		Optional<Course> inDb = cRepo.findById(c.getId());
		Course cInDb = inDb.get();
		cInDb.setCourseName(c.getCourseName());
		cRepo.save(cInDb);
	}
	
	public void deleteById(int id) {
		cRepo.deleteById(id);
	}
}
