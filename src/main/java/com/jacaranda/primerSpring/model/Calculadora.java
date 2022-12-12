package com.jacaranda.primerSpring.model;

import java.util.Objects;

public class Calculadora {
	
	private double num1;
	private double num2;
	

	public Calculadora() {
	}


	public Calculadora(double num1, double num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}


	public double getNum1() {
		return num1;
	}


	public void setNum1(double num1) {
		this.num1 = num1;
	}


	public double getNum2() {
		return num2;
	}


	public void setNum2(double num2) {
		this.num2 = num2;
	}


	@Override
	public int hashCode() {
		return Objects.hash(num1, num2);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculadora other = (Calculadora) obj;
		return Double.doubleToLongBits(num1) == Double.doubleToLongBits(other.num1)
				&& Double.doubleToLongBits(num2) == Double.doubleToLongBits(other.num2);
	}


	@Override
	public String toString() {
		return "Calculadora [num1=" + num1 + ", num2=" + num2 + "]";
	}

}
