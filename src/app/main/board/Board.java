package app.main.board;

public class Board{

    private String Name;
    private char[][] Map;
    private boolean[][] Strikes;


    public Board(String Name, int sizeMap){
        this.Name = Name;
        Map = new char[sizeMap][sizeMap];
        Strikes = new boolean[sizeMap][sizeMap];
        for (int i=0; i<sizeMap; i++){
            for (int j=0; j<sizeMap; j++){
                Map[i][j] = '~';
                Strikes[i][j] = false;
            }
        }
    }

    public Board(String Name ){
        this.Name = Name;
        Map = new char[10][10];
        Strikes = new boolean[10][10];
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                Map[i][j] = '~';
                Strikes[i][j] = false;
            }
        }
    }

    public void print(){

        String delimiter = "  |  ";

        System.out.print("Ships ");
        for (int k=0; k<(2*Map.length-1 + 2); k++ ){
            System.out.print("-");
        }
        System.out.print(" Strikes ");
        for (int k=0; k<(2*Map.length-1 -2); k++ ){
            System.out.print("-");
        }
        System.out.print("\n");

        char letter = 65;
        System.out.print("|   ");
        for (int j=0; j<Map.length; j++){ 
            System.out.print( " "+letter);
            letter += 1;
        }

        System.out.print(delimiter);
        System.out.print("  ");
        letter = 65;
        for (int j=0; j<Strikes.length; j++){ 
            System.out.print( " "+letter);
            letter += 1;
        }
        System.out.print(" |\n");


        for (int i=0; i<Map.length; i++){
            System.out.print("| ");
            System.out.print(i);
            if (Integer.toString(i).length()==1){
                System.out.print(" ");
            }

            for (int j=0; j<Map.length; j++){
                System.out.print(" "+Map[i][j]);
            }
            System.out.print(delimiter);

            System.out.print(i);
            if (Integer.toString(i).length()==1){
                System.out.print(" ");
            }
            for (int j=0; j<Strikes.length; j++){
                if(Strikes[i][j])
                    System.out.print(" "+"X");
                else   
                    System.out.print(" "+"~");
                
            }

            System.out.print(" |\n");
        }
        for (int j=0; j<2*2*Map.length-1 + 9 + delimiter.length(); j++ )
            System.out.print("-");

        System.out.print("\n");
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setMapIJ(int i, int j, char val){
        Map[i][j] = val;
    }

    public void setStrikesIJ(int i, int j, boolean val){
        Strikes[i][j] = val;
    }

    public String getName(){
        return Name;
    }

    public char getMapIJ(int i, int j){
        return Map[i][j];
    }

    public boolean getStrikesIJ(int i, int j){
        return Strikes[i][j];
    }

}