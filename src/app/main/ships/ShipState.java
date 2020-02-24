package app.main.ships;

import app.main.annexes.*;

public class ShipState{

    /***************
        Attributs 
    ****************/

    private AbstractShip ship;
    private boolean struck;

    /******************
        Constructeur 
     ******************/

    // public ShipState(){
    //     ship = null;
    //     struck = false;
    //  }

    // public ShipState(AbstractShip ship){
    //     this.ship = ship;
    //     struck = false;
    // }


    /******************
          Méthodes
     ******************/

    //------------- Getters --------------

    public boolean isStruck(){
        return struck;
    }

    public AbstractShip getShip(){
        return ship;
    }


    //------------- Setters --------------

    public void addStrike() throws Exception {
        if (struck){
            throw new Exception("A cell can't be hit more than once");
        }
        struck |= true;
    }


    public void setShip(AbstractShip ship){
        this.ship = ship;
    }

    // ------------- Autres méthodes ----------------

    public String toString(){
        String returnedString = String.valueOf(ship.getLabel());
        if (struck){
            return ColorUtil.colorize(returnedString, "red");
        }
        else {
            return ColorUtil.colorize(returnedString, "green");
        }
    }


    public boolean isSunk(){
        return ship.isSunk();
    }

}