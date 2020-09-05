/**
 * <h1>Card class</h1>
 * this class input 1 number and convert it to specific type and color for cards<br/>
 * have getExist method to return card exit in box or not
 * have getColor method to return ID of color card
 * have getType method to return type of cards
 * have getIdCard method to return number of card in box for remove and add to box
 * have setExit method to remove and card from box
 * have setColor method to change "changeColor" card when player use it
 */
public class Card {
    /**
     * @param color to save color of cards
     * @param type to save type of cards
     * @param exist to chck cards exist in box of cards or not
     * @param IdCard save number of cards
     */
    private int color;
    private int type;
    private boolean exist;
    private int IdCard;

    /**
     * Card constructor generate cards
     */
    public Card(int num) {
        this.IdCard = num - 1;
        this.exist = true;

        this.color = (num / 25) + 1;
        if (num % 25 == 0) {       //to prevent bug for +2 cards
            if (this.color == 1) {
                this.type = 0;  //to handle first input
            } else {
                this.color--;
                this.type = 12;
            }
            if (num == 0) {
                this.type = 0;
            }
            return;
        }
        if (num <= 100) {
            num -= (this.color - 1) * 25;
            if (num == 20 || num == 21) {    //skip cards
                this.type = 10;
            } else if (num == 22 || num == 23) {  //reverse cards
                this.type = 11;
            } else if (num == 24) {    //+2 card
                this.type = 12;
            } else if (num < 20 && num > 10) {    //number cards (set 2)
                this.type = num - 10;
            } else {
                this.type = num - 1;   //number cards(set 1)
            }
        } else if (num < 105) {
            this.type = 13;    //change color cards
        } else {
            this.type = 14;    //+4 cards
        }
    }

    public boolean getExist() {
        return exist;
    }

    public int getColor() {
        return color;
    }

    public int getType() {
        return type;
    }

    public int getIdCard() {
        return IdCard;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
