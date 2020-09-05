/**
 * Map
 * have printMap method to print map
 */
public class Map {
    public void printMap() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  A   B   C   D   E   F   G   H");
        for (int i = 0; i < 8; i++) {
            //color font
            final String ANSI_RESET = "\u001B[0m";
            final String ANSI_WHITE = "\u001B[37m";
            final String ANSI_RED = "\u001B[31m";

            System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------------------\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t");   //first line
            for (int j = 0; j < 8; j++) {
                if (Main.nuts[i * 8 + (j + 1)] == "1") {
                    System.out.print("| " + "" + "");
                    System.out.print(ANSI_RED + "O" + ANSI_RESET + " ");
                } else if (Main.nuts[i * 8 + (j + 1)] == "2") {
                    System.out.print("| " + "" + "");
                    System.out.print(ANSI_WHITE + "O" + ANSI_RESET + " ");
                } else if (Main.nuts[i * 8 + (j + 1)] == "3") {
                    System.out.print("| " + "-" + " ");

                } else {
                    System.out.print("| " + " " + " ");
                }
                if (j == 7) {
                    System.out.print("|" + " " + (i + 1));
                }
            }
        }
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------------------");   //last line
    }
}
