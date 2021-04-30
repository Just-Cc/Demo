package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Student;
import com.example.demo.service.HelloService;

@RequestMapping("hello")
@RestController
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@GetMapping("studentId")
	public String studentId(String id) {
		System.out.println(id);
		Student s = helloService.findById(Integer.valueOf(id));
		StringBuilder sb = new StringBuilder();
		sb.append("ID:").append(s.getId()).append("Name:").append(s.getName()).append("Address:").append(s.getAddress()).append("Age;").append(s.getAge());
		return sb.toString();
	}
	
	@GetMapping("studentName")
	public String studentName(String name) {
		System.out.println(name);
		Student s = helloService.findByName(name);
		StringBuilder sb = new StringBuilder();
		sb.append("ID:").append(s.getId()).append("Name:").append(s.getName()).append("Address:").append(s.getAddress()).append("Age;").append(s.getAge());
		return sb.toString();
	}
	
	@GetMapping("updateNameById")
	public String updateNameById(String name,String id) {
		System.out.println("id:"+id);
		return helloService.updateNameById(name,id);
	}

	@GetMapping("insertStudent")
	public String insertStudent(Student student){
		String result = new String("成功");
		try{
			helloService.insertStudent(student);
		}catch (Exception e){
			result = "失败";
		}
		return result;
	}
	
	public void printTest(String s){
		System.out.println("sssss");
		System.out.println(s);	
	}
}
