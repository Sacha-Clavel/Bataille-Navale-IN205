package app.main.player;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import app.main.ships.*;
import app.main.board.*;

public class AIPlayer extends Player {
    /*
     * ** Attribut
     */
    private BattleShipsAI ai;

    /*
     * ** Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    public void putShips() {
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        for(int i=0; i<this.ships.length; i++){
            ships.add(this.ships[i]);
        }
        ai.putShips(ships);
    }

    public Hit sendHit(int[] coords) {
        return ai.sendHit(coords);
    }


}
