
package Main;

import java.util.ArrayList;
import java.util.List;
// IMPORT DB METHODS TO MODIFY DATA
import DB.Select;
import DB.Insert;
import DB.Update;
import DB.Remove;
import DB.UserAuth;
/**
 * @author Mihai Daniel Adin
 * 
 * This are the Java Database conection JDBC basics
 * Making an fully functional JDBC CRUD API with mySQL Database
 */

// Main method that runs the program
public class Main {
    public static void main(String[] args) {
        
        // New database object for Persons
        Select selectDB = new Select();
        Insert insertDB = new Insert();
        Update updateDB = new Update();
        Remove removeDB = new Remove();
        
        // New database object for User
        UserAuth userAuth = new UserAuth();
        
        
        // Adding persons from the DB in a Person type obj list
        List<Person> persons = selectDB.select();
        List<User> users = userAuth.selectUser();
        

        // Iterating user
        for(User usr: users) {
            System.out.println("usr = " + usr);
        }
        
//        // Modify user
//        User user = new User();
//        user.setUsername("Mgarcia43");
//        user.setPassword("miBEBE");
//        user.setId_user(2);
//        userAuth.updateUser(user);
        
//        // Add new user to DB
//        User user = new User();
//        user.setUsername("Mgarcia43");
//        user.setPassword("miAmor1");
//        userAuth.insertUser(user);

//        // Delete user from DB
//        User user = new User();
//        user.setId_user(2);
//        userAuth.removeUser(user);
        

          // Iterating persons
        for(Person pers : persons){
            // Print in the console the person
            System.out.println("pers = " + pers);
        }
        
//        //Creating a new Perosn object
//        Person person = new Person();
//        // Initializing the person attributes
//        person.setName("Pepe");
//        person.setSurname("Gonzalo Garcia");
//        person.setEmail("ppgnzlo@gmail.com");
//        person.setTelephone("642777321");
//        // Insert new person created previous and add to the DB
//        insertDB.insert(person);
        
        
//        //Create a new Preson object
//        Person person = new Person();
//        // Modifing person attributes
//        person.setName("Pepe");
//        person.setSurname("Fernandez");
//        person.setEmail("ppgnzlo@gmail.com");
//        person.setTelephone("642777321");
//        person.setId_person(3);
//        // Update the person object and add to DB
//        updateDB.update(person);
        
        
//        // Create a new person object
//        Person person = new Person();
//        // Specify the person to be deleted by the index(3) in the DB
//        person.setId_person(3);
//        // Removre person from DB
//        removeDB.remove(person);
        
    }
}
