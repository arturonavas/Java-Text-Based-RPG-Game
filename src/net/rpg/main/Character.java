package net.rpg.main;

public class Character extends Player {
	// Enteros para guardar los niveles y usarlos
	public int numAtkUpgrade, numDefUpgrade;

	// Arrays para guardar los nombres de las mejoras
	public String[] atkUpgradesList = {"Fuerza audaz", "Fuerza de Oso", "Gran poder", "Fuerza de Dios"};
	public String[] defUpgradesList = {"Defensa sobrehumana", "Huesos Pesados", "Piel de Piedra", "Aura Dorada"};

	// Constructor específico del jugador
	public Character(String name) {
		// Llamando al constructor de la superclase
		super(name, 100, 0);
		this.numAtkUpgrade = 0;
		this.numDefUpgrade = 0;
		// Dejar que el jugador elija una ventaja
		chooseTrait();
	}

	// Métodos específicos del jugador
	@Override
	public int attack() {
		return 0;
	}

	@Override
	public int defense() {
		return 0;
	}

	public void chooseTrait() {
		RPGLogic.printHeading("Elige una ventaja ");
		System.out.println("(1) " + atkUpgradesList[numAtkUpgrade]);
		System.out.println("(2) " + defUpgradesList[numDefUpgrade]);
		// Imprimir decisión del usuario
		int input = RPGLogic.readInt("->", 2);

		//para ambos casos
		if (input == 1){
			RPGLogic.printHeading(("Has elegido "+ atkUpgradesList[numAtkUpgrade]));
			numAtkUpgrade++;
		}else{
			RPGLogic.printHeading(("Has elegido "+ defUpgradesList[numDefUpgrade]));
			numDefUpgrade++;
		}
		RPGLogic.toContinue();

	}
}
