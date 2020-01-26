
package Main;

import java.util.ArrayList;
import java.util.List;
// IMPORT DB METHODS TO MODIFY DATA
import DB.Select;
import DB.Insert;
import DB.Update;
import DB.Remove;

/**
 * @author Mihai Daniel Adin
 * 
 *          Project Structure
 *                Main
 * -----------------|---------------
 * |          |          |         |
 * Select   Insert    Update    Remove
 * -----------------------------------
 * Database     Connection      Person
 *                  |
 *                MySQL
 * Image in project img folder
 * 
 * This are the Java Database conection JDBC basics
 * Making an fully functional JDBC CRUD API with mySQL Database
 */

// Main method that runs the program
public class Main {
    public static void main(String[] args) {
        
        // New database object
        Select selectDB = new Select();
        Insert insertDB = new Insert();
        Update updateDB = new Update();
        Remove removeDB = new Remove();
        
        // Adding persons from the DB in a Person type obj list
        List<Person> persons = selectDB.select();
        
        // Iterating persons from DB
        for(Person pers : persons){
            // Print in the console the person
            System.out.println("pers = " + pers);
        }
        
        /*
        //Creating a new Perosn object
        Person person = new Person();
        // Initializing the person attributes
        person.setName("Pepe");
        person.setSurname("Gonzalo Garcia");
        person.setEmail("ppgnzlo@gmail.com");
        person.setTelephone("642777321");
        // Insert new person created previous and add to the DB
        insertDB.insert(person);
        */
    }
}
