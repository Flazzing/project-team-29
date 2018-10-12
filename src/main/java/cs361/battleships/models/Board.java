package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List <Ship> shipList;
	private List <Result> attackList;

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		shipList = new ArrayList<Ship>();
		attackList = new ArrayList<Result>();
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		if(ship.setOccupiedSquares(y, x, isVertical))
		{
			for (Ship existShip : shipList)
			{
				for (Square temp : existShip.getOccupiedSquares()) // not necessary
				{
					for (Square temp2 : ship.getOccupiedSquares())
					{
						if ((temp.getColumn() == temp2.getColumn()) && (temp.getRow() == temp2.getRow()))
						{
							return false;
						}
					}
				}
			}
			shipList.add(ship);
			return true;
		}
		else {
			return false;
		}

	}


	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		//TODO Implement
		return null;
	}

	public List<Ship> getShips() {
		return this.shipList;
	}

	public void setShips(List<Ship> ships) {
		this.shipList = ships;
	}

	public List<Result> getAttacks() {
		return this.attackList;
	}

	public void setAttacks(List<Result> attacks) {
		this.attackList = attacks;
	}
}
