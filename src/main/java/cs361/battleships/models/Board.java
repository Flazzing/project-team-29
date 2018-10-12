package cs361.battleships.models;

import org.apache.commons.lang3.ObjectUtils;

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
		ship = new Ship(ship.getShipType());

		if(ship.setOccupiedSquares(y, x, isVertical))
		{
			for (Ship existShip : this.shipList)
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
			this.shipList.add(ship);
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
		Result result = new Result();
		AtackStatus status;
		List<Square> squaresToRemove = new ArrayList<Square>();

		for(Result r : attackList)
		{
			if(r.getLocation().getColumn() == y && r.getLocation().getRow() == x)
			{
				status = AtackStatus.INVALID;
				result.setResult(status);
				return result;

			}
		}
		if (((x >= 1) && (x <= 10)) && ((y >= 'A') && (y <= 'J'))) {
			status = AtackStatus.MISS;
			result.setResult(status);
			result.setLocation(new Square(x, y));
			for (Ship existingShip : shipList) {
				for (Square sq : existingShip.getOccupiedSquares()) {

					if ((x == sq.getRow()) && (y == sq.getColumn())) {
						result.setShip(existingShip);
						squaresToRemove.add(sq);

						if(existingShip.getOccupiedSquares().size() == 1) {
							status = AtackStatus.SUNK;
							result.setResult(status);
							break;

						} else {
							status = AtackStatus.HIT;
							result.setResult(status);
							break;
						}
					}
				}

				existingShip.getOccupiedSquares().removeAll(squaresToRemove);
			}

			int counter = 1;
			for(Ship existingShip : shipList) {
				if(existingShip.getOccupiedSquares().size() == 0) {
					if(counter == shipList.size()) {
						status = AtackStatus.SURRENDER;
						result.setResult(status);
						break;
					} else {
						counter++;
						continue;
					}
				} else {
					break;
				}
			}
			attackList.add(result);
		}
		else{
			status = AtackStatus.INVALID;
			result.setResult(status);
		}
		return result;
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
