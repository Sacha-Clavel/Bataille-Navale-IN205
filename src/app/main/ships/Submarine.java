package app.main.ships;

public class Submarine extends AbstractShip{

    public Submarine(Orientations orientation){
        super('S', "Submarine", 3, orientation);
    }

    public Submarine(){
        super('S', "Submarine", 3, Orientations.EAST);
    }
}