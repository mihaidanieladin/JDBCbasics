package Main;

// SQL CRUD methods

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    
    // Defining SQL statements attributes
    private static String SQL_SELECT = "SELECT id_person, name, surname, email, telephone FROM person";
    private static String SQL_INSERT = "INSERT INTO person(name, surname, email, telephone) VALUES(?,?,?,?)";
    private static String SQL_UPDATE = "UPDATE person GET nombre=?, name=?, surname=?, telephone=? WHERE id_person=?";
    private static String SQL_DELETE = "DELETE FROM person WHERE id_person";
    
    Database(){
    }
    
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
            resultSet = statement.executeQuery();
            // Creating new person from DB into local
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
    
    // Insert Person to the DB and return how many registers have been modified in var rows
    // Taking a Person type object as a parameters for inserting to the DB
    public int insert(Person person){
        // Declaring connection attributes
        Connection connect = null;
        PreparedStatement statement = null;
        // Initializing rows variables to return a registry modifyers when method is called
        int rows = 0;
        // Error handling try and catch
        try {
            // Connecting to the DB driver
            connect = Conection.getConection();
            // Adding the prepared statement for insert
            statement = connect.prepareStatement(SQL_INSERT);
            // Setting the statement with the person given as a argument
            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getTelephone()); 
            // Print to console the insertion
            System.out.println("Executing query " + SQL_INSERT);
            // Store the insertion registrys into rows variable
            rows = statement.executeUpdate();
            // Pirnt how many registrys have been inserted
            System.out.println("Registry afected: " + rows);
            
        } catch(SQLException ex) {
            // If error print to console
            ex.printStackTrace(System.out);
        } finally {
            // Closing the statement and connect conectrions
            Conection.close(statement);
            Conection.close(connect);
        }
        // return the number of registrys inserted into DB
        return rows;
    }
}
