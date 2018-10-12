package cs361.battleships.models;

import org.junit.Test;

public class ShipTest {


    @Test
    public void testInvalidPlacement() {
        Ship x = new Ship("Minesweeper");
        boolean result =   x.setOccupiedSquares('A', 3, true);

        if(result == true){
            System.out.println("Success");
        }
        else {
            System.out.println("Error");
        }
    }

}
