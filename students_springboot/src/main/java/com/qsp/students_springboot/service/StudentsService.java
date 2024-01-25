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
import com.qsp.students_springboot.util.ResponseStructure;

@Service
public class StudentsService
{
		@Autowired
		private StudentsDao dao;
		
		public ResponseEntity<ResponseStructure<Students>> saveStudents(Students students)
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
			
			ResponseStructure<Students> structure=new ResponseStructure<>();
			
			structure.setMessage("Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveStudents(students));
			
			return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.CREATED );
			
			
		}
		public ResponseEntity<ResponseStructure<Students>> fetchStudents(int id)
		{
			Students students=dao.fetchStudents(id);
			ResponseStructure<Students> structure=new ResponseStructure<>();

			if(students !=null)
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.fetchStudents(id));
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.FOUND );

			}
			else
			{
				throw new IdNotFoundException("Id Not found");
			}
			
		}
		
		public ResponseEntity<ResponseStructure<List<Students>>> fetchAllStudents()
		{
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();
			
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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
		}
		
		public ResponseEntity<ResponseStructure<Students>> deleteStudents(int id)
		{
			Students students=dao.deleteStudents(id);
			ResponseStructure<Students> structure=new ResponseStructure<>();

			if(students !=null)
			{
				
				structure.setMessage("Delete Successfully");
				structure.setStatus(HttpStatus.NO_CONTENT.value());
				structure.setData(dao.deleteStudents(id));
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.NO_CONTENT );

			}
			else
			{
				throw new IdNotFoundException("Id not found");
			}
		}
		
		public ResponseEntity<ResponseStructure<Students>> updateStudents(int id, Students students)
		{
			Students dbStudents=dao.fetchStudents(id);
			
			ResponseStructure<Students> structure=new ResponseStructure<>();
			
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
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.ACCEPTED );

				
			}
			else
			{
				throw new IdNotFoundException("Id not found");

			}
			
		}
		
		public ResponseEntity<ResponseStructure<Students>> updateEmail(int id,String email)
		{
			Students students=dao.fetchStudents(id);
			ResponseStructure<Students> structure=new ResponseStructure<>();

			if(students !=null)
			{
				students.setEmail(email);
			
				structure.setMessage("Updated Successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(dao.updateStudents(id, students));
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.ACCEPTED);

			}
			else
			{
				throw new IdNotFoundException("Id not found");

			}
		}
		
		public ResponseEntity<ResponseStructure<Students>> updatePhone(int id, long phone)
		{
			Students students=dao.fetchStudents(id);  
			ResponseStructure<Students> structure=new ResponseStructure<>();

			
			if(students !=null)
			{
				students.setPhone(phone);

				structure.setMessage("Updated Successfully");
				structure.setStatus(HttpStatus.ACCEPTED.value());
				structure.setData(dao.updateStudents(id, students));
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.ACCEPTED);

			}
			else
			{
				throw new IdNotFoundException("Id not found");

			}
			
			
		}
		
		public ResponseEntity<ResponseStructure<Students>> updateSecuredMarks(int id, int secureMarks)
		{
			Students students=dao.fetchStudents(id);  
			ResponseStructure<Students> structure=new ResponseStructure<>();

			
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
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.ACCEPTED);

			}
			else
			{
				throw new IdNotFoundException("Id Not Found");
			}
			
			
		}
		
		public ResponseEntity<ResponseStructure<Students>> findByEmail(String email)
		{
			Students students=dao.findByEmail(email);
			
			ResponseStructure<Students> structure=new ResponseStructure<>();

			if(students !=null)
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByEmail(email));
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.FOUND);

			}
			else
			{
				throw new EmailNotFoundException("Email not found");
			}
			
		}
		
		public ResponseEntity<ResponseStructure<Students>> findByPhone(long phone)
		{
			Students students=dao.findByPhone(phone);
			
			ResponseStructure<Students> structure=new ResponseStructure<>();

			if(students !=null)
			{
				structure.setMessage("Find Successfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.findByPhone(phone));
				
				return new ResponseEntity<ResponseStructure<Students>>(structure,HttpStatus.FOUND);

			}
			else
			{
				throw new PhoneNotFoundException("Phone is Not found");
			}
			
		}
		
		public ResponseEntity<ResponseStructure<List<Students>>> findByGrade(String grade)
		{
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();

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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		public ResponseEntity<ResponseStructure<List<Students>>> findByPercentageGreaterThan(double percentage)
		{
			
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();

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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		

		public ResponseEntity<ResponseStructure<List<Students>>> findByPercentageLessThan(double percentage)
		{
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();

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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		public ResponseEntity<ResponseStructure<List<Students>>> findByMarksLessThan(int marks)
		{
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();

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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		public ResponseEntity<ResponseStructure<List<Students>>> findByMarksGreaterThan(int marks)
		{
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();

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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		public ResponseEntity<ResponseStructure<List<Students>>> findByName(String name)
		{
			ResponseStructure<List<Students>> structure=new ResponseStructure<>();

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
				
				return new ResponseEntity<ResponseStructure<List<Students>>>(structure,HttpStatus.FOUND );

			}
			
		}
		
		
		
		
		
}
