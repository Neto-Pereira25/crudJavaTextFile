package servicesPerson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import application.UI;
import entities.Person;
import entities.PersonException;

public class Service {
	
	private String sourceFileStr = "C:\\Users\\netop\\OneDrive\\Área de Trabalho\\NETO\\PROGRAMAÇÃO\\JAVA\\cusoJavaNelioAlves\\crudArquivoTextoJava\\listPeople.txt";

	public Service() { }
	
	Scanner scan = new Scanner(System.in);

	public Person registerPerson() {
		try {
			scan.nextLine();
			System.out.println("Enter the person's details:");
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Age: ");
			int age = scan.nextInt();
			System.out.print("Weight: ");
			double weight = scan.nextDouble();
			System.out.print("Height: ");
			double height = scan.nextDouble();
			
			Person p = new Person(name, age, height, weight);
			
			return p;
		} catch (RuntimeException e) {
			throw new PersonException("Error: this operation cannot be carried out!");
		} finally {
			UI.clearScreen();
		}
	}

	public void readPeopleList(List<Person> peopleList) {
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			
			String itemFileText = br.readLine();
			while (itemFileText != null) {
				
				String[] lines = itemFileText.split(",");
				String namePerson = lines[2];
				int agePerson = Integer.parseInt(lines[3]);
				double weightPerson = Double.parseDouble(lines[4]);
				double heightPerson = Double.parseDouble(lines[5]);
				peopleList.add(new Person(namePerson, agePerson, heightPerson, weightPerson));
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file!");
		} finally {
			UI.clearScreen();
		}
	}

	public void updatePerson() {

	}

	public void deletePerson() {

	}
	
	public void saveRegisteredPeople (List<Person> peopleList) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFileStr, true))) {
			bw.write("\tPEOPLE LIST");
			bw.newLine();
			if (peopleList.size() == 1) {
				bw.write("THERE IS " + peopleList.size() + " REGISTERED");
				bw.newLine();
			} else {
				bw.write("THERE ARE " + peopleList.size() + " REGISTERED");
				bw.newLine();
			}
			for (Person p : peopleList) {
				bw.write("Person " + (1 + peopleList.indexOf(p)));
				bw.newLine();
				bw.write(p.getName() 
				+ "," 
				+ p.getAge() 
				+ "," 
				+ String.format("%.2f", p.getWeight())
				+ ","
				+ String.format("%.2f", p.getHeight())
				+ "," + String.format("%.2f", p.getIMC()));
				bw.newLine();
//				peopleList.remove(p);
			}
			UI.messageCreatedPerson();
		} catch (IOException e) {
			System.out.println("Error creating file!");
			e.printStackTrace();
		} finally {
//			UI.clearScreen();
		}
	}
	
	public void listPeople(List<Person> peopleList) {
		try {
			if (peopleList.size() == 0) {
				System.out.println("The list is empty");
			} else {
				System.out.println();
				for (Person p: peopleList) {
					System.out.println(p);
				}
			}
		}
		catch (PersonException e) {
			throw new PersonException("It was not possible to list the people");
		}
	}
}
