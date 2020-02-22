package app.main.ships;

public class Battleship extends AbstractShip{

    public Battleship(Orientations orientation){
        super('B', "Battleship", 4, orientation);
    }

    public Battleship(){
        super('B', "Battleship", 4, Orientations.EAST);
    }
}