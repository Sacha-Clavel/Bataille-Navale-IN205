package app.main.player;

import app.main.ships.*;
import app.main.board.*;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;



public class TestPlayer {


    public static void main( String[] args ){
        Board BoardPlayer1 = new Board("Tintin");
        List<AbstractShip> shipsPlayer1 = new ArrayList<AbstractShip>();
        Destroyer FirstShipPlayer1 = new Destroyer();
        Submarine SecondShipPlayer1 = new Submarine();
        Submarine ThirdShipPlayer1 = new Submarine();
        Battleship FourthShipPlayer1 = new Battleship();
        Carrier FithShipPlayer1 = new Carrier();
        shipsPlayer1.add(FirstShipPlayer1);
        shipsPlayer1.add(SecondShipPlayer1);
        shipsPlayer1.add(ThirdShipPlayer1);
        shipsPlayer1.add(FourthShipPlayer1);
        shipsPlayer1.add(FithShipPlayer1);

        Board BoardPlayer2= new Board("Milou");
        List<AbstractShip> shipsPlayer2 = new ArrayList<AbstractShip>();
        Destroyer FirstShipPlayer2 = new Destroyer();
        Submarine SecondShipPlayer2 = new Submarine();
        Submarine ThirdShipPlayer2 = new Submarine();
        Battleship FourthShipPlayer2 = new Battleship();
        Carrier FithShipPlayer2 = new Carrier();
        shipsPlayer2.add(FirstShipPlayer2);
        shipsPlayer2.add(SecondShipPlayer2);
        shipsPlayer2.add(ThirdShipPlayer2);
        shipsPlayer2.add(FourthShipPlayer2);
        shipsPlayer2.add(FithShipPlayer2);


        Player player1 = new Player(BoardPlayer1, BoardPlayer2, shipsPlayer1);
        Player player2 = new Player(BoardPlayer2, BoardPlayer1, shipsPlayer2);

        int[] coord1 = {0,0};
        player1.putShips();
        player2.putShips();
        player1.sendHit(coord1);
        BoardPlayer1.print();
        player1.sendHit(coord1);
        BoardPlayer1.print();


        System.out.println(BoardPlayer2.hasShip(9, 0));
        System.out.println(BoardPlayer2.hasShip(9, 1));



        

    }

}
