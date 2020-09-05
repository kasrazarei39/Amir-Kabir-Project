/**
 * <h1>Map class</h1>
 * have printMap method to arrange print cards <br/>
 * have printPlayer method to print other player card and don't show it<br/>
 * have printCurrentPlayer to print cards of player want to play and show cards<br/>
 * have printCenter to print the center card(this card bigger than another card)<br/>
 * have space method to print space for show better map<br/>
 * have printWinner method to print rank and players poiny
 */
public class Map {
    /**
     * @param play     turn player
     * @param card     index of center card
     * @param rotation to print direction of rotation
     */
    public void pritnMap(int play, int card, int rotation) {
        for (int i = 0; i < Main.player.length; i++) {
            //arrange space of player
            if (i == play && i == 2) {
                printCurrentPlayer(80, play);
                printCenter(card);
                System.out.println("\n");
                i++;
            } else if (i == play && i == 0) {
                printCurrentPlayer(60, play);
                i++;
            } else if (i == play && i == 4) {
                printCurrentPlayer(80, play);
                i++;
            } else if (i == play && i == 5) {
                printCurrentPlayer(60, play);
                i++;
            } else if (i == play && i == 1) {
                printCurrentPlayer(0, play);
                i++;
            } else if (i == play && i == 3) {
                printCurrentPlayer(0, play);
                i++;
            }
            if (i == Main.player.length) {
                break;
            }
            //arrange space of player
            if (i == 0 || i == 5) {
                printPlayer(60, i);
            } else if (i == 1 || i == 3) {
                printPlayer(0, i);
            } else if (i == 2 || i == 4) {
                printPlayer(80, i);
            }
            if (i == 2) {
                printCenter(card);
                System.out.println("\n");
            }
        }
        //print direction
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_PURPLE = "\u001B[35m";
        String res = (rotation < 0) ? "<==" : "==>";
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  " + ANSI_PURPLE + "rotation: " + res + ANSI_RESET);
    }

