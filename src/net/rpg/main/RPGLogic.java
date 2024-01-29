package net.rpg.main;

import java.util.Scanner;

public class RPGLogic {
	static Scanner scanner = new Scanner(System.in);
	static Character player;
	public static boolean isRunning;

	public static int readInt(String prompt, int userChoices) {
		int input;
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(scanner.next());

				if (input < 1 || input > userChoices) {
					System.out.println("Por favor ingresa un número válido dentro del rango.");
				}
			} catch (NumberFormatException e) {
				input = -1;
				System.out.println("Por favor ingresa un número válido.");
			}
		} while (input < 1 || input > userChoices);
		return input;
	}

	public static void printSep(int n) {

		for (int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
	}

	public static void printHeading(String title) {
		//printSep(40);
		System.out.println(title);
		//printSep(40);
	}

	public static void toContinue() {
		System.out.println("Ingresa algo para continuar...");
		scanner.nextLine();
	}

	public static void gameStart() {
		boolean nameSet = false;
		String name;

		printSep(40);
		printSep(30);
		System.out.println("SOMBRAS DEL ABISMO");
		System.out.println("RPG DE TEXTO POR ARTURO NAVAS");
		printSep(30);
		printSep(40);
		toContinue();


		do {
			printHeading("Jugador, ¿cuál es tu nombre?");
			name = scanner.nextLine();


			if (name.contains(" ")) {
				printHeading("Error: El nombre no puede contener espacios en blanco. Ingresalo nuevamente");
				name = scanner.nextLine();

			}

			printHeading(STR."Tu nombre es \{name}, ¿es correcto?");
			System.out.println("(1) Sí");
			System.out.println("(2) No, quiero cambiarlo");
			int input = readInt("->", 2);
			scanner.nextLine();

			if (input == 1) {
				nameSet = true;
			}
		} while (!nameSet);
		player = new Character(name);
		//Hacer que "isRunnig" sea true para que el loop del juego empiece
		isRunning = true;

		//Creacion del loop principal del juego
		gameLoop();
	}
	public static  void continueJourney(){

	}
	//imprimir la informacion mas importante del jugador
	public static void characterInfo(){
		printHeading("INFORMACION DEL PERSONAJE");
		System.out.println(STR."\{player.name} - HP \{player.hp}/"+player.maxHP);
		printSep(20);
		System.out.println(STR."XP: \{player.xp}");

		//imprimir si el jugador tiene mejoras
		if (player.numAtkUpgrade > 0){
			System.out.println("Habilidades ofensivas: " + player.atkUpgradesList[player.numAtkUpgrade -1]);
			printSep(20);
		}
		if (player.numDefUpgrade > 0){
			System.out.println("Habilidades defensivas: " + player.defUpgradesList[player.numDefUpgrade-1]);
		}
		toContinue();
	}

	//Imprimir el menu principal
	public static void printMenu(){
		printSep(10);
		printHeading("MENU");
		printSep(10);
		System.out.println("Elige una accion");
		printSep(20);
		System.out.println("(1) Continua tu viaje");
		System.out.println("(2) Mira la informacion de tu personaje");
		System.out.println("(3) Sal del juego");
	}
	//Loop principal del juego
	public static void gameLoop(){
		while (isRunning){
			printMenu();
			int input = readInt("->",3);
			if (input == 1){
				continueJourney();
			}
			else if (input == 2){
				characterInfo();
			}
			else
				isRunning = false;
		}
	}
}
