package app.main.board;

public class TestBoard {


public static void main( String[] args )
{
    
    Board firstBoard = new Board("aBoard",15);
    firstBoard.print();

    Board secondBoard = new Board("anotherBoard");
    secondBoard.print();

    System.out.println(firstBoard.getName());
    
    firstBoard.setMapIJ(3,5,'O');
    firstBoard.setMapIJ(3,6,'O');
    firstBoard.setMapIJ(3,7,'O');


    firstBoard.setMapIJ(2,10,'O');
    firstBoard.setMapIJ(3,10,'O');
    firstBoard.setMapIJ(4,10,'O');
    firstBoard.setMapIJ(5,10,'O');

    firstBoard.print();





    
}

}
