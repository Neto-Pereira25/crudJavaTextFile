package entities;

import java.util.Date;

public class Person {

	private String name;
	private Integer age;
	private Double height;
	private Double weight; // peso da pessoa
	private Double IMC;
	
	public Person() {
	}

	public Person(String name, Integer age, Double height, Double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		IMC = weight / (height * height);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getIMC() {
		return IMC;
	}
	
}
