/**
 * Main class
 * have main method to run program
 * have delete method to clear terminal
 *
 * @param map static and save nuts in map
 * have multiplayer and single player
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int[][] map = new int[6][6];

    /**
     * This is the main method
     *
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        //create objects
        Scanner scanner = new Scanner(System.in);
        ArrangeMap arrangemap = new ArrangeMap();
        Check check = new Check();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        Random rand = new Random();

        delete();      //to clear Terminal

        boolean computer = false;     //for single player
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t--------------------\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\t\t   |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|  1) Multiplayer  |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\t\t   |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t++++++++++++++++++++\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\t\t   |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|  2)Singleplayer  |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\t\t   |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t--------------------\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (scanner.nextInt() == 2) {
            computer = true;
            computerPlayer = new ComputerPlayer();
            map[rand.nextInt(6)][rand.nextInt(6)] = 2;      //random place for start computer game
        }
        scanner.nextLine();
        int player = 1;
        while (true) {
            delete();
            arrangemap.printMap();
            if (player == 2 && computer) {        //if multiplayer selected
                computerPlayer.play();
            } else {
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\tX:");
                int x = scanner.nextInt();
                scanner.nextLine();
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\tY:");
                int y = scanner.nextInt();
                scanner.nextLine();
                if (x < 0 || x > 5 || y < 0 || y > 5 || map[x][y] != 0) {           //check for invalid input
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\tWrong input");
                    continue;
                }
                map[x][y] = player;
            }
            check.checkEndGame();           //check finish game before rotate
            //rotation
            if (player == 2 && computer) {
                arrangemap.rotation(rand.nextInt(4) + 1, rand.nextInt(2) + 1);
            } else {
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\tselect place:  1)top,left  2)top,right  3)bottom,left  4)bottom,left\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
                int place = scanner.nextInt();
                scanner.nextLine();
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t1)round clock   2)counter clockwise\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
                int typeRotate = scanner.nextInt();
                scanner.nextLine();
                arrangemap.rotation(place, typeRotate);
            }
            check.checkEndGame();    //check finish game after rotate
            if (player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
    }

    //clear Terminal
    public static void delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
