package sample.models;

import java.util.ArrayList;

import java.util.List;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class Game {

    private String singularName;
    private String pluralName;
    private int cardAmount;
    private int fieldPosition;
    private int fieldPositionReached;
    private int fieldPositionToReveal;
    private int nextPlay;
    private int currentLoop;
    private int currentList;
    private Deck deck;
    private List<BigBoyPlayer> BigBoyPlayer;
    private List<SmallBoyPlayer> SmallBoyPlayer;
    private List<Person> Player;
    private String currentName;
    private double currentDivision;
    private ArrayList<Card> field;
    private boolean questionAnsweredWrong;


    public void setSingularName(String singularName) {
        this.singularName = singularName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public void setCardAmount(int cardAmount) {
        this.cardAmount = cardAmount;
    }

    public void setBigBoyPlayer(List<BigBoyPlayer> bigBoyPlayer) {
        this.BigBoyPlayer = bigBoyPlayer;
    }

    public void setSmallBoyPlayer(List<SmallBoyPlayer> smallBoyPlayer) {
        this.SmallBoyPlayer = smallBoyPlayer;
    }

    public void setPlayer(List<sample.models.Person> Player) {
        this.Player = Player;
    }

    public void startGame(){
        deck = new Deck();
        this.deck.shuffle();
        this.layField();
        this.fieldPosition = 0;
        this.fieldPositionReached = 0;
        this.fieldPositionToReveal = 0;
        this.nextPlay = 1;
        this.currentList = 1;
        this.currentLoop = 1;
        this.setPersonAndDivision();
    }

    public void nextMove(int buttonPushed){
        this.questionAnsweredWrong = false;
        //If next move is not correctly configured start a new game
        try{
            Play newTurn = new Play();
            if(buttonPushed == 1 || buttonPushed == 2){
                if(newTurn.playerColorPlay(this.field.get(this.fieldPosition), buttonPushed)){
                    //if the card is correct go to the next card on the field
                    this.fieldPositionReached++;
                }else{
                    //if the cart is incorrect reset the position to its start
                    this.setPersonAndDivision();
                    this.fieldPositionReached++;
                    this.fieldPosition = 0;
                    this.questionAnsweredWrong = true;
                }
            }else if(buttonPushed == 3 || buttonPushed == 4 || buttonPushed == 5){
                if(this.deck.empty()){
                    this.deck.refresh();
                }
                Card newTurnCard = this.deck.takeCard();
                if(newTurn.playerNumberPlay(this.field.get(this.fieldPosition), newTurnCard , buttonPushed)){
                    //if the card is correct go to the next card on the field
                    this.field.set(this.fieldPosition, newTurnCard);
                    this.fieldPosition++;
                }else{
                    //if the cart is incorrect reset the position to its start
                    this.setPersonAndDivision();
                    this.field.set(this.fieldPosition, newTurnCard);
                    this.fieldPosition = 0;
                    this.questionAnsweredWrong = true;
                }
            }
        }
        catch (Exception e) {
            startGame();
            System.out.println("Something went wrong.");
        }

        if(this.fieldPositionReached < this.fieldPosition){
            this.fieldPositionReached = this.fieldPosition;
        }

        if(this.fieldPosition  <  this.fieldPositionReached){
            this.nextPlay = 0;
        }else{
            this.nextPlay = 1;
        }
    }

    public boolean gameIsOver(){
        return this.cardAmount == this.fieldPosition;
    }

    public boolean needToShowForfeit(){
        return this.fieldPosition == 0;
    }

    private void setPersonAndDivision(){
        if(this.currentList == 1){
            if(this.BigBoyPlayer.size() > 0 && this.currentLoop <= this.BigBoyPlayer.size()){
                this.currentName = this.BigBoyPlayer.get(currentLoop - 1).getFullName();
                this.currentDivision = this.BigBoyPlayer.get(currentLoop - 1).getFame();
                this.currentLoop++;
                return;
            }else{
                this.currentLoop = 1;
                this.currentList = 2;
            }
        }

        if(this.currentList == 2) {
            if (this.Player.size() > 0 && this.currentLoop <= this.Player.size()) {
                this.currentName = this.Player.get(currentLoop - 1).getFullName();
                this.currentDivision = 1.5;
                this.currentLoop++;
                return;
            } else {
                this.currentLoop = 1;
                this.currentList = 3;
            }
        }

        if(this.currentList == 3) {
            if (this.SmallBoyPlayer.size() > 0 && this.currentLoop <= this.SmallBoyPlayer.size()) {
                this.currentName = this.SmallBoyPlayer.get(currentLoop - 1).getFullName();
                this.currentDivision = this.SmallBoyPlayer.get(currentLoop - 1).getShame();
                this.currentLoop++;
            } else {
                this.currentLoop = 1;
                this.currentList = 1;
                this.setPersonAndDivision();
            }
        }
    }

    private void layField(){
        this.field = new ArrayList<>();
        for (int i = 0; i < this.cardAmount; i++){
            this.field.add(this.deck.takeCard());
        }
    }

    public String getSingularName() {
        return this.singularName;
    }

    public String getPluralName() {
        return this.pluralName;
    }

    public int getNextPlay(){
        return this.nextPlay;
    }

    public int getFieldPositionReached(){
        return this.fieldPositionReached;
    }

    public int getFieldPosition(){
        return this.fieldPosition;
    }

    public ArrayList getField(){
        return this.field;
    }

    public String getCurrentName(){
        return this.currentName;
    }

    public double getCurrentDivision(){
        return this.currentDivision;
    }

    public boolean getQuestionAnsweredWrong(){
        return this.questionAnsweredWrong;
    }

    public double getTotalPunishment(double division, int punishmentAmount){
        return punishmentAmount * division;
    }
}
