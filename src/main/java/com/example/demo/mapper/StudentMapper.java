package com.example.demo.mapper;


import org.springframework.stereotype.Component;

import com.example.demo.pojo.Student;

@Component
public interface StudentMapper {

	public Student findById(Integer id);
	
	public Student findByName(String name);
	
	public void updateNameById(String name,Integer id);
}
