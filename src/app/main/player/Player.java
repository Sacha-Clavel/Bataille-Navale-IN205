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
        boolean placementIsSuccessful = false;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getType(), s.getSize());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            
            Orientations orientation;
            if (res.orientation == "n"){
                orientation = Orientations.NORTH;
            }
            else if (res.orientation == "w"){
                orientation = Orientations.WEST;

            }
            else if (res.orientation == "s"){
                orientation = Orientations.SOUTH;

            }
            else {
                orientation = Orientations.EAST;
            }

            s.setOrientation(orientation);

            try{
                board.putShip(s, res.y, res.x);
                ships[i] = s;
                ++i;

            } catch(Exception e){
                System.out.println(e);
            }

            done = i == 5;

            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done=false;
        Hit hit = null;
        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
