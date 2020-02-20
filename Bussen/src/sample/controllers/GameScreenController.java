package sample.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import sample.models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class GameScreenController implements Initializable {

    @FXML private Label personLabel;
    @FXML private Label setLabelAsNeeded;

    @FXML private Label topLabelCard0;
    @FXML private Label bottomLabelCard0;
    @FXML private Label labelCard0;
    @FXML private Rectangle card0;

    @FXML private Label topLabelCard1;
    @FXML private Label bottomLabelCard1;
    @FXML private Label labelCard1;
    @FXML private Rectangle card1;

    @FXML private Label topLabelCard2;
    @FXML private Label bottomLabelCard2;
    @FXML private Label labelCard2;
    @FXML private Rectangle card2;

    @FXML private Label topLabelCard3;
    @FXML private Label bottomLabelCard3;
    @FXML private Label labelCard3;
    @FXML private Rectangle card3;

    @FXML private Label topLabelCard4;
    @FXML private Label bottomLabelCard4;
    @FXML private Label labelCard4;
    @FXML private Rectangle card4;

    @FXML private Label topLabelCard5;
    @FXML private Label bottomLabelCard5;
    @FXML private Label labelCard5;
    @FXML private Rectangle card5;

    @FXML private Label topLabelCard6;
    @FXML private Label bottomLabelCard6;
    @FXML private Label labelCard6;
    @FXML private Rectangle card6;

    @FXML private Label topLabelCard7;
    @FXML private Label bottomLabelCard7;
    @FXML private Label labelCard7;
    @FXML private Rectangle card7;

    @FXML private Label topLabelCard8;
    @FXML private Label bottomLabelCard8;
    @FXML private Label labelCard8;
    @FXML private Rectangle card8;

    @FXML private Label topLabelCard9;
    @FXML private Label bottomLabelCard9;
    @FXML private Label labelCard9;
    @FXML private Rectangle card9;

    private Game MainGame;

    public void initData(ObservableList<Person> bigPersons, ObservableList<Person> smallPersons, ObservableList<Person> persons, String cardAmount, String singularName, String pluralName){
        List<BigBoyPlayer> bigBoyPlayerList = new ArrayList<BigBoyPlayer>();
        List<SmallBoyPlayer> smallBoyPlayerList = new ArrayList<SmallBoyPlayer>();
        List<Person> PlayerList = new ArrayList<>();

        bigPersons.forEach((person) -> {
            bigBoyPlayerList.add(new BigBoyPlayer(person.getFirstName(),  person.getLastName(), person.getBirthday(), 2));
        });
        smallPersons.forEach((person) -> {
            smallBoyPlayerList.add(new SmallBoyPlayer(person.getFirstName() , person.getLastName(), person.getBirthday(), 1));
        });

        persons.forEach((person) -> {
            PlayerList.add(new Person(person.getFirstName(), person.getLastName(), person.getBirthday()));
        });

        MainGame = new Game();
        MainGame.setBigBoyPlayer(bigBoyPlayerList);
        MainGame.setSmallBoyPlayer(smallBoyPlayerList);
        MainGame.setPlayer(PlayerList);
        MainGame.setCardAmount(Integer.parseInt(cardAmount));
        MainGame.startGame();
        MainGame.setSingularName(singularName);
        MainGame.setPluralName(pluralName);

        setLabelAsNeeded();
        personLabel.setText(MainGame.getCurrentName());
    }

    public void higherButtonPushed(ActionEvent event) throws IOException{
        if(MainGame.getNextPlay() == 0){
            int numberToRefresh = MainGame.getFieldPosition();
            String oldName = MainGame.getCurrentName();
            double oldDivision = MainGame.getCurrentDivision();
            MainGame.nextMove(3);
            refreshGameBoard(numberToRefresh, oldName, oldDivision);
            setHighlightedCard(MainGame.getFieldPosition());
            setLabelAsNeeded();
        }else{
            //A alert with wrong game type played needs to come here.
            System.out.println("A alert with wrong game type played needs to come here");
        }
    }

    public void lowerButtonPushed(ActionEvent event) throws IOException{
        if(MainGame.getNextPlay() == 0){
            int numberToRefresh = MainGame.getFieldPosition();
            String oldName = MainGame.getCurrentName();
            double oldDivision = MainGame.getCurrentDivision();
            MainGame.nextMove(4);
            refreshGameBoard(numberToRefresh, oldName, oldDivision);
            setHighlightedCard(MainGame.getFieldPosition());
            setLabelAsNeeded();

        }else{
            //A alert with wrong game type played needs to come here.
            System.out.println("A alert with wrong game type played needs to come here");
        }
    }

    public void equalButtonPushed(ActionEvent event) throws IOException{

        if(MainGame.getNextPlay() == 0){
            int numberToRefresh = MainGame.getFieldPosition();
            String oldName = MainGame.getCurrentName();
            double oldDivision = MainGame.getCurrentDivision();
            MainGame.nextMove(5);
            refreshGameBoard(numberToRefresh, oldName, oldDivision);
            setHighlightedCard(MainGame.getFieldPosition());
            setLabelAsNeeded();
        }else{
            //A alert with wrong game type played needs to come here.
            System.out.println("A alert with wrong game type played needs to come here");
        }
    }

    public void redButtonPushed(ActionEvent event) throws IOException{
        if(MainGame.getNextPlay() == 1){
            int numberToRefresh = MainGame.getFieldPositionReached();
            String oldName = MainGame.getCurrentName();
            double oldDivision = MainGame.getCurrentDivision();
            MainGame.nextMove(1);
            refreshGameBoard(numberToRefresh, oldName, oldDivision);
            setHighlightedCard(MainGame.getFieldPosition());
            setLabelAsNeeded();
        }else{
            //A alert with wrong game type played needs to come here.
            System.out.println("A alert with wrong game type played needs to come here");
        }
    }

    public void blackButtonPushed(ActionEvent event) throws IOException{
        if(MainGame.getNextPlay() == 1){
            int numberToRefresh = MainGame.getFieldPosition();
            String oldName = MainGame.getCurrentName();
            double oldDivision = MainGame.getCurrentDivision();
            MainGame.nextMove(2);
            refreshGameBoard(numberToRefresh, oldName, oldDivision);
            setHighlightedCard(MainGame.getFieldPosition());
            setLabelAsNeeded();
        }else{
            //A alert with wrong game type played needs to come here.
            System.out.println("A alert with wrong game type played needs to come here");
        }
    }

    private void setLabelAsNeeded(){
        if(MainGame.getNextPlay() == 1){
            setLabelAsNeeded.setText("Use the Red and Black buttons \nto guess what color the card is");
        }else{
            setLabelAsNeeded.setText("Use the Higher, Lower and Equal \nbuttons to guess if the following card is \nHigher, Lower or Equal");
        }
    }

    private void setHighlightedCard(int cardToHighlight){
        switch(cardToHighlight) {
            case 0:
                card0.setStrokeWidth(4);
                card0.setStroke(Paint.valueOf("#00e440"));
                break;
            case 1:
                card1.setStrokeWidth(4);
                card1.setStroke(Paint.valueOf("#00e440"));
                break;
            case 2:
                card2.setStrokeWidth(4);
                card2.setStroke(Paint.valueOf("#00e440"));
                break;
            case 3:
                card3.setStrokeWidth(4);
                card3.setStroke(Paint.valueOf("#00e440"));
                break;
            case 4:
                card4.setStrokeWidth(4);
                card4.setStroke(Paint.valueOf("#00e440"));
                break;
            case 5:
                card5.setStrokeWidth(4);
                card5.setStroke(Paint.valueOf("#00e440"));
                break;
            case 6:
                card6.setStrokeWidth(4);
                card6.setStroke(Paint.valueOf("#00e440"));
                break;
            case 7:
                card7.setStrokeWidth(4);
                card7.setStroke(Paint.valueOf("#00e440"));
                break;
            case 8:
                card8.setStrokeWidth(4);
                card8.setStroke(Paint.valueOf("#00e440"));
                break;
            case 9:
                card9.setStrokeWidth(4);
                card9.setStroke(Paint.valueOf("#00e440"));
                break;
            default:
                System.out.println("Er is iets mis gegaan");
        }
    }

    private void refreshGameBoard(int cardsToRefresh, String oldName, double oldDivision){
        ArrayList<Card> field = MainGame.getField();
        Card currentCard = field.get(cardsToRefresh);
        char iconCard = currentCard.getSuitIcon();
        String iconCardS = String.valueOf(iconCard);
        switch(cardsToRefresh) {
            case 0:
                labelCard0.setText(currentCard.getRankCardLike());
                topLabelCard0.setText(iconCardS);
                bottomLabelCard0.setText(iconCardS);
                labelCard0.setStyle(currentCard.getCardColor());
                topLabelCard0.setStyle(currentCard.getCardColor());
                bottomLabelCard0.setStyle(currentCard.getCardColor());
                card0.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 1:
                labelCard1.setText(currentCard.getRankCardLike());
                topLabelCard1.setText(iconCardS);
                bottomLabelCard1.setText(iconCardS);
                labelCard1.setStyle(currentCard.getCardColor());
                topLabelCard1.setStyle(currentCard.getCardColor());
                bottomLabelCard1.setStyle(currentCard.getCardColor());
                card1.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 2:
                labelCard2.setText(currentCard.getRankCardLike());
                topLabelCard2.setText(iconCardS);
                bottomLabelCard2.setText(iconCardS);
                labelCard2.setStyle(currentCard.getCardColor());
                topLabelCard2.setStyle(currentCard.getCardColor());
                bottomLabelCard2.setStyle(currentCard.getCardColor());
                card2.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 3:
                labelCard3.setText(currentCard.getRankCardLike());
                topLabelCard3.setText(iconCardS);
                bottomLabelCard3.setText(iconCardS);
                labelCard3.setStyle(currentCard.getCardColor());
                topLabelCard3.setStyle(currentCard.getCardColor());
                bottomLabelCard3.setStyle(currentCard.getCardColor());
                card3.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 4:
                labelCard4.setText(currentCard.getRankCardLike());
                topLabelCard4.setText(iconCardS);
                bottomLabelCard4.setText(iconCardS);
                labelCard4.setStyle(currentCard.getCardColor());
                topLabelCard4.setStyle(currentCard.getCardColor());
                bottomLabelCard4.setStyle(currentCard.getCardColor());
                card4.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 5:
                labelCard5.setText(currentCard.getRankCardLike());
                topLabelCard5.setText(iconCardS);
                bottomLabelCard5.setText(iconCardS);
                labelCard5.setStyle(currentCard.getCardColor());
                topLabelCard5.setStyle(currentCard.getCardColor());
                bottomLabelCard5.setStyle(currentCard.getCardColor());
                card5.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 6:
                labelCard6.setText(currentCard.getRankCardLike());
                topLabelCard6.setText(iconCardS);
                bottomLabelCard6.setText(iconCardS);
                labelCard6.setStyle(currentCard.getCardColor());
                topLabelCard6.setStyle(currentCard.getCardColor());
                bottomLabelCard6.setStyle(currentCard.getCardColor());
                card6.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 7:
                labelCard7.setText(currentCard.getRankCardLike());
                topLabelCard7.setText(iconCardS);
                bottomLabelCard7.setText(iconCardS);
                labelCard7.setStyle(currentCard.getCardColor());
                topLabelCard7.setStyle(currentCard.getCardColor());
                bottomLabelCard7.setStyle(currentCard.getCardColor());
                card7.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 8:
                labelCard8.setText(currentCard.getRankCardLike());
                topLabelCard8.setText(iconCardS);
                bottomLabelCard8.setText(iconCardS);
                labelCard8.setStyle(currentCard.getCardColor());
                topLabelCard8.setStyle(currentCard.getCardColor());
                bottomLabelCard8.setStyle(currentCard.getCardColor());
                card8.setFill(Paint.valueOf("#d7d7d7"));
                break;
            case 9:
                labelCard9.setText(currentCard.getRankCardLike());
                topLabelCard9.setText(iconCardS);
                bottomLabelCard9.setText(iconCardS);
                labelCard9.setStyle(currentCard.getCardColor());
                topLabelCard9.setStyle(currentCard.getCardColor());
                bottomLabelCard9.setStyle(currentCard.getCardColor());
                card9.setFill(Paint.valueOf("#d7d7d7"));
                break;
            default:
                // code block
                System.out.println("Er is iets mis gegaan");
                break;
        }
        //Set the correct player name
        personLabel.setText(MainGame.getCurrentName());


        //Reset the color from the highlighted card
        card0.setStroke(Paint.valueOf("#000000"));
        card0.setStrokeWidth(1);
        card1.setStroke(Paint.valueOf("#000000"));
        card1.setStrokeWidth(1);
        card2.setStroke(Paint.valueOf("#000000"));
        card2.setStrokeWidth(1);
        card3.setStroke(Paint.valueOf("#000000"));
        card3.setStrokeWidth(1);
        card4.setStroke(Paint.valueOf("#000000"));
        card4.setStrokeWidth(1);
        card5.setStroke(Paint.valueOf("#000000"));
        card5.setStrokeWidth(1);
        card6.setStroke(Paint.valueOf("#000000"));
        card6.setStrokeWidth(1);
        card7.setStroke(Paint.valueOf("#000000"));
        card7.setStrokeWidth(1);
        card8.setStroke(Paint.valueOf("#000000"));
        card8.setStrokeWidth(1);
        card9.setStroke(Paint.valueOf("#000000"));
        card9.setStrokeWidth(1);

        if(MainGame.needToShowForfeit() && MainGame.getQuestionAnsweredWrong()){
            Alert alertInputNotCorrect = new Alert(Alert.AlertType.WARNING);
            alertInputNotCorrect.setTitle("Alert");
            cardsToRefresh++;
            if(MainGame.getTotalPunishment(oldDivision, cardsToRefresh) > 0){
                alertInputNotCorrect.setContentText(oldName + " picked the wrong option! He/She now needs to do " + MainGame.getTotalPunishment(oldDivision, cardsToRefresh) + " " + MainGame.getPluralName());
            }else{
                alertInputNotCorrect.setContentText(oldName + " picked the wrong option! He/She now needs to do " + MainGame.getTotalPunishment(oldDivision, cardsToRefresh) + " " + MainGame.getSingularName());
            }
            alertInputNotCorrect.setHeaderText(null);
            alertInputNotCorrect.showAndWait();
        }

        if(MainGame.gameIsOver()){
            Alert alertInputNotCorrect = new Alert(Alert.AlertType.CONFIRMATION);
            alertInputNotCorrect.setTitle("Congratulations");
            alertInputNotCorrect.setContentText("The game is over! You cleared the amount of cards that you put in at the start!");
            alertInputNotCorrect.setHeaderText(null);
            alertInputNotCorrect.showAndWait();
            System.exit(1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
