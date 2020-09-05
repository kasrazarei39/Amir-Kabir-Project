/**
 * <h1>Player class</h1>
 * this class input 1 String and generate player
 * have getName method to return name of player
 * have getCards method to return cards of player
 * have getPoint method to return point of player
 * have setPoint method to add player's point end of game
 * have setAddCards to add new card in player list
 * have setRemoveCards to remove card from player list
 */

import java.util.ArrayList;
import java.util.Random;

public class Player {
    /**
     * @param name to save player name
     * @param point to save player points
     * @param cards to save player's cards
     */
    private String name;
    private int point;
    private ArrayList<Card> cards = new ArrayList<>();

    Random rand = new Random();

    /**
     * generate players and give them 7 random cards when game start
     *
     * @param name input from user
     */
    public Player(String name) {
        this.name = name;
        int i = 0;
        while (i < 7) {
            int index = rand.nextInt(108);
            if (Main.cards.get(index).getExist()) {         //if card exist in box
                cards.add(Main.cards.get(index));           //add to player's cards
                Main.cards.get(index).setExist(false);      //remove from box
                i++;
            }

        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setAddCards(ArrayList<Card> cards, Card card) {
        cards.add(card);
    }

    public void setRemoveCards(ArrayList<Card> cards, int index) {
        cards.remove(index);
    }
}
