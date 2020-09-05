/**
 * ComputerPlayer class
 * have computer player method to play automatic
 * intelligent play (find nut and then play)
 */

import java.util.Random;

public class ComputerPlayer {
    Random rand = new Random();

    public void play() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (Main.map[x][y] == 2) {              //find computer nut
                    int i = 0;
                    while (i < 100) {          //check for all direction (maybe all direction around nut was not empty)
                        i++;
                        //put rand nut next to computer nut
                        int copyX = x + rand.nextInt(3) - 1;    //put rand nut next to computer nut
                        int copyY = y + rand.nextInt(3) - 1;
                        if (copyX < 0 || copyX > 5 || copyY < 0 || copyY > 5 || Main.map[copyX][copyY] != 0) {
                            continue;
                        } else {
                            Main.map[copyX][copyY] = 2;
                            return;
                        }
                    }
                }
            }
        }
        //if all direction was not empty, put random
        while (true) {
            int copyX = rand.nextInt(6);
            int copyY = rand.nextInt(6);
            if (Main.map[copyX][copyY] == 0) {
                Main.map[copyX][copyY] = 2;
                return;
            }
        }
    }
}
