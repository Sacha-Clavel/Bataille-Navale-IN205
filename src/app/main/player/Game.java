package app.main.player;

import java.io.*;
import java.util.Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import app.main.ships.*;
import app.main.board.*;
import app.main.annexes.ColorUtil;

public class Game {

    /*
     * *** Constante
     */
    public static final File SAVE_FILE = new File("savegame.dat");

    /*
     * *** Attributs
     */
    private Player player1;
    private Player player2;
    private Scanner sin;

    /*
     * *** Constructeurs
     */
    public Game() {
    }

    public Game init() {
        if (!loadSave()) {
            // init attributes

            @SuppressWarnings("resource")
            Scanner sin = new Scanner(System.in);

            System.out.println("entre ton nom:");// TODO use a scanner to read player name
            String name = sin.nextLine();


            // TODO init boards
            int sizeMap = 7;
            Board b1, b2;
            b1 = new Board(name,sizeMap);
            b2 = new Board("AI",sizeMap);

            List<AbstractShip> shipsPlayer1 = createDefaultShips();

            List<AbstractShip> shipsPlayer2 = createDefaultShips();

            // TODO init this.player1 & this.player2
            player1 = new Player(b1, b2, shipsPlayer1);
            player2 = new AIPlayer(b2,b1, shipsPlayer2);

            // place player ships
            player1.putShips();
            player2.putShips();
        }
        return this;
    }

    /*
     * *** Méthodes
     */

    private static void sleep(int ms) { 
        try {
        Thread.sleep(ms);
        } catch (InterruptedException e) 
        {
        e.printStackTrace(); }
        }


    public void run() {
        Board b1 = player1.board;
        Hit hit;

        // main loop
        int[] coordsHitPlayer1 = new int[2];
        int[] coordsHitPlayer2 = new int[2];

        boolean done;
        do {
            hit = Hit.MISS; // TODO player1 send a hit
            boolean strike = hit != Hit.MISS; // TODO set this hit on his board (b1)
            b1.print();
            hit = player1.sendHit(coordsHitPlayer1);
            b1.print();
            System.out.print("Hit on [x,y] = ["+(char)(65+coordsHitPlayer2[1])+","+coordsHitPlayer1[0]+"] ---> ");
            hit.print();
            sleep(400);


            done = updateScore();

            save();

            if (!done && !strike) {
                do {
                    hit = Hit.MISS; // TODO player2 send a hit.

                    hit = player2.sendHit(coordsHitPlayer2);
                    b1.print();
                    System.out.print("Opponent hit on [x,y] = ["+(char)(65+coordsHitPlayer2[1])+","+coordsHitPlayer2[0]+"] ---> ");
                    hit.print();
                    sleep(400);

                    // strike = hit != Hit.MISS;
                    // if (strike) {
                    //     b1.print();
                    // }
                    // System.out.println(makeHitMessage(true /* incoming hit */, coordsHitPlayer2, hit));
                    done = updateScore();

                    if (!done) {
                        save();
                    }
                } while (strike && !done);
            }

        } while (!done);

        SAVE_FILE.delete();
        System.out.println(String.format("joueur %d gagne", player1.lose ? 2 : 1));
        sin.close();
    }

     private void save() {
    //     try {
    //         // TODO bonus 2 : uncomment
    //         // if (!SAVE_FILE.exists()) {
    //         // SAVE_FILE.getAbsoluteFile().getParentFile().mkdirs();
    //         // }

    //         // TODO bonus 2 : serialize players

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
     }

     private boolean loadSave() {
    //     if (SAVE_FILE.exists()) {
    //         try {
    //             // TODO bonus 2 : deserialize players

    //             return true;
    //         } catch (IOException | ClassNotFoundException e) {
    //             e.printStackTrace();
    //         }
    //     }
         return false;
     }

    private boolean updateScore() {
        for (Player player : new Player[] { player1, player2 }) {
            int destroyed = 0;
            for (AbstractShip ship : player.getShips()) {
                if (ship.isSunk()) {
                    destroyed++;
                }
            }

            player.destroyedCount = destroyed;
            player.lose = destroyed == player.getShips().length;
            if (player.lose) {
                return true;
            }
        }
        return false;
    }

    private String makeHitMessage(boolean incoming, int[] coords, Hit hit) {
        String msg;
        String color = "reset";
        switch (hit) {
        case MISS:
            msg = hit.toString();
            break;
        case STRIKE:
            msg = hit.toString();
            color = "red";
            break;
        default:
            msg = hit.toString() + " coulé";
            color = "red";
        }
        msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords[0])),
                (coords[1] + 1), msg);
        return ColorUtil.colorize(msg, color);
    }

    private static List<AbstractShip> createDefaultShips() {
        return Arrays.asList(new AbstractShip[] { new Destroyer(), new Submarine(), new Submarine(), new Battleship(),
                new Carrier() });
    }

    public static void main( String[] args ){
        Game theGame = new Game();
        theGame.init();
        theGame.run();
    }
}
