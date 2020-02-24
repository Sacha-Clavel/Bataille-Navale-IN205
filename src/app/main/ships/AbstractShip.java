package app.main.ships;


public abstract class AbstractShip{

    /***************
        Attributs
     ***************/
    
    protected char label;
    protected String type;
    protected int size;
    protected Orientations orientation;
    protected int strikeCount;


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



    public void setLabel(char label){
        this.label = label;
    }


    // -------------- Autres méthodes ---------------

    public void addStrike(){
        strikeCount ++;
    }


    public boolean isSunk(){
        return size == strikeCount;
    } 


}