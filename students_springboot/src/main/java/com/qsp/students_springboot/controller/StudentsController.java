package com.qsp.students_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.students_springboot.dao.StudentsDao;
import com.qsp.students_springboot.dto.Students;
import com.qsp.students_springboot.service.StudentsService;
import com.qsp.students_springboot.util.ResponseSturcture;

@RestController
public class StudentsController 
{


		@Autowired
		private StudentsService service;
		
		
		@PostMapping("/saveStudents")
		public ResponseEntity<ResponseSturcture<Students>> saveStudents(@RequestBody Students students)
		{
			return service.saveStudents(students);
		}
		
		@GetMapping("fetchStudents")
		public ResponseEntity<ResponseSturcture<Students>> fetchStudents(@RequestParam int id)
		{
			return service.fetchStudents(id);
		}
		
		@GetMapping("/fetchAll")
		public ResponseEntity<ResponseSturcture<List<Students>>> fetchAllStudents()
		{
			return service.fetchAllStudents();
		}
		
		@DeleteMapping("/deleteStudents")
		public ResponseEntity<ResponseSturcture<Students>> deleteStudents(@RequestParam int id)
		{
			return service.deleteStudents(id);
		}
		
		// BY USING DELETE(OBJECT)
//		@DeleteMapping("/deleteSt/{id}")
//		public Students deleteStudents2(@PathVariable int id)
//		{
//			return service.deleteStudents2(id);
//		}
		
		@PutMapping("/updateStudents/{id}")
		public ResponseEntity<ResponseSturcture<Students>> updateStudents(@PathVariable int id, @RequestBody Students students)
		{
			
			return service.updateStudents(id, students);
		}
		
		@PatchMapping("/updateEmail")
		public ResponseEntity<ResponseSturcture<Students>> updateEmail(@RequestParam int id, @RequestParam String email)
		{
			return service.updateEmail(id, email);
		}
		
		@PatchMapping("/updatePhone/{id}")
		public ResponseEntity<ResponseSturcture<Students>> updatePhone(@PathVariable int id, @RequestParam long phone)
		{
			return service.updatePhone(id, phone);
		}
		
		@PatchMapping("/updateMarks/{id}/{marks}")
		public ResponseEntity<ResponseSturcture<Students>> updateSecuredMarks(@PathVariable int id, @PathVariable int marks)
		{
			return service.updateSecuredMarks(id, marks);
		}
		
		@GetMapping("/findByEmail")
		public ResponseEntity<ResponseSturcture<Students>> findByEmail(@RequestParam String email)
		{
			return service.findByEmail(email);
		}
		
		
		@GetMapping("/findByPhone")
		public ResponseEntity<ResponseSturcture<Students>> findByPhone(@RequestParam long phone)
		{
			return service.findByPhone(phone);
		}
		
		
		@GetMapping("/findByGrade")
		public ResponseEntity<ResponseSturcture<List<Students>>> findByGrade(@RequestParam String grade)
		{
			return service.findByGrade(grade);
		}
		
		
		@GetMapping("/findGreaterPer")
		public ResponseEntity<ResponseSturcture<List<Students>>> findByPercentageGreaterThan(@RequestParam double percentage)
		{
			return service.findByPercentageGreaterThan(percentage);
		}
		
		@GetMapping("/findLessPer")
		public ResponseEntity<ResponseSturcture<List<Students>>> findByPercentageLessThan(@RequestParam double percentage)
		{
			return service.findByPercentageLessThan(percentage);
		}
		
		@GetMapping("/findMarksLess/{marks}")
		public ResponseEntity<ResponseSturcture<List<Students>>> findByMarksLessThan(@PathVariable int marks)
		{
			return service.findByMarksLessThan(marks);
		}
		
		@GetMapping("/findMarksGreater")
		public ResponseEntity<ResponseSturcture<List<Students>>> findByMarksGreaterThan(@RequestParam int marks)
		{
			return service.findByMarksGreaterThan(marks);
		}
		
		@GetMapping("/findByName")
		public ResponseEntity<ResponseSturcture<List<Students>>> findByName( String name)
		{
			return service.findByName(name);
		}
		
		
}
