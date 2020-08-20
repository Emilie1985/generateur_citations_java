package com.generateur;

import java.util.Scanner;

public class Phrases {
	Scanner sc = new Scanner(System.in);
	private static String[][] sujets = {
			{ "Le chat", "L'éléphant", "La voiture", "Jack", "La pomme", "La guitare", "Le livre", "La maison",
					"La boîte", "L'album" },
			{ "The cat", "The elephant", "The car", "Jack", "The apple", "The guitar", "The book", "The house",
					"The box", "The album" } };
	private static String[][] verbes = {
			{ "chante", "joue", "roule", "parle", "rampe", "s'ennuie", "boit", "travaille", "crie", "dort" },
			{ "sings", "plays", "rolls", "talk", "crawls", "is borring", "drinks", "works", "screams", "sleeps" } };
	private static String[][] complements = {
			{ "dehors.", "le soir.", "en Italie.", "toute la journée.", "sous la pluie.", "dans la rue.",
					"très fort." },
			{ "outside.", "the evening.", "in Italy.", "all day long.", "under the rain.", "in the street.",
					"loudly." } };
	public String langage;
	public int nbPhrases;

	/*
	 * public Phrases(String langue) { // TODO Auto-generated constructor stub
	 * langage = langue;
	 * 
	 * }
	 */

	public String newPhrase(String langue) {

		return this.randomItem(sujets, langue) + " " + this.randomItem(verbes, langue) + " "
				+ this.randomItem(complements, langue);
	}

	private String randomItem(String[][] list, String langue) {
		int whichList = 0;
		if (langue.equals("A")) {
			whichList = 1;
		}
		if (langue.equals("F")) {
			whichList = 0;
		}

		int number = (int) Math.floor(Math.random() * list[whichList].length);
		return list[whichList][number];
	}

	private void nbPhrases() {

		System.out.println("Combien de phrases souhaitez-vous générer ? Entre 1 et 5. ");
		// nbPhrases = sc.nextInt();

		try {
			nbPhrases = sc.nextInt();
			if (nbPhrases >= 1 && nbPhrases <= 5) {
				System.out.println("Vous souhaitez générer " + nbPhrases + " phrases.");
				sc.nextLine();
				this.langage();
			} else {
				System.out.println("Vous devez saisir un nombre entre 1 et 5");
				sc.nextLine();
				this.nbPhrases();
			}
		} catch (Exception e) {
			System.out.println(e);
			sc.nextLine();
			this.nbPhrases();
		}
	}

	private void langage() {
		System.out.println("En quelle langue souhaitez-vous les générer ? Français ou Anglais : F/A ? ");
		try {
			String langageChar = sc.nextLine();
			langageChar = langageChar.toUpperCase();
			if (langageChar.equals("A") || langageChar.equals("F")) {
				langage = langageChar;
			} else {
				System.out.println("Vous devez saisir A pour Anglais ou F pour Français");
				this.langage();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void again() {
		System.out.println("Souhaitez-vous recommencer ? O/N ");
		String doItAgain = sc.nextLine();
		doItAgain = doItAgain.toUpperCase();
		if (doItAgain.equals("O")) {
			this.plusieursPhrases();
		} else if (doItAgain.equals("N")) {
			System.out.println("A bientôt");
		} else {
			System.out.println("Vous devez taper O pour oui ou N pour non");
			this.again();
		}
	}

	public void plusieursPhrases() {
		this.nbPhrases();

		// String lg = this.langage();
		String finalStrings = "";
		for (int i = 0; i < nbPhrases; i++) {
			finalStrings += this.newPhrase(langage) + System.lineSeparator();
		}
		System.out.println(finalStrings);
		this.again();
	}

}
