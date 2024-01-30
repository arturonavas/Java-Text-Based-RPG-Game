package net.rpg.main;

public class Story {
	// Clase para crear métodos de storytelling para la historia que va a contener el juego
	public static void printIntro() {
		RPGLogic.printSep(30);
		System.out.println("(I) PROLOGO");
		imprimirConRetraso("En los rincones más oscuros y olvidados de nuestro mundo,\n" +
				"donde las sombras se entrelazan con las almas perdidas,\n" +
				"se oculta una verdad aterradora.");
		System.out.println();
		imprimirConRetraso("Hace siglos, antiguos hechiceros sellaron horrores indescriptibles,\n" +
				"criaturas de pesadilla y maldiciones prohibidas.\n" +
				"Pero el tiempo y la ambición humana han debilitado esas ataduras.");
		System.out.println();
		imprimirConRetraso("Ahora, en la encrucijada del destino, un estudiante común,\n" +
				"ajeno a los oscuros secretos, se ve arrastrado a este torbellino.\n" +
				"Entre las páginas de hechizos prohibidos y criaturas despertadas,\n" +
				"nace un nuevo capítulo en la eterna lucha entre la luz y las sombras.");
		System.out.println();
		imprimirConRetraso("La maldición acecha, los demonios despiertan,\n" +
				"y la única esperanza yace en aquellos dispuestos a enfrentar\n" +
				"las profundidades del ocultismo para proteger el frágil equilibrio.");
		System.out.println();
		imprimirConRetraso(STR."Prepárate, valiente aventurero, para adentrarte en un mundo donde\nla magia y las maldiciones convergen, donde los hechizos y las\nespadas se entrelazan en una danza mortal. La sombra se despierta,\ny solo aquellos dispuestos a desafiarla podrán cambiar el destino.\n\{RPGLogic.player.name} te uniras a esta aventura? ");
		System.out.println();
		System.out.println("(1) Si, estoy dispuesto");
		System.out.println("(2) No, tengo meyo :c");
		int input = RPGLogic.readInt("->",2);
		RPGLogic.scanner.next();
		if (input == 1){
			System.out.println("Que tu aventura empiece!");
			RPGLogic.toContinue();
		}
		else if (input == 2){
			System.out.println("Los dioses castigan tu cobardia ejecutandote con un rayo celestial enviado directamente desde su palacio");
			RPGLogic.resetGame();
		}
	}

	public static void imprimirConRetraso(String texto) {
		for (char letra : texto.toCharArray()) {
			System.out.print(letra);
			pausa(10); // Pausa de 30 milisegundos entre cada letra (ajusta según sea necesario)
		}
		System.out.println(); // Salto de línea al final del texto
	}

	public static void pausa(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
