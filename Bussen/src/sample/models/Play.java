package sample.models;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class Play {

    public boolean playerColorPlay(Card fieldCard, int colorPlayer){
        //1 is red
        //2 is black
        String suit = String.valueOf(fieldCard.getSuit());
        if((suit == "HEARTS" || suit == "DIAMONDS") && colorPlayer == 1){
            return true;
        }else if((suit == "CLUBS" || suit == "SPADES" ) && colorPlayer == 2){
            return true;
        }else{
            return false;
        }
    }

    public boolean playerNumberPlay(Card fieldCard, Card pulledCard, int numberPlayer){
        //3 is higher
        //4 is lower
        //5 is equal
        if(fieldCard.getRank() < pulledCard.getRank() && numberPlayer == 3){
            return true;
        }else if(fieldCard.getRank() > pulledCard.getRank() && numberPlayer == 4){
            return true;
        }else if(fieldCard.getRank() == pulledCard.getRank() && numberPlayer == 5){
            return true;
        }else{
            return false;
        }
    }
}
