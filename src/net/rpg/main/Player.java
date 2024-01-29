package net.rpg.main;

public abstract class Player {
	//Variables para todos los personajes
	String name;
	public int maxHP, hp, xp;
	//Contructor para los personajes
	public Player(String name, int maxHP, int xp){
		this.name = name;
		this.maxHP = maxHP;
		this.xp = xp;
	}

	//metodos para los personajes
	public abstract int attack();
	public abstract  int defense();
}
