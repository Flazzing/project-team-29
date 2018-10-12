package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BoardTest {

    @Test
    public void testInvalidPlacement()
    {

        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 11, 'C', true));


        board.placeShip(new Ship("MINESWEEPER"), 3, 'A',true);
       if(board.placeShip(new Ship("MINESWEEPER"), 4, 'A',false) == false) {
           System.out.println("Error collision");
       }

    }

    @Test
    public void testValidPlacement()
    {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 3, 'A',true);

        assertTrue(board.placeShip(new Ship("MINESWEEPER"),1, 'A', true ));
        assertTrue(board.placeShip(new Ship("BATTLESHIP"), 5, 'A', false));
        assertTrue(board.placeShip(new Ship("DESTROYER"), 2, 'E', true));

        for (Ship ship: board.getShips())
        {
            for(Square temp: ship.getOccupiedSquares())
            {
                System.out.println(temp.getColumn() + " " + temp.getRow());
            }
        }

    }
}