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
				
				System.out.println(itemFileText);
				
				String[] lines = itemFileText.split(",");
				
				String namePerson = lines[0];
				int agePerson = Integer.parseInt(lines[1]);
				double weightPerson = Double.parseDouble(lines[2]);
				double heightPerson = Double.parseDouble(lines[3]);
				
				peopleList.add(new Person(namePerson, agePerson, heightPerson, weightPerson));
				
				itemFileText = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file!");
		} finally {
			UI.clearScreen();
		}
	}

	public void updatePerson(List<Person> peopleList) {
		if (peopleList.size() == 0) {
			throw new ServiceException("Cannot update, because the list is empty");
		}
		try {
			listPeople(peopleList);
			System.out.print("Enter the number of the person you want to change: ");
			int number = scan.nextInt();
			
			number--;
			scan.nextLine();
			System.out.println("Now enter the updated data:");
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Age: ");
			int age = scan.nextInt();
			System.out.print("Weight: ");
			double weight = scan.nextDouble();
			System.out.print("Height: ");
			double height = scan.nextDouble();
			Person person = new Person(name, age, height, weight);
			peopleList.set(number, person);
			
			UI.messageCreatedPerson("People sucessfully updated!");
		}
		catch (RuntimeException e) {
			throw new ServiceException("Error when updating the person's data!");
		}
	}

	public void deletePerson(List<Person> peopleList) {
		if (peopleList.size() == 0) {
			throw new ServiceException("Cannot delete, because the list is empty");
		}
		
		try {
			listPeople(peopleList);
			System.out.print("Enter the number of the person you want to delete: ");
			int number = scan.nextInt();
			
			number--;
			
			peopleList.remove(number);
			
			UI.messageCreatedPerson("People sucessfully deleted!");
		}
		catch (RuntimeException e) {
			throw new ServiceException("Error when deleting person!");
		}
	}
	
	public void saveRegisteredPeople (List<Person> peopleList) {
		if (peopleList.size() == 0) {
			throw new ServiceException("Your list is empty, add at least one person to be able to save!");
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFileStr))) {
			for (Person p : peopleList) {
				bw.write(p.getName() 
				+ "," 
				+ p.getAge() 
				+ "," 
				+ String.format("%.2f", p.getWeight())
				+ ","
				+ String.format("%.2f", p.getHeight())
				+ "," + String.format("%.2f", p.getIMC()));
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error creating file!");
			e.printStackTrace();
		} finally {
			peopleList.clear();
			UI.clearScreen();
			UI.messageCreatedPerson("People sucessfully registered! Your list in now empty");
		}
	}
	
	public void listPeople(List<Person> peopleList) {
		try {
			if (peopleList.size() == 0) {
				System.out.println();
				System.out.println("The list is empty");
			} else {
				System.out.println("-------------- LIST OF PEOPLE --------------");
				if (peopleList.size() == 1) {
					System.out.println("THERE IS " + peopleList.size() + " REGISTERED\"");
				} else {
					System.out.println("THERE ARE " + peopleList.size() + " REGISTERED\"");
				}
				System.out.println();
				for (Person p: peopleList) {
					System.out.println((1 + peopleList.indexOf(p)) + " - " + p);
				}
			}
		}
		catch (ServiceException e) {
			throw new ServiceException("It was not possible to list the people");
		}
	}
}
