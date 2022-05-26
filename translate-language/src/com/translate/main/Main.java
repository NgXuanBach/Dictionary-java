package com.translate.main;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

import com.translate.handle.DictionaryHandler;
import com.translate.handle.EnglishDictionaryHandler;
import com.translate.handle.FileHandler;
import com.translate.handle.IDictionaryHandler;
import com.translate.handle.IEnglishDictionaryHandler;
import com.translate.handle.IFileHandler;
import com.translate.handle.IVietnameseDictionaryHandler;
import com.translate.handle.VietnameseDictionaryHandler;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static final String FILE_DICTIONARY = "D:/java-workspace/translate-language/src/com/translate/main/Dictionary.txt";
	private static IDictionaryHandler dictionaryHandler;
	private static Map<String, String> dictionaryVietNamese;
	private static Map<String, String> dictionaryEnglish;
	private static IEnglishDictionaryHandler englishDictionaryHandler;
	private static IVietnameseDictionaryHandler vietnameseDictionaryHandler;

	public static void main(String[] args) {
		englishDictionaryHandler = new EnglishDictionaryHandler();
		vietnameseDictionaryHandler = new VietnameseDictionaryHandler();
		IFileHandler fileHandler = new FileHandler();
		dictionaryEnglish = new HashMap<>();
		dictionaryVietNamese = new HashMap<>();
		dictionaryHandler = new DictionaryHandler();
		int funcionNumber;
		int subFuncionNumber;
		dictionaryHandler.readToMemory(
				vietnameseDictionaryHandler.listVietnameseDictionary(fileHandler.read(FILE_DICTIONARY)),
				englishDictionaryHandler.listEnglishDictionary(fileHandler.read(FILE_DICTIONARY)), dictionaryEnglish);
		dictionaryHandler.readToMemory(
				englishDictionaryHandler.listEnglishDictionary(fileHandler.read(FILE_DICTIONARY)),
				vietnameseDictionaryHandler.listVietnameseDictionary(fileHandler.read(FILE_DICTIONARY)),
				dictionaryVietNamese);
		showMainMenu();
		funcionNumber = scanner.nextInt();
		do {
			switch (funcionNumber) {
			case 0:
				System.out.println("End program.");
				break;
			case 1:
				boxSearch(dictionaryVietNamese);
				break;
			case 2:
				boxSearch(dictionaryEnglish);
				break;
			default:
				System.out.println("Incorrect, please re-enter !");
			}
			if (funcionNumber != 0) {
				do {
					subFuncionNumber = -1;
					try {
						showSubMenu();
						subFuncionNumber = scanner.nextInt();
						switch (subFuncionNumber) {
						case 1:
							System.out.println("Swap !!");
							funcionNumber = 3 - funcionNumber;
							break;
						case 2:
							System.out.println("Back !");
							showMainMenu();
							funcionNumber = scanner.nextInt();
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

	public static void boxSearch(Map<String, String> dictionary) {
		System.out.println("enter the word you want to find: ");
		scanner.nextLine();
		String key = scanner.nextLine();
		dictionaryHandler.boxSearch(key, dictionary);
		System.out.println("----------------------------------");
	}
}
