package sample.controllers;

import java.io.IOException;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import sample.models.Person;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class SettingsSelectController {

    //configure the tables
    @FXML private TableView<Person> bigplayer;
    @FXML private TableColumn<Person, String> NameColumn1;

    @FXML private TableView<Person> player;
    @FXML private TableColumn<Person, String> NameColumn2;

    @FXML private TableView<Person> smallplayer;
    @FXML private TableColumn<Person, String> NameColumn3;

    @FXML private TextField singularName;
    @FXML private TextField pluralName;
    @FXML private TextField cardsAmount;

    @FXML
    private void inputFieldsAlert(ActionEvent event){
        Alert alertInputNotCorrect = new Alert(AlertType.WARNING);
        alertInputNotCorrect.setTitle("Notice");
        alertInputNotCorrect.setContentText("Not all fields are filled in, or not all fields are filled in correctly. Also make sure to only use text for the punishment and numbers for the amount of cards");
        alertInputNotCorrect.setHeaderText(null);
        alertInputNotCorrect.showAndWait();
    }

    public void initData(ObservableList<Person> person){
        //set up the columns in the table
        NameColumn2.setCellValueFactory(new PropertyValueFactory<Person, String>("fullName"));

        player.setItems(person);
    }

    public void nextScreenButtonPushed(ActionEvent event) throws IOException{
        if(validateCardAmountInt(cardsAmount.getText()) && validateString(singularName.getText()) && validateString(pluralName.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/FXMLGameScreen.fxml"));
            Parent tableViewParent = loader.load();

            Scene tableViewScene = new Scene(tableViewParent);

            //access the controller and call a method
            GameScreenController controller = loader.getController();
            controller.initData(bigplayer.getItems(), smallplayer.getItems(), player.getItems(), cardsAmount.getText(), singularName.getText(), pluralName.getText());

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }else{
            inputFieldsAlert(event);
        }
    }

    //Move player from "Players" to "Big boi"
    public void moveToBigPlayerButtonPushed(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = player.getItems();

        //this gives us the rows that were selected
        selectedRows = player.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
            NameColumn1.setCellValueFactory(new PropertyValueFactory<Person, String>("fullName"));
            bigplayer.getItems().add(person);
        }

    }

    //Move player from "Big boi" to "Players"
    public void moveToPlayerButtonPushed1(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = bigplayer.getItems();

        //this gives us the rows that were selected
        selectedRows = bigplayer.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
            NameColumn2.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
            player.getItems().add(person);
        }

    }


    //Move player from "Players" to "Small boi"
    public void moveToSmallPlayerButtonPushed(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = player.getItems();

        //this gives us the rows that were selected
        selectedRows = player.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
            NameColumn3.setCellValueFactory(new PropertyValueFactory<Person, String>("fullName"));
            smallplayer.getItems().add(person);
        }

    }

    //Move player from "Small boi" to "Players"
    public void moveToPlayerButtonPushed2(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = smallplayer.getItems();

        //this gives us the rows that were selected
        selectedRows = smallplayer.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
            NameColumn2.setCellValueFactory(new PropertyValueFactory<Person, String>("fullName"));
            player.getItems().add(person);
        }

    }

    private boolean validateString(String input){
        final Pattern pattern = Pattern.compile("^[0-9a-zA-Z\\- \\/_?:.,\\s]+$");
        if (!pattern.matcher(input).matches()) {
            return false;
        }else{
            return true;
        }
    }

    private boolean validateCardAmountInt(String input){
        final Pattern pattern = Pattern.compile("([2-9]|10)");
        if (!pattern.matcher(input).matches()) {
            return false;
        }else{
            return true;
        }
    }

}
