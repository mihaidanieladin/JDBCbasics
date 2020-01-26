package Main;

// import sql library
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Connection with sql database
public class Conection {
    
    
    // Define variables to access the DB
    // Conecting to a mySQL database called 'person'
    private static final String SQL_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String SQL_USER = "root";
    private static final String SQL_PASS = "admin";
    
    
    // Connecting to the DB
    public static Connection getConection() throws SQLException{
        
        // Configurate the sql driver and connect the DB passing the variables
        return DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
    }
    
    
    // Close method for ResultSet 
    public static void close(ResultSet result){
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    // Close method for PreparedStatement
    public static void close(PreparedStatement statement){
        try {
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    // Close method for the Connection from the DB
    public static void close(Connection connect){
        try {
            connect.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
