/**
 * <h1>Check class</h1>
 * have checkMove method to check player can play or not <br/>
 * have penalty method to check player can play on penalty cards or not<br/>
 * have checkChoose method to check player choose correct card or not
 */
public class Check {
    /**
     * @param play       turn player
     * @param centerCard index of center card
     * @return true if can play and false if can't
     */
    public boolean checkMove(int play, int centerCard) {
        boolean flag = false;         //to return true if player can play
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            if (Main.player[play].getCards().get(i).getColor() == Main.cards.get(centerCard).getColor()) {     //same colors can play
                flag = true;
                break;
            } else if (Main.player[play].getCards().get(i).getType() == Main.cards.get(centerCard).getType()) {   //same type can play
                flag = true;
                break;
            } else if ( Main.player[play].getCards().get(i).getColor() == 5) {       //if have wild card or wild card on center can play(check other condition in penalty method)
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * @param play       turn player
     * @param centerCard index of center card
     * @return true if can play and false if can't
     */
    public boolean penalty(int play, int centerCard) {
        //if penalty != 0
        for (int i = 0; i < Main.player[play].getCards().size(); i++) {
            if (Main.cards.get(centerCard).getType() == 14) {
                if (Main.player[play].getCards().get(i).getType() == 14) {      //on wild card just can play wild card(type 14)
                    return true;
                }
            } else if (Main.cards.get(centerCard).getType() == 12) {
                if (Main.player[play].getCards().get(i).getType() == 12) {    //on +2 card can play wild card(+4) or +2
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param play       turn player
     * @param centerCard index of center card
     * @param cardPlay   index of player cards choose
     * @return true if can play and false if can't
     */
    public boolean checkChoose(int play, int cardPlay, int centerCard) {
        boolean flag = false;
        if (Main.player[play].getCards().get(cardPlay).getColor() == Main.cards.get(centerCard).getColor()) {
            flag = true;
        } else if (Main.player[play].getCards().get(cardPlay).getType() == Main.cards.get(centerCard).getType()) {
            flag = true;
        }  else if (Main.player[play].getCards().get(cardPlay).getColor() == 5) {
            flag = true;
        }
        //check if player can play with other card , can't use wild card
        if (Main.player[play].getCards().get(cardPlay).getType() == 14) {
            for (int i = 0; i < Main.player[play].getCards().size(); i++) {
                if (i == cardPlay) {
                    continue;      //didn't check current card
                }
                if (Main.player[play].getCards().get(i).getColor() == Main.cards.get(centerCard).getColor() && Main.player[play].getCards().get(i).getType() != 14) {
                    flag = false;
                    break;
                } else if (Main.player[play].getCards().get(i).getType() == Main.cards.get(centerCard).getType() && Main.player[play].getCards().get(i).getType() != 14) {
                    flag = false;
                    break;
                } else if (Main.player[play].getCards().get(i).getType() == 13) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
