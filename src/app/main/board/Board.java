package app.main.board;

import app.main.ships.*;

public class Board implements IBoard{

    /***************
        Attributs  
    ****************/
    private String name;
    private char[][] map;
    private boolean[][] strikes;


    /*******************
        Constructeurs  
    ********************/

    public Board(String name, int sizeMap){
        this.name = name;
        map = new char[sizeMap][sizeMap];
        strikes = new boolean[sizeMap][sizeMap];
        for (int i=0; i<sizeMap; i++){
            for (int j=0; j<sizeMap; j++){
                map[i][j] = '~';
                strikes[i][j] = false;
            }
        }
    }



    public Board(String name ){
        this.name = name;
        map = new char[10][10];
        strikes = new boolean[10][10];
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                map[i][j] = '~';
                strikes[i][j] = false;
            }
        }
    }

    /***************
        Méthodes  
    ****************/

    // ----------- Affichage de la carte ----------------
    public void print(){

        String delimiter = "  |  ";


        System.out.print("\n\n><><><><><><>< Board : " + name + " ");
        for (int k=0; k<map.length*2; k++){
            System.out.print("><");
        }
        System.out.print("\n\n");

        System.out.print("Ships ");
        for (int k=0; k<(2*map.length); k++ ){
            System.out.print("-");
        }
        System.out.print("  Strikes ");
        for (int k=0; k<(2*map.length-4); k++ ){
            System.out.print("-");
        }
        System.out.print("\n");

        char letter = 65;
        System.out.print("|   ");
        for (int j=0; j<map.length; j++){ 
            System.out.print( " "+letter);
            letter += 1;
        }

        System.out.print(delimiter);
        System.out.print("  ");
        letter = 65;
        for (int j=0; j<strikes.length; j++){ 
            System.out.print( " "+letter);
            letter += 1;
        }
        System.out.print(" |\n");


        for (int i=0; i<map.length; i++){
            System.out.print("| ");
            System.out.print(i);
            if (Integer.toString(i).length()==1){
                System.out.print(" ");
            }

            for (int j=0; j<map.length; j++){
                System.out.print(" "+map[i][j]);
            }
            System.out.print(delimiter);

            System.out.print(i);
            if (Integer.toString(i).length()==1){
                System.out.print(" ");
            }
            for (int j=0; j<strikes.length; j++){
                if(strikes[i][j])
                    System.out.print(" "+"X");
                else   
                    System.out.print(" "+"~");
                
            }

            System.out.print(" |\n");
        }
        System.out.print(" ");
        for (int j=0; j<2*2*map.length-1 + 7 + delimiter.length(); j++ )
            System.out.print("-");

        System.out.print("\n");
    }



    // ----------- Setters ----------------

    public void setName(String name){
        this.name = name;
    }



    public void setMapIJ(int i, int j, char val){
        map[i][j] = val;
    }



    public void setStrikesIJ(int i, int j, boolean val){
        strikes[i][j] = val;
    }


    // ----------- Getters ----------------

    public String getName(){
        return name;
    }



    public char getMapIJ(int i, int j){
        return map[i][j];
    }



    public boolean getStrikesIJ(int i, int j){
        return strikes[i][j];
    }



    public int getSize(){
        return map.length;
    }

    // ----------- Ajout des navires et des frappes ----------------
    
    public void putShip(AbstractShip ship, int y, int x) throws Exception {

        int jx;
        int iy;

        switch(ship.getOrientation()){
            case NORTH :
                if (y - ship.getSize() < -1){
                    throw new Exception("The ship goes out of the map");
                }
                
                jx = x;
                for (iy = y; iy > y - ship.getSize(); iy--){
                    if (map[iy][jx] != '~'){
                        throw new Exception("The ship overlaps another ship");
                    }
                }
                for (iy = y; iy > y - ship.getSize(); iy--){
                    map[iy][jx] = '#';
                }
                break;

            case WEST :
                if (x - ship.getSize() < -1){
                    throw new Exception("The ship goes out of the map");
                }
                iy = y;
                for (jx = x; jx > x - ship.getSize(); jx--){
                    if (map[iy][jx] != '~'){
                        throw new Exception("The ship overlaps another ship");
                    }
                }
                for (jx = x; jx > x - ship.getSize(); jx--){
                    map[iy][jx] = '#';
                }
                break;

            case SOUTH :
                if (y + ship.getSize() > this.getSize()){
                    throw new Exception("The ship goes out of the map");
                }
                jx = x;
                for (iy = y; iy < y + ship.getSize(); iy++){
                    if (map[iy][jx] != '~'){
                        throw new Exception("The ship overlaps another ship");
                    }
                }
                for (iy = y; iy < y + ship.getSize(); iy++){
                    map[iy][jx] = '#';
                }
                break;

            case EAST :
                if (x + ship.getSize() > this.getSize()){
                    throw new Exception("The ship goes out of the map");
                }

                iy = y;
                for (jx = x; jx < x + ship.getSize(); jx++){
                    if (map[iy][jx] != '~'){
                        throw new Exception("The ship overlaps another ship");
                    }
                }
                for (jx = x; jx < x + ship.getSize(); jx++){
                    map[iy][jx] = '#';
                }
                break;
        }
    }



    public boolean hasShip(int y, int x){
        int iy = y;
        int jx = x; 
        if (map[iy][jx] == '#'){
            return true;
        }
        else {
            return false;
        }
    }



    public void setHit(boolean hit, int y, int x){
        int iy = y;
        int jx = x; 
        strikes[iy][jx] = hit;
    }


    
    public Boolean getHit(int y, int x){
        int iy = y;
        int jx = x; 
        return strikes[iy][jx];
    }





}