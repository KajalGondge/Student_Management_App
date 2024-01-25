package com.qsp.students_springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students 
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String address;
		private int age;
		
		@Column(unique=true)
		private String email;
		
		@Column(unique=true)
		private long phone;
		
		private int totalMarks;
		private int securedMarks;
		private double percentage;
		private String grade;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public int getTotalMarks() {
			return totalMarks;
		}
		public void setTotalMarks(int totalMarks) {
			this.totalMarks = totalMarks;
		}
		public int getSecuredMarks() {
			return securedMarks;
		}
		public void setSecuredMarks(int securedMarks) {
			this.securedMarks = securedMarks;
		}
		
		public double getPercentage() {
			return percentage;
		}
		public void setPercentage(double percentage) {
			this.percentage = percentage;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Students [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
					+ phone + ", totalMarks=" + totalMarks + ", securedMarks=" + securedMarks + "]";
		}
		
		
		
		
			

}
