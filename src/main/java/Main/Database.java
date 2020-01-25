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
    private static String SQL_DELETE = "DELETE FROM persona WHERE id_person";
    
    Database(){
        
    }
    
    public List<Person> select(){
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Person persona = null;
        List<Person> persons = new ArrayList<Person>();
        
        try{
            connect = Conection.getConnection();
            statement = connect.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id_persona = resultSet.getInt("id_person");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String telephone = resultSet.getString("telephone");
                
                Person person = new Person();
                person.setId_person(id_persona);
                person.setName(name);
                person.setSurname(surname);
                person.setEmail(email);
                person.setTelephone(telephone);
                
                persons.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conection.close(resultSet);
            Conection.close(statement);
            Conection.close(connect);
        }
        return persons;
    }
}