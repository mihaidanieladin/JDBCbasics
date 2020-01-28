package DB;

import Main.Conection;
import Main.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAuth {
    // Defining SQL statements
    private static final String SQL_SELECT = "SELECT id_user, username, password FROM user";
    
    private static final String SQL_INSERT = "INSERT INTO user(username, password) VALUES(?,?)";
    
    private static final String SQL_UPDATE = "UPDATE user SET username=?, password=? WHERE id_user=?";
    
    private static final String SQL_DELETE = "DELETE FROM user WHERE id_user=?";
    
    int rows = 0;
  
    List<User> users = new ArrayList<User>();
    
    public int insertUser(User user){
        Connection connect = null;
        PreparedStatement statement = null;
        try {
            connect = Conection.getConection();
            statement = connect.prepareStatement(SQL_INSERT);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            
            System.out.println("Executing query: " + SQL_INSERT);
            rows = statement.executeUpdate();
            System.out.println("Users registred! " + rows);
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conection.close(statement);
            Conection.close(connect);
        }
        return rows;
    }
    
    public List<User> selectUser(){
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            connect = Conection.getConection();
            statement = connect.prepareStatement(SQL_SELECT);
            System.out.println("Executing query: " +SQL_SELECT);
            result = statement.executeQuery();
            User usr = null;
            
            while(result.next()){
                int id_user = result.getInt("id_user");
                String username = result.getString("username");
                String password = result.getString("password");

                usr = new User();
                usr.setId_user(id_user);
                usr.setUsername(username);
                usr.setPassword(password);

                users.add(usr);

                System.out.println("Users selected: " + usr.toString()); 
            }
  
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            Conection.close(result);
            Conection.close(statement);
            Conection.close(connect);
        }
        return users;
    }
    
    public int updateUser(User user){
        Connection connect = null;
        PreparedStatement statement = null;
        int rows = 0;
        
        try {
            connect = Conection.getConection();
            statement = connect.prepareStatement(SQL_UPDATE);
            System.out.println("Executing query:  " + SQL_UPDATE);
            
            statement.setString(1, user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setInt(3, user.getId_user());
            
            rows = statement.executeUpdate();
            System.out.println("Registrys updated: " + rows);
            
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            Conection.close(statement);
            Conection.close(connect);
        }
        return rows;
    } 
    
    public int removeUser(User user) {
        Connection connect = null;
        PreparedStatement statement = null;
        try {
            connect = Conection.getConection();
            statement = connect.prepareStatement(SQL_DELETE);
            System.out.println("Executing query:  " + SQL_DELETE);
            
            statement.setInt(1, user.getId_user());
            
            rows = statement.executeUpdate();
            System.out.println("Deleted users: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conection.close(statement);
            Conection.close(connect);
        }
        return rows;
    }
}
