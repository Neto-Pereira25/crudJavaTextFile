package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;
import entities.PersonException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		Person person;

		while (true) {
			try {
				UI.clearScreen();
				UI.printOptionsMenu();
				int option = UI.readChoose(scan);
				
				if (option == 1) {
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
					person = new Person(name, age, height, weight);
					person.registerPerson();
				}
				
			} catch (PersonException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
