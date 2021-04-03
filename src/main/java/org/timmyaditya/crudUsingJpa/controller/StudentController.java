package org.timmyaditya.crudUsingJpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.timmyaditya.crudUsingJpa.exception.ResourceNotFoundException;
import org.timmyaditya.crudUsingJpa.model.StudentModel;
import org.timmyaditya.crudUsingJpa.repository.StudentModelRepository;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentModelRepository studentModelRepository;
	
	//get student
	@GetMapping("students")
	public List<StudentModel> getAllStudents(){
		return this.studentModelRepository.findAll();
	}
	
	//get student by id
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentModel> getStudentById(@PathVariable(value = "id") int studentId)
			throws ResourceNotFoundException {
		StudentModel sm = studentModelRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found fort this id"));
		return ResponseEntity.ok().body(sm);
	}
	
	
	//save student
	@PostMapping("/students")
	public StudentModel insert(@RequestBody StudentModel studentModel) {
		return this.studentModelRepository.save(studentModel);
	}
	//update student
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentModel> update(@PathVariable(value = "id") int studentId,
			 @RequestBody StudentModel studentModel) throws ResourceNotFoundException{
		StudentModel sm = studentModelRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found fort this id"));
		
		sm.setSname(studentModel.getSname());
		sm.setGender(studentModel.getGender());
		sm.setSwim(studentModel.isSwim());
		sm.setRead(studentModel.isRead());
		sm.setCricket(studentModel.isCricket());
		sm.setCity(studentModel.getCity());
		
		return ResponseEntity.ok(this.studentModelRepository.save(sm));
	}
	//delete student
	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int studentId) throws ResourceNotFoundException{
		
		StudentModel sm = studentModelRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found fort this id"));
		
		this.studentModelRepository.delete(sm);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
