package app.main.board;

import app.main.ships.*;
import java.util.List;
import java.util.ArrayList;

public class TestGame {

    private static void sleep(int ms) { 
        try {
        Thread.sleep(ms);
        } catch (InterruptedException e) 
        {
        e.printStackTrace(); }
        }

    public static void main( String[] args ){
        Board board = new Board("testBoard",7);

        List<AbstractShip> shipsPlayer = new ArrayList<AbstractShip>();
        Destroyer FirstShipPlayer = new Destroyer();
        Submarine SecondShipPlayer = new Submarine();
        Submarine ThirdShipPlayer = new Submarine();
        Battleship FourthShipPlayer = new Battleship();
        Carrier FithShipPlayer = new Carrier();
        shipsPlayer.add(FirstShipPlayer);
        shipsPlayer.add(SecondShipPlayer);
        shipsPlayer.add(ThirdShipPlayer);
        shipsPlayer.add(FourthShipPlayer);
        shipsPlayer.add(FithShipPlayer);

        BattleShipsAI ai = new BattleShipsAI(board, board);
        ai.putShips(shipsPlayer);
        int countShipDestroyed =0;
        int[] coords = new int[2];

        while (countShipDestroyed < shipsPlayer.size()){
            Hit hitResult = ai.sendHit(coords);
            hitResult.print();
            board.print();
            sleep(1000);

        }
    }

}
