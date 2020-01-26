package DB;


import Main.Conection;
import Main.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends Database{
    
    
    // Update method for modifyng a Person object in the DB
    public int update(Person person) {
        // Declarate Connection variables
        Connection connect = null;
        PreparedStatement statement = null;
        
        // Initializing a rows variable to keep trak of the modifyed objects
        int rows = 0;
        
        // Error handling try catch
        try {
            // Connecting to the DB driver
            connect = Conection.getConection();
            // Adding the prepared statement for update
            statement = connect.prepareStatement(SQL_UPDATE);
            // Pirnt to console the statement
            System.out.println("Executing query: " + SQL_UPDATE);
            
            // Updating person given as argument and apply setting in the statement
            statement.setString(1,person.getName());
            statement.setString(2, person.getSurname());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getTelephone());
            statement.setInt(5, person.getId_person());
            
            // Storing the registys that have been updated to the DB
            rows = statement.executeUpdate();
            // Print to console the regysters updated to the DB
            System.out.println("Persons actualized in the DB: " + rows);
            
        } catch(SQLException ex) {
            // If error catch and print to console
            ex.printStackTrace(System.out);
        } finally {
            // Closing the statement and connect connections from DB
            Conection.close(statement);
            Conection.close(connect);
        }
        // Return the modifyed persons from DB
        return rows;
    }
}
