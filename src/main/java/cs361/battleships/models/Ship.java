package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import java.util.ArrayList;


public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	private String shipType;

	public Ship(){
		this.occupiedSquares = new ArrayList<Square>();
		this.shipType = null;
	}


	public Ship(String kind) {
		this.occupiedSquares = new ArrayList<Square>();
		this.shipType = kind;
	}


	public Boolean setOccupiedSquares(char column, int row, Boolean isVertical){
		if (this.shipType.equals("MINESWEEPER"))
		{
			if(isVertical){

				if(row <1 || row >9) {
					return false; // exit if input row is over limit
				}

				if(column > 'J' || column < 'A'){
					return false;
				}

				occupiedSquares.add(new Square(row, column));
				occupiedSquares.add(new Square(row+1, column));
				return true;
			}

			if(isVertical == false) {
				if(row <1 || row >10) {
					return false; // exit if input row is over limit
				}

				if(column > 'I' || column < 'A'){
					return false;
				}

				occupiedSquares.add(new Square(row, column));
				occupiedSquares.add(new Square(row, (char) (column+1)));
				return true;
			}
		}


		if (this.shipType.equals("DESTROYER"))
		{
			if(isVertical){

				if(row <1 || row >8) {
					return false; // exit if input row is over limit
				}

				if(column > 'J' || column < 'A'){
					return false;
				}

				occupiedSquares.add(new Square(row, column));
				occupiedSquares.add(new Square(row+1, column));
				occupiedSquares.add(new Square(row+2, column));
				return true;
			}

			if(isVertical == false) {
				if(row <1 || row >10) {
					return false; // exit if input row is over limit
				}

				if(column > 'H' || column < 'A'){
					return false;
				}

				occupiedSquares.add(new Square(row, column));
				occupiedSquares.add(new Square(row, (char) (column+1)));
				occupiedSquares.add(new Square(row, (char) (column+2)));

				return true;
			}
		}

		if (this.shipType.equals("BATTLESHIP"))
		{
			if(isVertical){

				if(row <1 || row >7) {
					return false; // exit if input row is over limit
				}

				if(column > 'J' || column < 'A'){
					return false;
				}

				occupiedSquares.add(new Square(row, column));
				occupiedSquares.add(new Square(row+1, column));
				occupiedSquares.add(new Square(row+2, column));
				occupiedSquares.add(new Square(row+3, column));
				return true;
			}

			if(isVertical == false) {
				if(row <1 || row >10) {
					return false; // exit if input row is over limit
				}

				if(column > 'G' || column < 'A'){
					return false;
				}

				occupiedSquares.add(new Square(row, column));
				occupiedSquares.add(new Square(row, (char) (column+1)));
				occupiedSquares.add(new Square(row, (char) (column+2)));
				occupiedSquares.add(new Square(row, (char) (column+3)));
				return true;
			}
		}

		return false;
	}

	public List<Square> getOccupiedSquares() {
		return this.occupiedSquares;
	}
}
