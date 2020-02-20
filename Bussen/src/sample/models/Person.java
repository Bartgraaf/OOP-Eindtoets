package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import java.time.LocalDate;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class Person {
    private SimpleStringProperty firstName, lastName, fullName;
    private LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
        this.fullName = new SimpleStringProperty(this.firstName.get() + " " + this.lastName.get());
    }

    public Person(String firstName, String lastName, LocalDate birthday, Image photo) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
        setFullName();
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
        setFullName();
    }

    public LocalDate getBirthday() {
        return birthday;
    }


    public String getFullName() {
        return fullName.get();
    }

    public String toString()
    {
        return String.format("%s %s %s", firstName, lastName, fullName);
    }

    public void setFullName(){
        this.fullName = new SimpleStringProperty(this.firstName.get() + " " + this.lastName.get());
    }
}