    /**
     * @param space  to print how many space
     * @param player turn player
     */
    static void printPlayer(int space, int player) {
        space(space);
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_RED_BACKGROUND = "\u001B[41m";

        final String ANSI_YELLOW = "\u001B[33m";
        System.out.println(Main.player[player].getName() + ":   ");
        space(space);
        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + "           " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + "         " + ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);

        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " " + ANSI_RED_BACKGROUND + "       " + ANSI_RESET + " " + ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " " + ANSI_RED_BACKGROUND + "  " + ANSI_RESET + ANSI_YELLOW + "UNO" + ANSI_RED_BACKGROUND + "  " + ANSI_RESET + " " + ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " " + ANSI_RED_BACKGROUND + "       " + ANSI_RESET + " " + ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " ");
        }

        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + "         " + ANSI_WHITE_BACKGROUND + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[player].getCards().size(); i++) {
            System.out.print(ANSI_WHITE_BACKGROUND + "           " + ANSI_RESET + " ");
        }
        System.out.println("\n");
    }

    /**
     * @param index to print center card
     *              print colorful card
     */
    static void printCenter(int index) {
        final String ANSI_RESET = "\u001B[0m";
        space(100);
        String[] backgroundColor = new String[]{"", "\u001B[41m", "\u001B[43m", "\u001B[46m", "\u001B[44m", "\u001B[47m"};
        final String ANSI_WHITE = "\u001B[37m";

        if (Main.cards.get(index).getType() == 10) {
            System.out.println(backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + ANSI_WHITE + "ø" + "                      " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + ANSI_RESET + backgroundColor[Main.cards.get(index).getColor()] + "      skip       " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "                      " + ANSI_WHITE + "ø" + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET);
        } else if (Main.cards.get(index).getType() == 11) {
            System.out.println(backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + ANSI_WHITE + "=>" + "                     " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + ANSI_RESET + backgroundColor[Main.cards.get(index).getColor()] + "    reverse      " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "                     " + ANSI_WHITE + "<=" + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET);


        } else if (Main.cards.get(index).getType() == 12) {
            System.out.println(backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + ANSI_WHITE + "+2" + "                     " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + ANSI_RESET + backgroundColor[Main.cards.get(index).getColor()] + "       +2        " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "                     " + ANSI_WHITE + "+2" + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET);


        } else if (Main.cards.get(index).getType() == 13) {
            System.out.println(backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + ANSI_WHITE + "©" + "                      " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + ANSI_RESET + backgroundColor[Main.cards.get(index).getColor()] + "   changeColor   " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "                      " + ANSI_WHITE + "©" + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET);


        } else if (Main.cards.get(index).getType() == 14) {
            System.out.println(backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + ANSI_WHITE + "+4" + "                     " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + ANSI_RESET + backgroundColor[Main.cards.get(index).getColor()] + "       +4        " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "                     " + ANSI_WHITE + "+4" + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET);


        } else {
            System.out.println(backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + ANSI_WHITE + Main.cards.get(index).getType() + "                      " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + ANSI_RESET + backgroundColor[Main.cards.get(index).getColor()] + "        " + Main.cards.get(index).getType() + "        " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + "                 " + ANSI_RESET + "   " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "                      " + ANSI_WHITE + Main.cards.get(index).getType() + backgroundColor[Main.cards.get(index).getColor()] + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t    " + backgroundColor[Main.cards.get(index).getColor()] + "                         " + ANSI_RESET);

        }
    }

    /**
     * @param space to print how many spaces
     * @param play  turn player
     *              print colorful cards
     */
    static void printCurrentPlayer(int space, int play) {
        space(space);
        System.out.println(Main.player[play].getName() + ":   ");
        space(space);
        final String ANSI_RESET = "\u001B[0m";
        String[] backgroundColor = new String[]{"", "\u001B[41m", "\u001B[43m", "\u001B[46m", "\u001B[44m", "\u001B[47m"};


        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + "           " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + "         " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "       " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            if (Main.player[play].getCards().get(i).getType() == 10) {
                System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "  skip " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
            } else if (Main.player[play].getCards().get(i).getType() == 11) {
                System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "reverse" + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
            } else if (Main.player[play].getCards().get(i).getType() == 12) {
                System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "   +2  " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
            } else if (Main.player[play].getCards().get(i).getType() == 13) {
                System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "change " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
            } else if (Main.player[play].getCards().get(i).getType() == 14) {
                System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "  +4   " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
            } else {
                System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "   " + Main.player[play].getCards().get(i).getType() + "   " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
            }
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + "       " + ANSI_RESET + " " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
        }

        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + "         " + backgroundColor[Main.player[play].getCards().get(i).getColor()] + " " + ANSI_RESET + " ");
        }
        System.out.println();
        space(space);
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            System.out.print(backgroundColor[Main.player[play].getCards().get(i).getColor()] + "           " + ANSI_RESET + " ");
        }
        System.out.println("\n\n");
    }

    /**
     * print sorted points
     *
     * @param rating array saved player's point
     */
    public void pritnWinner(int[] rating) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t       " + ANSI_BLUE_BACKGROUND + "                                         " + ANSI_RESET + " \n\t\t\t\t\t\t\t\t\t\t\t\t\t       " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET + " RANK            NAME            POINT " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
        for (int j = 0; j < rating.length; j++) {
            for (int i = 0; i < Main.player.length; i++) {
                if (Main.player[i].getPoint() == rating[j]) {
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t       " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET + "                                       " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t       " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET + "                                       " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t       " + ANSI_BLUE_BACKGROUND + " " + ANSI_RESET + "  " + (j + 1) + ")              " + Main.player[i].getName() + "               " + rating[j] + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t       " + ANSI_BLUE_BACKGROUND + "                                         " + ANSI_RESET);
                    break;
                }
            }
        }
        //print rest player cards
        System.out.println("\n");
        for (int i = 0; i < Main.player.length; i++) {
            if (Main.player[i].getCards().size() == 0) {
                continue;
            }
            printCurrentPlayer(50, i);
        }
    }

    /**
     * @param cnt to now number of space
     */
    static void space(int cnt) {
        for (int i = 0; i < cnt; i++) {
            System.out.print(" ");
        }
    }
}
