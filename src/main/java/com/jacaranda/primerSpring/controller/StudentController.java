package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/delStudent")
	public String delStudent(Model model, @RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="surname", required=false, defaultValue="")String surname) {
		
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("student", estudiante);
		return "delStudent";
	}
	
	@PostMapping("/delStudent/delSubmit")
	public String listStudentsdelMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.delStudent(student);
			
		return "redirect:/listStudents";
	}
	
	@GetMapping("/editStudent")
	public String editStudent(Model model, @RequestParam(name="name", required=false, defaultValue="")String name,
			@RequestParam(name="surname", required=false, defaultValue="")String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("student", estudiante);
		
		return "editStudent";
	}
	
	@PostMapping("/editStudent/Submit")
	public String listStudentseditMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.updateStudent(student.getName(), student.getSurname(), student.getAge());
			
		return "redirect:/listStudents";
	}
	

}
