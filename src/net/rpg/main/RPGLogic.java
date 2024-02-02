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
	//comandos de batalla
	public static String [] encounters = {"Batalla","Batalla","Batalla","Descanso","Descanso"};
	//Nombre de los enemigos
	public static String [] enemies = {"Espectro Helado","Orco","Mago Corrupto","Orco","Quimera"};


	//para saber en que lugar se encuentra el jugador
	public static int place = 1, act;
	public static String [] places = {"Montanas eternas", "Tierras Embrujadas","Castillo del Emperador", "Sala del Trono"};
	//Metodo que cambia los valores del juego segun el nivel de la experiencia del jugador
	public static void checkAct(){
		// Cambiar acto basado en experiencia
		if(player.xp >= 10 && act == 1){
			// Incrementar acto y ubicación
			act = 2;
			place = 1;
			// Historia
			Story.printFirstActOutro();
			// Permitir que el jugador "suba de nivel"
			player.chooseTrait();
			// Historia
			Story.printSecondActIntro();
			// Asignar nuevos valores a los enemigos
			enemies[0] = "Mercenario Malvado";
			enemies[1] = "Goblin";
			enemies[2] = "Manada de Lobos";
			enemies[3] = "Esbirro del Emperador Malvado";
			enemies[4] = "Desconocido Aterrador";
			// Asignar nuevos valores a los encuentros
			encounters[0] = "Batalla";
			encounters[1] = "Batalla";
			encounters[2] = "Batalla";
			encounters[3] = "Descanso";
			encounters[4] = "Tienda";
		}else if(player.xp >= 50 && act == 2){
			// Incrementar acto y ubicación
			act = 3;
			place = 2;
			// Historia
			Story.printSecondActOutro();
			// Subir de nivel
			player.chooseTrait();
			// Historia
			Story.printThirdActIntro();
			// Asignar nuevos valores a los enemigos
			enemies[0] = "Mercenario Malvado";
			enemies[1] = "Mercenario Malvado";
			enemies[2] = "Esbirro del Emperador Malvado";
			enemies[3] = "Esbirro del Emperador Malvado";
			enemies[4] = "Esbirro del Emperador Malvado";
			// Asignar nuevos valores a los encuentros
			encounters[0] = "Batalla";
			encounters[1] = "Batalla";
			encounters[2] = "Batalla";
			encounters[3] = "Batalla";
			encounters[4] = "Tienda";
			// Curar completamente al jugador
			player.hp = player.maxHP;
		}else if(player.xp >= 100 && act == 3){
			// Incrementar acto y ubicación
			act = 4;
			place = 3;
			// Historia
			Story.printThirdActOutro();
			// Subir de nivel
			player.chooseTrait();
			// Historia
			Story.printFourthActIntro();
			// Curar completamente al jugador
			player.hp = player.maxHP;
			// Llamada a la batalla final
			//finalBattle();
		}
	}
	//Metodo para crear una batalla aleatoria
	public static void randomBattle(){
		printHeading("Te has topado con un enemigo. Preparate para luchar!");
		toContinue();
		//Crear un nuevo enemigo con un nombre aleatorio
		battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
	}
	//metodo PRINCIPAL de la batalla
	private static void battle(Enemy enemy) {
		while (true) {
			printHeading(STR."\{enemy.name} /HP: \{enemy.hp} / \{enemy.maxHP}");
			printHeading(STR."\{player.name} /HP: \{player.hp} / \{player.maxHP}");
			System.out.println("Elige una accion");
			printSep(10);
		}
	}

	//Metodo para el encuentro aleatorio
	public static void randomEncounter(){
		int encounter = (int) (Math.random()* encounters.length);
		if (encounters[encounter].equals("Battle")){
			//randomBattle();
		}else if (encounters[encounter].equals("Rest")){
			//takeRest();
		}else{
			//shop();
		}
	}

	public static void printSep(int n) {
		for (int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
	}

	public static void resetGame() {
		player = null; // Puedes ajustar esto según sea necesario
		isRunning = false;
		Main.main();
	}

	public static void printHeading(String title) {
		printSep(40);
		System.out.println(title);
		printSep(40);
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

		//imprimir la historia del juego
		Story.printIntro();


		player = new Character(name);
		//Hacer que "isRunnig" sea true para que el loop del juego empiece
		isRunning = true;

		//Creacion del loop principal del juego
		gameLoop();
	}
	public static  void continueJourney(){
		//Checkea en que parte de de la historia deberiamos estar
		checkAct();
		//Checkea si el juego no esta en la pelea final
		if (act != 4) {
			randomEncounter();
		}

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
		printHeading(places[place]);
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
