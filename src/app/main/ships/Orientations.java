package app.main.ships;

public enum Orientations {
    NORTH(0), WEST(1), SOUTH(2), EAST(3);
    public int val;
    private Orientations(int val){
    this.val = val;
    }
   }