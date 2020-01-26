
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mihai Daniel Adin
 * 
 * This are the Java Database conection JDBC basics
 */

// Main method that runs the program
public class Main {
    public static void main(String[] args) {
        
        // New database object
        Database db = new Database();
        // Adding persons from the DB in a Person type obj list
        List<Person> persons = db.select();
        
        // Iterating persons from DB
        for(Person pers : persons){
            // Print in the console the person
            System.out.println("pers = " + pers);
        }
        
        
        //Creating a new Perosn object
        Person person = new Person();
        // Initializing the person attributes
        person.setName("Pepe");
        person.setSurname("Gonzalo Garcia");
        person.setEmail("ppgnzlo@gmail.com");
        person.setTelephone("642777321");
        // Insert new person created previous and add to the DB
        db.insert(person);
    }
}
