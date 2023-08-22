package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.UI;

public class Person {

	private String name;
	private Integer age;
	private Double height;
	private Double weight; // peso da pessoa
	private Double IMC;

	Scanner scan;
	List<Person> peopleList = new ArrayList<>();
	private String sourceFileStr = "C:\\Users\\netop\\OneDrive\\Área de Trabalho\\NETO\\PROGRAMAÇÃO\\JAVA\\cusoJavaNelioAlves\\crudArquivoTextoJava\\listPeople.txt";

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

	public void registerPerson() {

		try {
			peopleList.add(this);

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFileStr))) {
				bw.write("PEOPLE LIST");
				bw.newLine();
				if (peopleList.size() == 1) {
					bw.write("THERE IS " + peopleList.size() + " REGISTERED");
					bw.newLine();
				} else {
					bw.write("THERE ARE " + peopleList.size() + " REGISTERED");
					bw.newLine();
				}
				for (Person p : peopleList) {
					bw.write("Person " + 1 + peopleList.indexOf(p));
					bw.newLine();
					bw.write("\t" + p.getName());
					bw.newLine();
					bw.write("\t" + p.getAge());
					bw.newLine();
					bw.write("\t" + String.format("%.2f", p.getWeight()));
					bw.newLine();
					bw.write("\t" + String.format("%.2f", p.getHeight()));
					bw.newLine();
					bw.write("\t" + String.format("%.2f", p.getIMC()));
					bw.newLine();
				}
				UI.messageCreatedPerson();
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}

		} catch (RuntimeException e) {
			throw new PersonException("Error: this operation cannot be carried out!");
		}
	}

	public void readPeopleList(Person p) {

	}

	public void updatePerson(Person p) {

	}

	public void deletePerson(Person p) {

	}
}
