package net.rpg.main;

public class Enemy extends Player{
	//Vriable para guardar la experiencia del jugador actual
	int playerXP;
	//Constructor para el enemigo especifico
	public Enemy(String name, int playerXP) {
		super(name, (int)(Math.random()*playerXP+playerXP/3 +5), (int) (Math.random()*playerXP/4+2)+1);
		//Asignando variables
		this.playerXP = playerXP;
	}
	//Calculo de el ataque y defensa especificos de los enemigos
	@Override
	public int attack() {
		return (int) (Math.random()*(playerXP/4 + 1) + xp / 4 + 3 );
	}

	@Override
	public int defense() {
		return (int) (Math.random()*(playerXP/4 + 1) + xp / 4 + 3 );
	}
}
