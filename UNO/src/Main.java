/**
 * @author kasra
 * @version 1.0
 * @param cards static variable save all cards in ArrayList
 * @param player static variable save all player in ArrayList
 * @since 2020-4-8
 * <h1>Main class</h1>
 * have main method to run program <br/>
 * have delete method to clear Terminal <br/>
 * this project play UNO <br/>
 */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static ArrayList<Card> cards = new ArrayList<>();
    public static Player[] player = new Player[4];

    public static void main(String[] args) throws InterruptedException {
        //create all cards and save to ArrayList
        for (int i = 0; i <= 108; i++) {
            cards.add(new Card(i));
        }
        cards.remove(0);   //repetition card
        //create objects
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Map map = new Map();
        Check check = new Check();
        //print colors
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED_BACKGROUND = "\u001B[41m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

        delete();       //clear Terminal
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t  enter number of human players (3 to 6): ");
        int numHumanPlayers = scanner.nextInt();
        scanner.nextLine();
        int numComputerHuman = 0;
        //create computer player
        delete();
        if (numHumanPlayers != 6) {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t  enter number of computer players (" + Math.max(0, 3 - numHumanPlayers) + " to " + (6 - numHumanPlayers) + "):");
            numComputerHuman = scanner.nextInt();
            scanner.nextLine();
        }
        player = new Player[numHumanPlayers + numComputerHuman];
        //create players
        for (int i = 0; i < player.length; i++) {
            delete();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + (i + 1) + ")player name: ");
            String name = scanner.nextLine();
            player[i] = new Player(name);
        }

        int play = 0;
        int indexCenter = rand.nextInt(100);       //index of center card to play
        cards.get(indexCenter).setExist(false);           //remove center card from list

        int penalty = 0;      //when player can't play must give penalty; this variable save how many penalty to pay a fine
        int rotation = 1;     //direction move
        //when first card type = 11
        if (cards.get(indexCenter).getType() == 11) {
            rotation = -1;
            play = player.length - 1;
        }
        //when first card type = 12
        if (cards.get(indexCenter).getType() == 12) {
            for (int i = 0; i < 2; i++) {
                while (true) {
                    int rnd = rand.nextInt(108);
                    if (cards.get(rnd).getExist()) {        //if cars exit can give to player
                        player[play].setAddCards(player[play].getCards(), cards.get(rnd));
                        cards.get(rnd).setExist(false);
                        break;
                    }
                }
            }
            play++;
        }
        //when first card type = 14
        if (cards.get(indexCenter).getType() == 14) {
            for (int i = 0; i < 4; i++) {
                while (true) {
                    int rnd = rand.nextInt(108);
                    if (cards.get(rnd).getExist() && rnd != indexCenter) {
                        player[play].setAddCards(player[play].getCards(), cards.get(rnd));
                        cards.get(rnd).setExist(false);
                        break;
                    }
                }
            }
            play++;
        }

        boolean finish = true;
        while (finish) {        //since cards of one player end
            //when use skip card
            if (cards.get(indexCenter).getType() == 10) {
                play += rotation;
                if (play == player.length) {
                    play = 0;
                } else if (play == -1) {
                    play = player.length - 1;
                }
            }
            delete();    //clear Terminal
            map.pritnMap(play, indexCenter, rotation);

            boolean flag = true;
            while (flag) {             //since one player can play, check cards
                flag = false;
                if (penalty != 0) {         //when player have +2 or +4 card an can play on penalty
                    if (check.penalty(play, indexCenter)) {
                        break;
                    }
                }

                if (!(check.checkMove(play, indexCenter))) {      //check player can play with any cards or not
                    flag = true;
                    if (penalty == 0) {       //if had penalty doesn't increase penalty
                        penalty++;
                    }
                    for (int i = 0; i < penalty; i++) {      //first give penalty to player
                        while (true) {
                            int rnd = rand.nextInt(108);
                            if (cards.get(rnd).getExist() && rnd != indexCenter) {
                                player[play].setAddCards(player[play].getCards(), cards.get(rnd));
                                cards.get(rnd).setExist(false);
                                break;
                            }
                        }
                        if (i == penalty - 1) {
                            penalty = 0;
                        }
                    }
                    //when give penalty player can play if she/he can; except index card +2 or +4
                    if (check.checkMove(play, indexCenter) && cards.get(indexCenter).getType() != 12 && cards.get(indexCenter).getType() != 14) {
                        delete();
                        map.pritnMap(play, indexCenter, rotation);
                        break;
                    }

                    play += rotation;
                    if (play == player.length) {
                        play = 0;
                    } else if (play == -1) {
                        play = player.length - 1;
                    }
                    delete();
                    map.pritnMap(play, indexCenter, rotation);
                }
                if (!check.penalty(play, indexCenter)) {        //if have penalty and player can't play
                    for (int i = 0; i < penalty; i++) {
                        while (true) {
                            int rnd = rand.nextInt(108);
                            if (cards.get(rnd).getExist() && rnd != indexCenter) {
                                player[play].setAddCards(player[play].getCards(), cards.get(rnd));
                                cards.get(rnd).setExist(false);
                                break;
                            }
                        }
                        if (i == penalty - 1) {
                            penalty = 0;
                            play += rotation;
                            flag = true;
                            if (play == player.length) {
                                play = 0;
                            } else if (play == -1) {
                                play = player.length - 1;
                            }
                            delete();
                            map.pritnMap(play, indexCenter, rotation);
                        }
                    }
                }
            }
            int choose = 0;
            while (true) {      //since player choose correct card
                if (play + 1 > numHumanPlayers) {           //computer player
                    choose = rand.nextInt(player[play].getCards().size()) + 1;
                } else {    //human player
                    System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_GREEN_BACKGROUND + "           " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_GREEN_BACKGROUND + " " + ANSI_RESET + "         " + ANSI_GREEN_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_GREEN_BACKGROUND + " " + ANSI_RESET + "    ?    " + ANSI_GREEN_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_GREEN_BACKGROUND + " " + ANSI_RESET + "         " + ANSI_GREEN_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_GREEN_BACKGROUND + "           " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t     choose:");
                    choose = scanner.nextInt();
                    scanner.nextLine();
                }
                if (choose - 1 >= player[play].getCards().size() || choose - 1 < 0) {     //if player enter invalid number
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t  Wrong choose");
                    continue;
                }
                if (penalty != 0) {      //if index card +4 just can play +4 and if index card +2 just can play +4 or +2
                    if (cards.get(indexCenter).getType() == 14) {
                        if (player[play].getCards().get(choose - 1).getType() == 14) {
                            break;
                        }
                    } else if (cards.get(indexCenter).getType() == 12) {
                        if (player[play].getCards().get(choose - 1).getType() == 12) {
                            break;
                        }
                    }
                }

                if (check.checkChoose(play, choose - 1, indexCenter)) {    //if penalty != 0 can't play with simple card
                    if (penalty != 0) {
                        continue;
                    }
                    break;
                }
                if (play + 1 <= numHumanPlayers) {      //human player can use wrong choose
                    System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t  Wrong choose");
                }
            }
            if (cards.get(indexCenter).getType() == 13 || cards.get(indexCenter).getType() == 14) {   //back change color card to default color
                cards.get(indexCenter).setColor(5);
            }
            if (play + 1 > numHumanPlayers) {     //sleep for computer player to see choose card
                TimeUnit.SECONDS.sleep(2);
            }
            indexCenter = player[play].getCards().get(choose - 1).getIdCard();      //change index card
            cards.get(indexCenter).setExist(true);

            if (player[play].getCards().get(choose - 1).getType() == 13 || player[play].getCards().get(choose - 1).getType() == 14) {    //choose color to change color cards
                if (play + 1 > numHumanPlayers) {
                    cards.get(indexCenter).setColor(rand.nextInt(4) + 1);
                } else {
                    System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t  1)" + ANSI_RED_BACKGROUND + "  " + ANSI_RESET + " Red   2)" + ANSI_YELLOW_BACKGROUND + "  " + ANSI_RESET + " Yellow   3)" + ANSI_CYAN_BACKGROUND + "  " + ANSI_RESET + " Cyan   4)" + ANSI_BLUE_BACKGROUND + "  " + ANSI_RESET + " Blue" + ANSI_RESET + "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t     choose:");
                    int color = scanner.nextInt();
                    if (color > 4 || color < 0) {
                        continue;
                    }
                    cards.get(indexCenter).setColor(color);
                    scanner.nextLine();
                }
            }
            player[play].setRemoveCards(player[play].getCards(), choose - 1);     //remove choose card from player cards

            if (cards.get(indexCenter).getType() == 12) {     //increase penalty
                penalty += 2;
            } else if (cards.get(indexCenter).getType() == 14) {     //increase penalty
                penalty += 4;
            }

            for (int i = 0; i < player.length; i++) {     //finish game when player cards ended
                if (player[i].getCards().size() == 0) {
                    finish = false;
                }
            }
            for (int i = 0; i < player.length; i++) {    //when player have 1 card
                if (player[i].getCards().size() == 1) {
                    System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_RED_BACKGROUND + "           " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_RED_BACKGROUND + " " + ANSI_RESET + "         " + ANSI_RED_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_RED_BACKGROUND + " " + ANSI_RESET + "Last card" + ANSI_RED_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_RED_BACKGROUND + " " + ANSI_RESET + "    " + (i + 1) + "    " + ANSI_RED_BACKGROUND + " " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t   " + ANSI_RED_BACKGROUND + "           " + ANSI_RESET + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t     choose:");
                    break;
                }
            }

            if (cards.get(indexCenter).getType() == 11) {    //change direction
                rotation *= -1;
            }

            play += rotation;
            if (play == player.length) {
                play = 0;
            } else if (play == -1) {
                play = player.length - 1;
            }
        }

        int[] rating = new int[player.length];      //array to save player points
        for (int i = 0; i < player.length; i++) {
            int sum = 0;
            for (int j = 0; j < player[i].getCards().size(); j++) {
                if (player[i].getCards().get(j).getType() == 14 || player[i].getCards().get(j).getType() == 13) {     //wild card
                    sum += 50;
                } else if (player[i].getCards().get(j).getType() < 13 && player[i].getCards().get(j).getType() > 9) {    //movement card
                    sum += 20;
                } else {     //simple card
                    sum += player[i].getCards().get(j).getType();
                }
            }
            rating[i] = sum;
            player[i].setPoint(sum);
        }
        delete();
        Arrays.sort(rating);     //sort rating array
        map.pritnWinner(rating);    //print rank players
    }

    /**
     * delete method;this method clear Terminal to show better
     */
    public static void delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
