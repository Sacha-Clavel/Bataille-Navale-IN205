package app.main.player;

import app.main.ships.*;
import app.main.board.*;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;



public class TestPlayer {


    public static void main( String[] args ){
        Board Board = new Board("Grille test");
        Board OpponentBoard = new Board("Grille test");
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        Destroyer FirstShip = new Destroyer();
        Submarine SecondShip = new Submarine();
        Submarine ThirdShip = new Submarine();
        Battleship FourthShip = new Battleship();
        Carrier FithShip = new Carrier();
        ships.add(FirstShip);
        ships.add(SecondShip);
        ships.add(ThirdShip);
        ships.add(FourthShip);
        ships.add(FithShip);


        Player player = new Player(Board, OpponentBoard, ships);
        player.putShips();

        

    }

}
