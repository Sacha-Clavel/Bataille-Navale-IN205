package app.main.player;

import app.main.ships.*;
import app.main.board.*;

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
            if (hitResult != Hit.MISS && hitResult != Hit.STRIKE){
                countShipDestroyed ++;
            }
            board.print();
            hitResult.print();
            System.out.println(countShipDestroyed+"/"+shipsPlayer.size() + " of ships are destroyed");

            sleep(1000);
        }
    }

}
