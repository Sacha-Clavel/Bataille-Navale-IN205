package app.main.ships;

public class Carrier extends AbstractShip{

    public Carrier(Orientations orientation){
        super('C', "Carrier", 5, orientation);
    }

    public Carrier(){
        super('C', "Carrier", 5, Orientations.EAST);
    }
}