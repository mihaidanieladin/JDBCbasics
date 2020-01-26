package DB;

// SQL CRUD methods

public class Database {
    
    // Defining SQL statements
    protected static String SQL_SELECT = "SELECT id_person, name, surname, email, telephone FROM person";
    
    protected static String SQL_INSERT = "INSERT INTO person(name, surname, email, telephone) VALUES(?,?,?,?)";
    
    protected static String SQL_UPDATE = "UPDATE person GET nombre=?, name=?, surname=?, telephone=? WHERE id_person=?";
    
    protected static String SQL_DELETE = "DELETE FROM person WHERE id_person";
    
}
