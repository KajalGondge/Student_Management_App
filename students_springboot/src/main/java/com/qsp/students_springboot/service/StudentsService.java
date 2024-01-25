package com.qsp.students_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.students_springboot.dao.StudentsDao;
import com.qsp.students_springboot.dto.Students;
import com.qsp.students_springboot.exception.DataNotAvailable;
import com.qsp.students_springboot.exception.EmailNotFoundException;
import com.qsp.students_springboot.exception.IdNotFoundException;
import com.qsp.students_springboot.exception.PhoneNotFoundException;
import com.qsp.students_springboot.util.ResponseSturcture;

@Service
public class StudentsService
{
		@Autowired
		private StudentsDao dao;
		
		public ResponseEntity<ResponseSturcture<Students>> saveStudents(Students students)
		{
			int secMarks=students.getSecuredMarks();
			int totalMarks=students.getTotalMarks();
			
			double percentage=(secMarks*100.0)/totalMarks;
			
			if(percentage <35)
			{
				students.setPercentage(percentage);
				students.setGrade("Fail");
			}
			else if(percentage >=35 && percentage <50)
			{
				students.setPercentage(percentage);
				students.setGrade("Pass");
			}
			else if(percentage >=50 && percentage <65)
			{
				students.setPercentage(percentage);
				students.setGrade("SecondClass");
			}
			else if(percentage >=65 && percentage <90)
			{
				students.setPercentage(percentage);
				students.setGrade("FirstClass");
			}
			else if(percentage >=90)
			{
				students.setPercentage(percentage);
				students.setGrade("Distinction");
			}
			
			ResponseSturcture<Students> structure=new ResponseSturcture<>();
			
			structure.setMessage("Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveStudents(students));
			
			return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.CREATED );
			
			
		}
		public ResponseEntity<ResponseSturcture<Students>> fetchStudents(int id)
		{
			Students students=dao.fetchStudents(id);
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			if(students !=null)
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.fetchStudents(id));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.FOUND );

			}
			else
			{
				throw new IdNotFoundException("Id Not found");
			}
			
		}
		
		public ResponseEntity<ResponseSturcture<List<Students>>> fetchAllStudents()
		{
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();
			
			List<Students> list=dao.fetchAllStudents();

			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is Not Available inside the Table..");
			}
			else
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(list);
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
		}
		
		public ResponseEntity<ResponseSturcture<Students>> deleteStudents(int id)
		{
			Students students=dao.deleteStudents(id);
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			if(students !=null)
			{
				
				structure.setMessage("Delete Successfully");
				structure.setStatus(HttpStatus.NO_CONTENT.value());
				structure.setData(dao.deleteStudents(id));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.NO_CONTENT );

			}
			else
			{
				throw new IdNotFoundException("Id not found");
			}
		}
		
		public ResponseEntity<ResponseSturcture<Students>> updateStudents(int id, Students students)
		{
			Students dbStudents=dao.fetchStudents(id);
			
			ResponseSturcture<Students> structure=new ResponseSturcture<>();
			
			int secMarks=students.getSecuredMarks();
			int totalMarks=students.getTotalMarks();
			
			double percentage=(secMarks*100.0)/totalMarks;
			
			if(dbStudents !=null)
			{
				students.setId(id);
				if(percentage <35)
				{
					students.setPercentage(percentage);
					students.setGrade("Fail");
				}
				else if(percentage >=35 && percentage <50)
				{
					students.setPercentage(percentage);
					students.setGrade("Pass");
				}
				else if(percentage >=50 && percentage <65)
				{
					students.setPercentage(percentage);
					students.setGrade("SecondClass");
				}
				else if(percentage >=65 && percentage <90)
				{
					students.setPercentage(percentage);
					students.setGrade("FirstClass");
				}
				else if(percentage >=90)
				{
					students.setPercentage(percentage);
					students.setGrade("Distinction");
				}
				
				structure.setMessage("Updated Successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(dao.updateStudents(id, students));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.ACCEPTED );

				
			}
			else
			{
				throw new IdNotFoundException("Id not found");

			}
			
		}
		
		public ResponseEntity<ResponseSturcture<Students>> updateEmail(int id,String email)
		{
			Students students=dao.fetchStudents(id);
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			if(students !=null)
			{
				students.setEmail(email);
			
				structure.setMessage("Updated Successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(dao.updateStudents(id, students));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.ACCEPTED);

			}
			else
			{
				throw new IdNotFoundException("Id not found");

			}
		}
		
		public ResponseEntity<ResponseSturcture<Students>> updatePhone(int id, long phone)
		{
			Students students=dao.fetchStudents(id);  
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			
			if(students !=null)
			{
				students.setPhone(phone);

				structure.setMessage("Updated Successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(dao.updateStudents(id, students));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.ACCEPTED);

			}
			else
			{
				throw new IdNotFoundException("Id not found");

			}
			
			
		}
		
		public ResponseEntity<ResponseSturcture<Students>> updateSecuredMarks(int id, int secureMarks)
		{
			Students students=dao.fetchStudents(id);  
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			
			if(students !=null)
			{
				students.setSecuredMarks(secureMarks);
				
				int secMarks=students.getSecuredMarks();
				int totalMarks=students.getTotalMarks();
				
				double percentage=(secMarks*100.0)/totalMarks;
				

				if(percentage <35)
				{
					students.setPercentage(percentage);
					students.setGrade("Fail");
				}
				else if(percentage >=35 && percentage <50)
				{
					students.setPercentage(percentage);
					students.setGrade("Pass");
				}
				else if(percentage >=50 && percentage <65)
				{
					students.setPercentage(percentage);
					students.setGrade("SecondClass");
				}
				else if(percentage >=65 && percentage <90)
				{
					students.setPercentage(percentage);
					students.setGrade("FirstClass");
				}
				else if(percentage >=90)
				{
					students.setPercentage(percentage);
					students.setGrade("Distinction");
				}

				structure.setMessage("Updated Successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(dao.updateStudents(id, students));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.ACCEPTED);

			}
			else
			{
				throw new IdNotFoundException("Id Not Found");
			}
			
			
		}
		
		public ResponseEntity<ResponseSturcture<Students>> findByEmail(String email)
		{
			Students students=dao.findByEmail(email);
			
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			if(students !=null)
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByEmail(email));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.FOUND);

			}
			else
			{
				throw new EmailNotFoundException("Email not found");
			}
			
		}
		
		public ResponseEntity<ResponseSturcture<Students>> findByPhone(long phone)
		{
			Students students=dao.findByPhone(phone);
			
			ResponseSturcture<Students> structure=new ResponseSturcture<>();

			if(students !=null)
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByPhone(phone));
				
				return new ResponseEntity<ResponseSturcture<Students>>(structure,HttpStatus.FOUND);

			}
			else
			{
				throw new PhoneNotFoundException("Phone is Not found");
			}
			
		}
		
		public ResponseEntity<ResponseSturcture<List<Students>>> findByGrade(String grade)
		{
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();

			List<Students> list=dao.findByGrade(grade);
			
			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is not available");
			}
			else
			{
				structure.setMessage("Found Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByGrade(grade));
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		public ResponseEntity<ResponseSturcture<List<Students>>> findByPercentageGreaterThan(double percentage)
		{
			
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();

			List<Students> list=dao.findByPercentageGreaterThan(percentage);
			
			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is not available");

			}
			else
			{
				structure.setMessage("Found Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByPercentageGreaterThan(percentage));
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		

		public ResponseEntity<ResponseSturcture<List<Students>>> findByPercentageLessThan(double percentage)
		{
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();

			List<Students> list=dao.findByPercentageLessThan(percentage);
			
			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is not available");

			}
			else
			{
				structure.setMessage("Found Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByPercentageLessThan(percentage));
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		public ResponseEntity<ResponseSturcture<List<Students>>> findByMarksLessThan(int marks)
		{
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();

			List<Students> list=dao.findBySecuredMarksLessThan(marks);
			
			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is not available");

			}
			else
			{
				structure.setMessage("Found Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findBySecuredMarksLessThan(marks));
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		public ResponseEntity<ResponseSturcture<List<Students>>> findByMarksGreaterThan(int marks)
		{
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();

			List<Students> list=dao.findBySecuredMarksGreaterThan(marks);
			
			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is not available");

			}
			else
			{
				structure.setMessage("Found Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findBySecuredMarksGreaterThan(marks));
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		public ResponseEntity<ResponseSturcture<List<Students>>> findByName(String name)
		{
			ResponseSturcture<List<Students>> structure=new ResponseSturcture<>();

			List<Students> list=dao.findByName(name);
			
			if(list.isEmpty())
			{
				throw new DataNotAvailable("Data is not available");

			}
			else
			{
				structure.setMessage("Found Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByName(name));
				
				return new ResponseEntity<ResponseSturcture<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		
		
		
		
}
