package app.main.board;

import app.main.ships.*;


public class TestBoard {


    public static void main( String[] args ){
    
        Board FirstBoard = new Board("aBoard",15);

        FirstBoard . setHit(true, 10, 1);
        FirstBoard . setHit(true, 10, 2);
        FirstBoard . setHit(false, 10, 3);
        FirstBoard . setHit(true, 10, 4);




        Battleship FirstShip = new Battleship(Orientations.NORTH);
        Carrier SecondShip = new Carrier();
        Submarine thirdShip = new Submarine(Orientations.SOUTH);

        try {
            FirstBoard.putShip(FirstShip, 4, 7);
        } catch(Exception e){
            System.out.println(e);
        }

        FirstBoard.print();


        try {
            FirstBoard.putShip(SecondShip, 10, 7);
        } catch(Exception e){
            System.out.println(e);
        }

        FirstBoard.print();



        try {
            FirstBoard.putShip(thirdShip, 10, 3); 
        } catch(Exception e){
            System.out.println(e);
        }

        try {
            FirstBoard.putShip(thirdShip, 9, 8); // Exception is raised (Overlapsing)
        } catch(Exception e){
            System.out.println(e);
        }


        try {
            FirstBoard.putShip(thirdShip, 13, 1); // Exception is raised (Out of the map)
        } catch(Exception e){
            System.out.println(e);
        }

        FirstBoard.print();

        System.out.println("The cell (10,J) has a ship ? : " + FirstBoard.hasShip(10, 9));
        System.out.println("The cell (11,J) has a ship ? : " + FirstBoard.hasShip(11, 9));


    }

}
