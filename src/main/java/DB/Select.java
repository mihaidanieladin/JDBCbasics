package DB;

import Main.Conection;
import Main.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select extends Database {
    
    // Select method to recive an Person type obj from DB and return as a list array
    public List<Person> select(){
        
        
        // Declarate connection attributes with null values
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        
        // Declarate new Person type object
        Person person = null;
        // New Person array list type where each person from DB is hosted
        List<Person> persons = new ArrayList<Person>();
        
        // Error handling try and catch
        try{
            // Conecting to the driver DB
            connect = Conection.getConection();
            // Adding a prepared statement to the conection
            statement = connect.prepareStatement(SQL_SELECT);
            // Executing the statement and storing the return objects from DB
            // Pirnt to console the statement
            System.out.println("Executing query: " + SQL_SELECT);
            // Store the selected registers
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                // Store returned values from DB into local variables
                int id_person = resultSet.getInt("id_person");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String telephone = resultSet.getString("telephone");
                
                
                // Creating a new Person object and add the stored values to the obj
                person = new Person();
                person.setId_person(id_person);
                person.setName(name);
                person.setSurname(surname);
                person.setEmail(email);
                person.setTelephone(telephone);
                
                
                // Add person to the local array list
                persons.add(person);
            }
        } catch (SQLException ex) {
            // If error catch and print to console
            ex.printStackTrace(System.out);
        } finally {
            // Last step closing the result, statement and connect connections from DB
            Conection.close(resultSet);
            Conection.close(statement);
            Conection.close(connect);
        }
        // Return the persons array list when the method is called
        return persons;
    }
}
