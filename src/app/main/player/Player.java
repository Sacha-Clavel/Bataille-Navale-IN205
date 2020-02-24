package app.main.player;

import app.main.ships.*;
import app.main.board.*;

import java.io.Serializable;
import java.util.List;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;
        board.print();

        do {

            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getType(), s.getSize());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            
            Orientations orientationShip;
            switch (res.orientation){
                case "n":
                    orientationShip = Orientations.NORTH;
                    break;
                case "w":
                    orientationShip = Orientations.WEST;
                    break;
                case "s":
                    orientationShip = Orientations.SOUTH;
                    break;
                case "e":
                    orientationShip = Orientations.EAST;
                    break;
                default :
                    orientationShip = Orientations.EAST;
                    break;
            }

            s.setOrientation(orientationShip);

            try{
                board.putShip(s, res.y+1, res.x); //"+1" car ma convention est de faire commencer les indices à 0. 
                ships[i] = s;
                ++i;
                board.print();


            } catch(Exception e){
                System.out.println(e);
            }

            done = i == 5;

        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        //boolean done=false;
        //Hit hit = null;
        //do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            Hit resultOfHit = opponentBoard.sendHit(hitInput.y+1, hitInput.x);
            switch (resultOfHit){
                case MISS :
                    board.setHit(false, hitInput.y+1, hitInput.x); //"+1" car ma convention est de faire commencer les indices à 0. 
                    break;

                default :
                    board.setHit(true, hitInput.y+1, hitInput.x); //"+1" car ma convention est de faire commencer les indices à 0. 
                    break;
            }
            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
            coords = new int[2];
            coords[0] = hitInput.y;
            coords[1] = hitInput.x;
        //} while (!done);

        return resultOfHit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
