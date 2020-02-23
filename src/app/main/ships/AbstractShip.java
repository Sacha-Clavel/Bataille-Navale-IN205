package app.main.ships;


public abstract class AbstractShip{

    /***************
        Attributs
     ***************/
    
    protected char label;
    protected String type;
    protected int size;
    protected Orientations orientation;


    /******************
        Constructeur
     ******************/

    public AbstractShip(char label, String type, int size, Orientations orientation){
        this.label = label;
        this.type = type;
        this.size = size;
        this.orientation = orientation;
    }


    /***************
        Méthodes
     ***************/


    // -------------- Getters -----------------

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


    // -------------- Setter -----------------

    public void setOrientation(Orientations orientation){
        this.orientation = orientation;
    }



}