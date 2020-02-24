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




        FirstBoard.sendHit(10,7);
        FirstBoard.sendHit(10,9);
        FirstBoard.sendHit(10,3);
        FirstBoard.sendHit(11,3);
        Hit test = FirstBoard.sendHit(12,3);

        FirstBoard.print();

        System.out.println("The Submarine is sunk : " + thirdShip.isSunk());
        System.out.println("The last call to sendHit returned : " + test);







    }

}
