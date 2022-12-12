package com.jacaranda.primerSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Calculadora;

@Controller
public class myFirstContrller {
	
//	@GetMapping({"/", "index.html", "hello.html"})
//	public String hello(Model model, @RequestParam(name="nombre", required= false, defaultValue = "Inma") String nombre,
//	@RequestParam( required=false, defaultValue="Nieve") String apellido) {
//		model.addAttribute("nombre", nombre);
//		model.addAttribute("apellido", apellido);
//		return "hola";
//		
//		
//	}
	@GetMapping({"suma"})
	public String suma (Model model) {
		Calculadora calc = new Calculadora();
		model.addAttribute("calc", calc);
		return("calculator");
		
	}

}
