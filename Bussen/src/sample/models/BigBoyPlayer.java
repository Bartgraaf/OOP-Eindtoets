package sample.models;

import java.time.LocalDate;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class BigBoyPlayer extends Person {

    private double fame;

    public BigBoyPlayer(String firstName, String lastName, LocalDate birthday, int fame) {
        super(firstName, lastName, birthday);
        this.fame = fame;

    }

    public double getFame(){
        return this.fame;
    }

}
