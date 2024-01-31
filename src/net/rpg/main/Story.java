package net.rpg.main;

public class Story {
	public static void pausa(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void imprimirConRetraso(String texto) {
		for (char letra : texto.toCharArray()) {
			System.out.print(letra);
			pausa(25); // Pausa de milisegundos entre cada letra (ajusta según sea necesario)
		}
		System.out.println(); // Salto de línea al final del texto
	}



	public static void printIntro() {
		RPGLogic.printSep(30);
		System.out.println("HISTORIA");
		RPGLogic.printSep(30);
		imprimirConRetraso("Eres el último hombre en pie después de que tu aldea fue saqueada por los secuaces del malvado emperador.");
		imprimirConRetraso("Todos y cada uno de tus amigos, familiares y vecinos fueron asesinados. Te encuentras en las ruinas ardientes de lo que una vez fue este hermoso pueblo.");
		imprimirConRetraso("Todo lo que deseas ahora es venganza, así que comienzas a planificar tu viaje para derrotar al malvado emperador y liberar las tierras.");
		RPGLogic.toContinue();
	}

	public static void printFirstActIntro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO I - INTRODUCCIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("Al comenzar tu viaje, comienzas a viajar a través de los bosques cercanos para llegar a las montañas eternas.");
		imprimirConRetraso("Las montañas eternas son un lugar muy peligroso. Se dice que nadie regresó con vida de allí.");
		imprimirConRetraso("\nDespués de un largo día caminando por el bosque, finalmente llegas a las montañas eternas.");
		imprimirConRetraso("No te importan las cosas que has escuchado sobre este peligroso lugar y comienzas tu viaje para derrotar al malvado emperador.");
		RPGLogic.toContinue();
	}
	public static void printFirstActOutro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO I - CONCLUSIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("¡Lo lograste! ¡Atravesaste las montañas eternas y aún estás vivo!");
		imprimirConRetraso("Mientras desciendes la última colina, estás más que feliz de sentir tierra firme bajo tus pies nuevamente.");
		imprimirConRetraso("\nTe sientes empoderado y la experiencia que ganaste te permite aprender otro rasgo.");
		RPGLogic.toContinue();
	}

	public static void printSecondActIntro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO II - INTRODUCCIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("Comienzas a viajar por las tierras de este una vez bien poblado campo.");
		imprimirConRetraso("Has recogido algo de oro de los monstruos que has matado en el camino.");
		imprimirConRetraso("Afortunadamente, sabes que de vez en cuando un comerciante ambulante pasa por estas tierras.");
		imprimirConRetraso("Sabes exactamente dónde está el castillo del malvado emperador, pero primero debes cruzar estas tierras embrujadas...");
		RPGLogic.toContinue();
	}

	public static void printSecondActOutro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO II - CONCLUSIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("¡Lograste cruzar las tierras embrujadas y aún estás vivo!");
		imprimirConRetraso("Estás a solo unas horas de tu destino final; ¡el castillo del Emperador Malvado!");
		imprimirConRetraso("Sabes que probablemente no puedas descansar allí, así que haces una última pausa para restaurar algo de salud.");
		imprimirConRetraso("\nDespués de todo lo que has visto, te sientes empoderado para aprender otro rasgo.");
		RPGLogic.toContinue();
	}

	public static void printThirdActIntro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO III - INTRODUCCIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("Ves el enorme castillo negro frente a ti.");
		imprimirConRetraso("Mientras estás parado frente a las puertas, sabes que no hay vuelta atrás.");
		imprimirConRetraso("Estás disfrazado como un mercenario y entras al castillo. No sabes cuánto tiempo te queda antes de que alguien te descubra.");
		imprimirConRetraso("Lo único que puedes hacer ahora es luchar por tu vida y rezar para salir como el ganador...");
		RPGLogic.toContinue();
	}
	public static void printThirdActOutro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO III - CONCLUSIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("Llegaste tan lejos. Derrotaste a todos los secuaces del Emperador Malvado.");
		imprimirConRetraso("Mientras estás parado frente a la puerta de su sala del trono, sabes que no hay vuelta atrás.");
		imprimirConRetraso("Recuerdas tu poder perdido y restauras tu salud.");
		imprimirConRetraso("Tienes la oportunidad de aprender un último rasgo antes de entrar en la sala del trono.");
		RPGLogic.toContinue();
	}

	public static void printFourthActIntro() {
		RPGLogic.printSep(30);
		System.out.println("ACTO IV - INTRODUCCIÓN");
		RPGLogic.printSep(30);
		imprimirConRetraso("Entras en la sala del trono del Emperador Malvado.");
		imprimirConRetraso("Te mira fijamente a los ojos. Sientes la oscuridad a tu alrededor.");
		imprimirConRetraso("Saca la espada sagrada de la oscuridad, el arma más poderosa conocida por el hombre.");
		imprimirConRetraso("Lo único que puedes hacer ahora es luchar por tu vida y rezar para salir como el ganador...");
		RPGLogic.toContinue();
	}

	public static void printEnd(Player player) {
		RPGLogic.printSep(30);
		System.out.println(STR."¡Felicidades, \{player.name}! ¡Derrotaste al Emperador Malvado y salvaste el mundo!");
		RPGLogic.printSep(30);
		imprimirConRetraso("¡Espero que hayas disfrutado!");
	}



}
