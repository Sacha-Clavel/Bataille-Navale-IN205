package app.main.ships;

public class Destroyer extends AbstractShip{

    public Destroyer(Orientations orientation){
        super('D', "Destroyer", 2, orientation);
    }

    public Destroyer(){
        super('D', "Destroyer", 2, Orientations.EAST);
    }
}