package com.translate.main;

import java.util.Scanner;

import com.translate.handle.DictionaryHandler;
import com.translate.handle.FileHandler;
import com.translate.handle.IDictionaryHandler;
import com.translate.handle.IFileHandler;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static final String FILE_DICTIONARY = "D:/java-workspace/translate-language/src/com/translate/main/Dictionary.txt";
	private static IDictionaryHandler dictionaryHandler;
	private static int funcionNumber = -1;
	private static int subFuncionNumber;

	public static void main(String[] args) {
		IFileHandler fileHandler = new FileHandler();
		dictionaryHandler = new DictionaryHandler();
		dictionaryHandler.readToMemory(fileHandler.read(FILE_DICTIONARY));
		funcionNumber = -1;
		handleMenu();
		do {
			switch (funcionNumber) {
			case 0:
				break;
			case 1:
				boxSearch();
				break;
			case 2:
				boxSearch();
				break;
			default:
				System.out.println("Incorrect, please re-enter !");
			}
			if (funcionNumber == 1 || funcionNumber == 2) {
				do {
					try {
						subFuncionNumber = -1;
						showSubMenu();
						subFuncionNumber = scanner.nextInt();
						switch (subFuncionNumber) {
						case 1:
							System.out.println("Swap !!");
							funcionNumber = 3 - funcionNumber;
							break;
						case 2:
							System.out.println("Back !");
							handleMenu();
							break;
						default:
							System.out.println("Incorrect, please re-enter !");
						}
					} catch (Exception e) {
						System.out.println("Incorrect, please re-enter !");
						scanner.next();
					}

				} while (subFuncionNumber != 1 && subFuncionNumber != 2);
			}

		} while (funcionNumber != 0);
	}

	public static void showMainMenu() {
		System.out.println("1. English - Vietnamese\r\n" + "2. Vietnamese - English\r\n" + "0. Exist"
				+ "\n------------------\n" + "Please enter the funcion: ");
	}

	public static void showSubMenu() {
		System.out.println("Please enter the funcion.\n1. Language Swap\r\n" + "2. Back\r\n" + "");
	}

	public static void boxSearch() {
		System.out.println("enter the word you want to find: ");
		scanner.nextLine();
		String key = scanner.nextLine();
		dictionaryHandler.boxSearch(key);
		System.out.println("----------------------------------");
	}

	public static void handleMenu() {
		while (true) {
			try {
				showMainMenu();
				funcionNumber = scanner.nextInt();
				if (funcionNumber == 0) {
					System.out.println("End program.");
					return;
				}
				if (funcionNumber == 1 || funcionNumber == 2) {
					return;
				}
			} catch (Exception e) {
				System.out.println("Incorrect, please re-enter !");
				scanner.next();
			}
		}
	}
}
