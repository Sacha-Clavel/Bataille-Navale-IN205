package app.main.ships;

public enum Orientations {
    NORTH(0), WEST(1), SOUTH(2), EAST(3);
    public int val;
    private Orientations(int val){
    this.val = val;
    }

    public static Orientations fromInt(int val) throws Exception{
        for (Orientations orientation : Orientations.values()) {
            if (orientation.val == val) {
                return orientation;
            }
        }
        throw new Exception("no enum Orientations for value " + val);
    }
   }