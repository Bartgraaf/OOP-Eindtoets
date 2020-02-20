package sample.tests;

import org.junit.jupiter.api.Test;
import sample.models.Person;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

class PersonTest {

    @Test
    void testGetFirstName() {
        Person person = new Person("Bart", "de Graaf", LocalDate.of(2000, Month.JUNE, 16));
        String firstName = person.getFirstName();
        assertEquals("Bart", firstName);
    }

    @Test
    void testGetLastName() {
        Person person = new Person("Bart", "de Graaf", LocalDate.of(2000, Month.JUNE, 16));
        String lastName = person.getLastName();
        assertEquals("de Graaf", lastName);
    }

    @Test
    void testGetBirthday() {
        Person person = new Person("Bart", "de Graaf", LocalDate.of(2000, Month.JUNE, 16));
        LocalDate birthday = person.getBirthday();
        assertEquals(LocalDate.of(2000, Month.JUNE, 16), birthday);
    }

    @Test
    void testGetFullName() {
        Person person = new Person("Bart", "de Graaf", LocalDate.of(2000, Month.JUNE, 16));
        String fullName = person.getFullName();
        assertEquals("Bart de Graaf", fullName);
    }
}