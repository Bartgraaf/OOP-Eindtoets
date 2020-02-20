package sample.models;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

import java.time.LocalDate;

public class SmallBoyPlayer extends Person {

    private double shame;

    public SmallBoyPlayer(String firstName, String lastName, LocalDate birthday, int shame) {
        super(firstName, lastName, birthday);
        this.shame = shame;
    }

    public double getShame(){
        return this.shame;
    }
}
