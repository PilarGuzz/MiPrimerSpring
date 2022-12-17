package com.jacaranda.primerSpring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Student;

@Service
public class Studentservice {
	
	private List<Student> lista;
	

	public Studentservice() {
		lista = new ArrayList<Student>();
		lista.add(new Student("Inma", "Olias", 25));
		lista.add(new Student("Pepe", "Perez", 45));
		lista.add(new Student("Juan", "Lopez", 84));
		lista.add(new Student("Marta", "Perea", 18));
	}


	public List<Student> getStudents() {
		return lista;
	}
	
	public boolean addStudents(Student e) {
		return lista.add(e);
	}



	public boolean delStudent(Student arg0) {
		return lista.remove(arg0);
	}
	
	public Student getStudent(String name, String surname) {
		Boolean encontrado = false;
		Student resultado=null;
		Iterator<Student> iterator = this.lista.iterator();
		while(iterator.hasNext() && !encontrado) {
			resultado = iterator.next();
			if(resultado.getName().equals(name)&& resultado.getSurname().equals(surname)) {
				encontrado= true;
			}
		}
		if(encontrado == true) {
			return resultado;
			
		}else {
			return null;
			
		}
	}
	
	public Student updateStudent(String name, String surname, int age) {
		Boolean encontrado = false;
		Student student= new Student();
		for(Student e : this.lista) {
			if(e.getName().equals(name)&& e.getSurname().equals(surname)) {
				encontrado= true;
				student = e;
				student.setAge(age);
			}
			
		}
		return student;
	
		
	}
	
	

}
