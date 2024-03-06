package com.qsp.students_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.students_springboot.dto.Students;

public interface StudentsRepo extends JpaRepository<Students, Integer>
{

		// no need to write public abstract bcoz in interface by default method is public abstract
		Students findStudentsByEmail(String email);
		
		Students findStudentsByPhone(long phone);
		
		List<Students> findStudentsByPercentageGreaterThan(double percentge);
		
		List<Students> findStudentsByPercentageLessThan(double percentge);
		
		List<Students> findStudentsByGrade(String grade);
		
		List<Students> findStudentsBySecuredMarksGreaterThan(int securedMarks);
		
		List<Students> findStudentsBySecuredMarksLessThan(int securedMarks);

		List<Students> findStudentsByName(String name);

}
