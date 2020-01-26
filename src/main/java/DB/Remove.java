package DB;

import Main.Conection;
import Main.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remove extends Database {
    
    public int remove(Person person){
        
        // Connect to driver DB
        Connection connect = null;
        PreparedStatement statement = null;
        // Store deleted persons
        int rows = 0;
        
        // Error handling try catch
        try {
            
            // Connect to DB
            connect = Conection.getConection();
            // Add a prepared statement to delte persons fomr DB
            statement = connect.prepareStatement(SQL_DELETE);
            // Print to console the statement
            System.out.println("Executing query: " + SQL_DELETE);
            
            // Deleting the person by id
            statement.setInt(1, person.getId_person());
            //Store the deleted registers
            rows = statement.executeUpdate();
            System.out.println("Deleted registers: " + rows);
            
        } catch(SQLException ex){
            // If error print to console
            ex.printStackTrace(System.out);
        } finally {
            // Close statement and connect connection from DB
            Conection.close(statement);
            Conection.close(connect);
        }
        // return registers deleted from DB
        return rows;
    }
}
