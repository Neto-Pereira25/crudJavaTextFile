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
		System.out.println("1 - REGISTER PERSON");
		System.out.println("2 - READ LIST PEOPLE");
		System.out.println("3 - UPDATE PERSON");
		System.out.println("4 - DELETE PERSON");
		System.out.println("5 - SAVE REGISTERED PEOPLE");
		System.out.println("6 - LIST PEOPLE");
		System.out.println("7 - DELETE FILE");
		System.out.println("10 - EXIT");
	}

	public static int readChoose(Scanner scan) {
		try {
			int choose = scan.nextInt();
			if (choose == 10) {
				return choose;
			}
			if (choose < 1 || choose > 7) {
				System.out.println();
				throw new InputMismatchException("Error reading your choose. Valid values are from 1 to 5");
			}
			return choose;
		} catch (RuntimeException e) {
			System.out.println();
			throw new InputMismatchException("Error reading your choose. Enter a value from 1 to 5");
		}
	}
	
	public static void messageToUser(String msg) {
		System.out.println();
		System.out.print(msg);
		System.out.println();
	}
}
