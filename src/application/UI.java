package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void printOptionsMenu() {
		System.out.println();
		System.out.println("Choose one of the options: ");
		System.out.println("1 - REGISTER");
		System.out.println("2 - READ");
		System.out.println("3 - UPDATE");
		System.out.println("4 - DELETE");
		System.out.println("5 - EXIT");
	}

	public static int readChoose(Scanner scan) {
		try {
			int choose = scan.nextInt();
			return choose;
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error reading your choose. Valid values are from 1 to 5");
		}
	}
	
	public static void messageCreatedPerson() {
		System.out.println("person sucessfully registered!");
	}
}
