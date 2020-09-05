/**
 * Check class
 * have checkEndGame method to check when game is finish
 * when put nuts check to finish game
 * when rotate check to finish game
 * maybe after rotate 2 player win; this class checked it and say draw
 */

public class Check {
    ArrangeMap map = new ArrangeMap();

    public void checkEndGame() {
        boolean won1 = false;
        boolean won2 = false;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (Main.map[x][y] == 1) {
                    int cnt = 1;
                    boolean flag = false;          //for check win player
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            if ((x - i >= 6) || (x + i >= 6) || (x + i < 0) || (x - i < 0) ||       //check for out of maps
                                    (y - j >= 6) || (y + j >= 6) || (y + j < 0) || (y - j < 0)) {
                                continue;
                            }
                            cnt = 1;
                            int copyX = x;       //for move next to nuts to find another nuts
                            int copyY = y;
                            while (Main.map[copyX - (i)][copyY - (j)] == 1) {
                                copyX = copyX - i;
                                copyY = copyY - j;
                                cnt++;
                                if (cnt == 5) {
                                    won1 = true;
                                }
                                if ((copyX - (i) >= 6) || (copyX + (i) >= 6) || (copyX + (i) < 0) || (copyX - (i) < 0) ||       //check for out of maps
                                        (copyY - (j) >= 6) || (copyY + (j) >= 6) || (copyY + (j) < 0) || (copyY - (j) < 0)) {
                                    break;
                                }
                            }
                        }
                    }
                }
                if (Main.map[x][y] == 2) {
                    int cnt = 1;
                    boolean flag = false;         //for check win player
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            if ((x - i >= 6) || (x + i >= 6) || (x + i < 0) || (x - i < 0) ||         //check for out of maps
                                    (y - j >= 6) || (y + j >= 6) || (y + j < 0) || (y - j < 0)) {
                                continue;
                            }
                            cnt = 1;
                            int copyX = x;     //for move next to nuts to find another nuts
                            int copyY = y;
                            while (Main.map[copyX - (i)][copyY - (j)] == 2) {
                                copyX = copyX - i;
                                copyY = copyY - j;
                                cnt++;
                                if (cnt == 5) {
                                    won2 = true;
                                }
                                if ((copyX - (i) >= 6) || (copyX + (i) >= 6) || (copyX + (i) < 0) || (copyX - (i) < 0) ||       //check for out of maps
                                        (copyY - (j) >= 6) || (copyY + (j) >= 6) || (copyY + (j) < 0) || (copyY - (j) < 0)) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        int draw = 0;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (Main.map[x][y] == 0){
                    draw++;
                }
            }
        }
        if (draw == 0){
            won1 = true;
            won2 = true;
        }
        if (won1 && won2) {
            map.printMap();
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdraw!!!");
            System.exit(0);
        } else if (won1) {
            map.printMap();
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tplayer 1 won!!!");
            System.exit(0);
        } else if (won2) {
            map.printMap();
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tplayer 2 won!!!");
            map.printMap();
            System.exit(0);
        }
    }
}

