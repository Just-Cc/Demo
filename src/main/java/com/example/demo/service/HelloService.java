package com.example.demo.service;

import com.example.demo.pojo.Student;

public interface HelloService {
	
	Student findByName(String name);
	
	Student findById(Integer id);
	
	String updateNameById(String name,String id);

    void insertStudent(Student student);
}
