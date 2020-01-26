package DB;


import Main.Person;
import Main.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert extends Database{
    
    
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
