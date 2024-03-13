package cinema.model.demo;

import cinema.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonDemo {

    @Test
    void demoPersons(){
        var p1 = new Person();
        var p2 = new Person("Denis Villeneuve", LocalDate.of(1967, 10, 3));
        System.out.println(p1);
        System.out.println(p2);
        // set p1 name and birthdate: Zendaya, 1/9/1996
        p1.setName("Zendaya");
        p1.setBirthdate(LocalDate.of(1996,9,1));
        // print again p1
        System.out.println(p1);
        // print only name
        System.out.println(p1.getName());
        // print only birthdate
        System.out.println(p1.getBirthdate());
    }

}