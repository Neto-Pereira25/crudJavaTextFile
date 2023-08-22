package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Person;
import entities.PersonException;
import servicesPerson.Service;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		Service service = new Service();

		List<Person> peopleList = new ArrayList<>();
		
		Integer option = 0;

		while (option != 10) {
			try {
				UI.printOptionsMenu();
				option = UI.readChoose(scan);
				if (option == 1) {
					peopleList.add(service.registerPerson());
				} else if (option == 2) {
					service.readPeopleList(peopleList);
				} else if (option == 3) {
					service.updatePerson(peopleList);
				} else if (option == 4) {
					service.deletePerson(peopleList);
				} else if (option == 5) {
					service.saveRegisteredPeople(peopleList);
				} else if (option == 6) {
					service.listPeople(peopleList);
				}

			} catch (PersonException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

}
