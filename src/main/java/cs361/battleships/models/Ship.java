package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import java.util.ArrayList;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	private int size;
	private int health;
	private String name;

    public void setName(String kind){
		name = kind;
	}
	public void hit(){
		health--;
	}
	public int getHealth(){
		return health;
	}
	public int getSize(){
		return size;
	}
	public String getName(){
		return name;
	}
	public Ship(String kind) {
		//TODO implement
		if (kind.equalsIgnoreCase("MINESWEEPER")){
			this.size = 2;
			this.health = 2;
		}
			else if (kind.equalsIgnoreCase("DESTROYER")) {
				this.size = 3;
				this.health = 3;
		}	else if (kind.equalsIgnoreCase("BATTLESHIP")){
				this.size = 4;
				this.health = 4;
		}
		ship.setName(kind);
		occupiedSquares = new ArrayList<>();
		}

	public List<Square> getOccupiedSquares() {
		//TODO implement
		return occupiedSquares;
	}
}
