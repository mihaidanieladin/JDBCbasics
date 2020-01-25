
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mihai Daniel Adin
 * 
 * This are the Java Database conection JDBC basics
 */
public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        List<Person> persons = db.select();
        
        for(Person pers : persons){
            System.out.println("pers = " + pers);
        }
    }
}
