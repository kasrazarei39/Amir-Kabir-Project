import java.util.Scanner;

/**
 * @author kasra
 * @version 1.0
 * @since 2020-3-30
 * Main class
 * have main method to run program
 * have static String to save nuts
 */
public class Main {
    public static String[] nuts = new String[65];    //save all nuts
    public static int player = 1;                   //turn play

    public static void main(String[] args) {
        Checked check = new Checked();
        Map map = new Map();
        Scanner scanner = new Scanner(System.in);
        String[] Xhomes = {"A", "B", "C", "D", "E", "F", "G", "H"};      //axis X
        int btnIndex = 0;
        int x = 0;
        int y = 1;
        //initialize center nuts
        nuts[28] = "2";
        nuts[37] = "2";
        nuts[29] = "1";
        nuts[36] = "1";

        while (true) {
            delete();
            check.possibleMove((y - 1) * 8 + x + 1);
            map.printMap();
            System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tX: ");
            String XInput = scanner.nextLine();
            for (x = 0; x < Xhomes.length; x++) {
                if (Xhomes[x].endsWith(XInput)) {
                    break;
                }
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\tY: ");
            y = scanner.nextInt();
            scanner.nextLine();
            if (nuts[(y - 1) * 8 + x + 1] != "3") {
                continue;
            }
            if (player == 1) {
                nuts[(y - 1) * 8 + x + 1] = "1";
                player = 2;
            } else {
                nuts[(y - 1) * 8 + x + 1] = "2";
                player = 1;
            }
            for (int j = 0; j < 65; j++) {
                if (nuts[j] == "3") {
                    nuts[j] = null;
                }
            }
        }
    }

    //this method clear Terminal
    public static void delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
