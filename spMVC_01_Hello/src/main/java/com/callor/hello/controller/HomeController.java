package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.StudentDto;
import com.callor.hello.service.StudentService;

@Controller
public class HomeController {
	
	/* Spring Prokect 에서 가장 많이 보이는 에러 메세지
	 * No qualifying bean of type 'com.callor.hello.service.StudentService'
	 * 
	 * HomeController 에서 StudentService 클래스로 만들어진 bean(객체, 컴포넌트)를
	 * 사용하겠다고 Spring 에게 달라 라고 요청을 했다.
	 * 
	 * 그런데 어떤 이유로 StudentService 클래스의 bean 이 생성이 안되었을때
	 * 보여지는 에러 메세지이다
	 * 
	 * 이 메세지의 대부분의 원인은 bean 을 생성할 클래스에 
	 * @Annotation 이 누락된 경우이다.
	 */
	private final StudentService studentService;
	
	public HomeController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		StudentDto stDto = studentService.getStudent();
		model.addAttribute("STD",stDto);
		
		return "home";
	}
	
}
