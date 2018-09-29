package com.companyname.sampletest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.companyname.sampletest.service.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	StudentService studentService;
	@GetMapping({"/home", "/"})
    public String home(@RequestParam(name = "name", required = false, defaultValue = "Anonymous") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

	@GetMapping("/showstudents")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.listStudents());
        return "student";
	}
}
