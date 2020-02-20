package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import sample.models.Person;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class PlayerSelectController implements Initializable {

    //configure the table
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;

    //These instance variables are used to create new Person objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        //load dummy data
        tableView.setItems(getPeople());

        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void changeFirstNameCellEvent(CellEditEvent edittedCell){
        Person personSelected =  tableView.getSelectionModel().getSelectedItem();
        if(validateString(edittedCell.getNewValue().toString())){
            personSelected.setFirstName(edittedCell.getNewValue().toString());
        }else{
            Alert alertInputNotCorrect = new Alert(Alert.AlertType.WARNING);
            alertInputNotCorrect.setTitle("Alert");
            alertInputNotCorrect.setContentText("The input field is not filled in properly.");
            alertInputNotCorrect.setHeaderText(null);
            alertInputNotCorrect.showAndWait();
        }
    }


    public void changeLastNameCellEvent(CellEditEvent edittedCell){
        Person personSelected =  tableView.getSelectionModel().getSelectedItem();
        if(validateString(edittedCell.getNewValue().toString())){
            personSelected.setLastName(edittedCell.getNewValue().toString());
        }else{
            Alert alertInputNotCorrect = new Alert(Alert.AlertType.WARNING);
            alertInputNotCorrect.setTitle("Alert");
            alertInputNotCorrect.setContentText("The input field is not filled in properly.");
            alertInputNotCorrect.setHeaderText(null);
            alertInputNotCorrect.showAndWait();
        }
    }

    public void userClickedOnTable()
    {
    }

    public void nextScreenButtonPushed(ActionEvent event) throws IOException{
        if(tableView.getItems().size() > 0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/FXMLSettingsSelect.fxml"));
            Parent tableViewParent = loader.load();

            Scene tableViewScene = new Scene(tableViewParent);

            //access the controller and call a method
            SettingsSelectController controller = loader.getController();
            controller.initData(tableView.getItems());

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }else{
            Alert alertInputNotCorrect = new Alert(Alert.AlertType.WARNING);
            alertInputNotCorrect.setTitle("Alert");
            alertInputNotCorrect.setContentText("There needs to be at least 1 person to play this ame.");
            alertInputNotCorrect.setHeaderText(null);
            alertInputNotCorrect.showAndWait();
        }
    }

    public void deleteButtonPushed(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();

        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
        }
    }


    public void newPersonButtonPushed(){
        if(validateString(firstNameTextField.getText()) && validateString(lastNameTextField.getText()) && validateDate(String.valueOf(birthdayDatePicker.getValue()))){
            Person newPerson = new Person(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    birthdayDatePicker.getValue());

            //Get all the items from the table as a list, then add the new person to
            //the list
            tableView.getItems().add(newPerson);
        }else{
            Alert alertInputNotCorrect = new Alert(Alert.AlertType.WARNING);
            alertInputNotCorrect.setTitle("Alert");
            alertInputNotCorrect.setContentText("The input field are not filled in properly, try using the datepicker for the date.");
            alertInputNotCorrect.setHeaderText(null);
            alertInputNotCorrect.showAndWait();
        }

    }

    private boolean validateString(String input){
        final Pattern pattern = Pattern.compile("^[a-zA-Z\\- \\/_?:.,\\s]+$");
        if (!pattern.matcher(input).matches()) {
            return false;
        }else{
            return true;
        }
    }

    private boolean validateDate(String input){
        final Pattern pattern = Pattern.compile("^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$");
        if (!pattern.matcher(input).matches()) {
            return false;
        }else{
            return true;
        }
    }

    public ObservableList<Person>  getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        return people;
    }
}
