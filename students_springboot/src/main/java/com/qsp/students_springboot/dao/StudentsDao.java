package com.qsp.students_springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.students_springboot.dto.Students;
import com.qsp.students_springboot.repository.StudentsRepo;

@Repository
public class StudentsDao 
{
		@Autowired
		private StudentsRepo repo;
		
		public Students saveStudents(Students students)
		{
			return repo.save(students);
		}
		
		public Students fetchStudents(int id)
		{
			Optional<Students> optional=repo.findById(id);
			
			if(optional.isPresent())
			{
				return optional.get();
			}
			return null;
		}
		
		public List<Students> fetchAllStudents()
		{
			return repo.findAll();
		}
		
		// BY USING DELELET(ID)
		public Students deleteStudents(int id)
		{
			Optional<Students> optional=repo.findById(id);
			
			if(optional.isPresent())
			{
				repo.deleteById(id);
				return optional.get();
			}
			return null;
		}
		
		// BY USING DELETE(OBJECT)
//		public Students deleteStudents2(int id)
//		{
//			Optional<Students> optional=repo.findById(id);
//			
//			if(optional.isPresent())
//			{
//				Students students=optional.get();
//				
//				repo.delete(students);
//				return students;
//			}
//			return null;
//		}
		
		public Students updateStudents(int id, Students students)
		{
			Optional<Students> optional=repo.findById(id);
			
			if(optional.isPresent())
			{
				students.setId(id);
				return repo.save(students);
			}
			return null;

		}
		
		public Students findByEmail(String email)
		{
			return repo.findStudentsByEmail(email);
		}
		
		public Students findByPhone(long phone)
		{
			return repo.findStudentsByPhone(phone);
		}
		
		public List<Students> findByGrade(String grade)
		{
			return repo.findStudentsByGrade(grade);
		}
		
		public List<Students> findByPercentageGreaterThan(double percentage)
		{
			return repo.findStudentsByPercentageGreaterThan(percentage);
		}
		

		public List<Students> findByPercentageLessThan(double percentage)
		{
			return repo.findStudentsByPercentageLessThan(percentage);
		}
		
		public List<Students> findBySecuredMarksLessThan(int marks)
		{
			return repo.findStudentsByPercentageLessThan(marks);
		}
		
		public List<Students> findBySecuredMarksGreaterThan(int marks)
		{
			return repo.findStudentsByPercentageLessThan(marks);
		}
		
		public List<Students> findByName(String name)
		{
			return repo.findStudentsByName(name);
		}
		
		
		
		
		
		
		
		
		
}
