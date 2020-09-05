/**
 * Checked
 * have ChangeColor object
 * implements CheckMethods
 * this class check for changing color and check move
 * check for finish game
 */
public class Checked implements CheckMethods {
    public void possibleMove(int btnIndex) {
        //changing color
        CheckMethods.changeColor(-1, 2, -8, 1, btnIndex);
        CheckMethods.changeColor(-1, 2, 0, 2, btnIndex);
        CheckMethods.changeColor(-1, 2, 8, 1, btnIndex);
        //checking move
        CheckMethods.checkMove(-1, 2, -8, 1);
        CheckMethods.checkMove(-1, 2, 0, 2);
        CheckMethods.checkMove(-1, 2, 8, 1);

        int tmp = 0;    //check for pass
        for (int i = 1; i <= 64; i++) {
            if (Main.nuts[i] == "3") {
                tmp++;
            }
        }
        if (tmp == 0) {
            System.out.println("Pass");
            if (Main.player == 1) {
                Main.player = 2;
            } else {
                Main.player = 1;
            }
            //check for finish game
            CheckMethods.checkMove(-1, 2, -8, 1);
            CheckMethods.checkMove(-1, 2, 0, 2);
            CheckMethods.checkMove(-1, 2, 8, 1);
            for (int i = 1; i <= 64; i++) {
                if (Main.nuts[i] == "3") {
                    tmp++;
                }
            }
            if (tmp == 0) {
                int black = 0;
                int white = 0;
                for (int i = 0; i < 65; i++) {
                    if (Main.nuts[i] == "1") {
                        black++;
                    }
                    if (Main.nuts[i] == "2") {
                        white++;
                    }
                }
                //Announcing the winner
                if (black > white) {
                    System.out.println("player 1 won!!!");
                    System.exit(0);
                }
                if (black < white) {
                    System.out.println("player 2 won!!!");
                    System.exit(0);
                }
                if (black == white) {
                    System.out.println("draw!!!");
                    System.exit(0);
                }
            }
        }
    }
}
