package cs361.battleships.models;

public class Result {

	private AtackStatus result;
	private Ship ship;
	private Square square;

	public AtackStatus getResult() {
		return this.result;
	}

	public void setResult(AtackStatus resultIn) {
		this.result = resultIn;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship shipIn) {
		this.ship = shipIn;
	}

	public Square getLocation() {
		return this.square;
	}

	public void setLocation(Square squareIn) {
		this.square = squareIn;
	}
}
