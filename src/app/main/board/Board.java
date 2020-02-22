package app.main.board;

public class Board{

    private String name;
    private char[][] map;
    private boolean[][] strikes;


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

    public void print(){

        String delimiter = "  |  ";

        System.out.print("Ships ");
        for (int k=0; k<(2*map.length-1 + 2); k++ ){
            System.out.print("-");
        }
        System.out.print(" Strikes ");
        for (int k=0; k<(2*map.length-1 -2); k++ ){
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
        for (int j=0; j<2*2*map.length-1 + 9 + delimiter.length(); j++ )
            System.out.print("-");

        System.out.print("\n");
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMapIJ(int i, int j, char val){
        map[i][j] = val;
    }

    public void setStrikesIJ(int i, int j, boolean val){
        strikes[i][j] = val;
    }

    public String getName(){
        return name;
    }

    public char getMapIJ(int i, int j){
        return map[i][j];
    }

    public boolean getStrikesIJ(int i, int j){
        return strikes[i][j];
    }

}