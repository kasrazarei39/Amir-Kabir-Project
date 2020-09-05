/**
 * ArrangeMap class
 * have printMap method to print map with for square
 * have rotation method to rotate square
 */

public class ArrangeMap {

    /**
     * colorful print
     * all nuts save in static maps
     */
    public void printMap() {
        //define color codes
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_CYAN = "\u001B[36m";
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t    0       1       2               3       4       5");
        for (int row = 0; row < 6; row++) {
            System.out.println("");
            if (row == 3) {
                System.out.println(ANSI_CYAN + "\t\t\t\t\t\t\t\t\t\t\t\t\tø-------ø-------ø-------ø       ø-------ø-------ø-------ø\n");
            }
            System.out.println(ANSI_CYAN + "\t\t\t\t\t\t\t\t\t\t\t\t\tø-------ø-------ø-------ø       ø-------ø-------ø-------ø");
            System.out.print(ANSI_CYAN + "\t\t\t\t\t\t\t\t\t\t\t\t\t|       |       |       |       |       |       |       |       \n\t\t\t\t\t\t\t\t\t\t\t\t\t");
            for (int column = 0; column < 6; column++) {
                if (Main.map[column][row] == 1) {
                    if (column == 3) {
                        System.out.print(ANSI_CYAN + "|       |   ");
                        System.out.print(ANSI_RED + "O   ");
                    } else {
                        System.out.print(ANSI_CYAN + "|   ");
                        System.out.print(ANSI_RED + "O   ");
                    }
                } else if (Main.map[column][row] == 2) {
                    if (column == 3) {
                        System.out.print(ANSI_CYAN + "|       |   ");
                        System.out.print(ANSI_WHITE + "O   ");
                    } else {
                        System.out.print(ANSI_CYAN + "|   ");
                        System.out.print(ANSI_WHITE + "O   ");
                    }
                } else {
                    if (column == 3) {
                        System.out.print(ANSI_CYAN + "|       |       ");
                    } else {
                        System.out.print(ANSI_CYAN + "|       ");
                    }
                }
                if (column == 5) {
                    System.out.print(ANSI_CYAN + "|  " + ANSI_RESET + row);
                }
            }
            System.out.println();
            System.out.print(ANSI_CYAN + "\t\t\t\t\t\t\t\t\t\t\t\t\t|       |       |       |       |       |       |       |       ");
        }
        System.out.println(ANSI_CYAN + "\n\t\t\t\t\t\t\t\t\t\t\t\t\tø-------ø-------ø-------ø       ø-------ø-------ø-------ø" + ANSI_RESET);
    }

    /**
     * @param place      to find which square move
     * @param typeRotate to rotate round clock or counter clockwise
     *                   use temp variable to find square
     */
    public void rotation(int place, int typeRotate) {
        int N = 3;
        int tmpX = 0;
        int tmpY = 0;
        switch (place) {
            case 1:
                tmpX = 0;
                tmpY = 0;
                break;
            case 2:
                tmpX = 3;
                tmpY = 0;
                break;
            case 3:
                tmpX = 0;
                tmpY = 3;
                break;
            case 4:
                tmpX = 3;
                tmpY = 3;
                break;
        }
        switch (typeRotate) {
            case 1:
                for (int x = 0; x < N; x++) {
                    for (int y = x; y < N - x - 1; y++) {
                        // store current cell in temp variable
                        int temp = Main.map[x + tmpX][y + tmpY];
                        // move values from bottom to left
                        Main.map[x + tmpX][y + tmpY] = Main.map[y + tmpX][N - 1 - x + tmpY];
                        // move values from right to bottom
                        Main.map[y + tmpX][N - 1 - x + tmpY] = Main.map[N - 1 - x + tmpX][N - 1 - y + tmpY];
                        // move values from top to right
                        Main.map[N - 1 - x + tmpX][N - 1 - y + tmpY] = Main.map[N - 1 - y + tmpX][x + tmpY];
                        // assign temp to top
                        Main.map[N - 1 - y + tmpX][x + tmpY] = temp;
                    }
                }
                break;
            case 2:
                for (int x = 0; x < N; x++) {
                    for (int y = x; y < N - x - 1; y++) {
                        // store current cell in temp variable
                        int temp = Main.map[x + tmpX][y + tmpY];
                        // move values from top to left
                        Main.map[x + tmpX][y + tmpY] = Main.map[N - 1 - y + tmpX][x + tmpY];
                        // move values from right to top
                        Main.map[N - 1 - y + tmpX][x + tmpY] = Main.map[N - 1 - x + tmpX][N - 1 - y + tmpY];
                        // move values from bottom to right
                        Main.map[N - 1 - x + tmpX][N - 1 - y + tmpY] = Main.map[y + tmpX][N - 1 - x + tmpY];
                        // assign temp to top
                        Main.map[y + tmpX][N - 1 - x + tmpY] = temp;
                    }
                }
        }
    }
}
