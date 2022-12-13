package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.primerSpring.Studentservice;
import com.jacaranda.primerSpring.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	Studentservice repositorio;

	@GetMapping("listStudents")
	public String listStudent(Model model) {
		//model es la plantilla, lista es el nombre del atributo que se usara en la plantilla.
		model.addAttribute("lista", repositorio.getStudents());
		//devuelve el codigo html renderizado con el codigo
		return "listStudents";
	}
	
	@GetMapping("addStudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("estudiante", student);
		return "addStudent";
	}
	
	@PostMapping("/addStudent/submit")
	public String addSubmitStudent(@ModelAttribute("estudiante") Student pepito) {
		repositorio.addStudents(pepito);
		
		return "redirect:/listStudents";
	}
	
	
	@PostMapping("/delStudent")
	public String delStudent(Model model, @ModelAttribute("student") Student student) {

		model.addAttribute("student", student);
		return "delStudent";
	}
	
	@PostMapping("/delStudent/submit")
	public String delSubmitStudent(@ModelAttribute("student") Student pepito) {
		repositorio.delStudent(pepito);
		
		return "redirect:/listStudents";
	}
	

}
