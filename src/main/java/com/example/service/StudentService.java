package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository sRepo;
	
	public void create(Student s) {
		sRepo.save(s);
	}
	
	public List<Student> readAll() {
		return sRepo.findAll();
	}
	
	public Optional<Student> readById(int id) {
		return sRepo.findById(id);
	}
	
	public void update(Student s) {
		Optional<Student> inDb = sRepo.findById(s.getId());
		Student sInDb = inDb.get();
		sInDb.setName(s.getName());
		sInDb.setAddress(s.getAddress());
		sInDb = sRepo.save(sInDb);
	}
	
	public void deleteById(int id) {
		sRepo.deleteById(id);
	}
}
