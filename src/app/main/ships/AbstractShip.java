package app.main.ships;


public abstract class AbstractShip{
    
    protected char label;
    protected String type;
    protected int size;
    protected Orientations orientation;

    public AbstractShip(char label, String type, int size, Orientations orientation){
        this.label = label;
        this.type = type;
        this.size = size;
        this.orientation = orientation;
    }

    public char getLabel(){
        return label;
    }

    public String getType(){
        return type;
    }

    public int getSize(){
        return size;
    }

    public Orientations getOrientation(){
        return orientation;
    }

    void setOrientation(Orientations orientation){
        this.orientation = orientation;
    }



}