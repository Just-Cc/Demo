package com.example.demo.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Student;
import com.example.demo.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{
	
	@Autowired
	StudentMapper mapper;

	@Override
	public Student findByName(String name) {
		
		return mapper.findByName(name);
	}

	@Override
	public Student findById(Integer id) {
		
		return mapper.findById(id);
	}

	@Override
	public String updateNameById(String name,String id) {
		try {
			Integer newId = Integer.valueOf(id);
			mapper.updateNameById(name,newId);
			return "成功";
		}catch(Exception e) {
			return "失败";
		}
	}

	@Override
	public void insertStudent(Student student) {
		student.setId(mapper.findMaxId());
		mapper.insertStudent(student);
	}

}
