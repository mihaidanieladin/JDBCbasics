package Main;

import DB.Insert;
import DB.Remove;
import DB.Select;
import DB.Update;
import java.util.Scanner;
import DB.UserAuth;
import java.util.ArrayList;
import java.util.List;

public class Command {
    
    public static void startCommand(){
         
        try{
            Scanner sc = new Scanner(System.in);
            
            UserAuth userDB = new UserAuth();
            System.out.println("Welcome to the JDBC app");
            System.out.println("Choose and option to perform: \n"
                    + "1.User \n"
                    + "2.Person");
            
            int option = sc.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Choose user options: \n"
                            + "1.Get users \n"
                            + "2.Insert user \n"
                            + "3.Update user \n"
                            + "4.Delete user");
                    int inputUser = sc.nextInt();
                    switch(inputUser){
                        case 1:
                            getUsers();
                            newOp();
                            break;
                        case 2:
                            addUser();
                            newOp();
                            break;
                        case 3:
                            updateUser();
                            newOp();
                            break;
                        case 4:
                            deleteUser();
                            newOp();
                            break;
                        default:
                            startCommand();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Choose person options: \n"
                            + "1.Get persons \n"
                            + "2.Insert person \n"
                            + "3.Update person \n"
                            + "4.Delete person");
                    int inputPerson = sc.nextInt();
                    switch(inputPerson){
                        case 1:
                            getPersons();
                            newOp();
                            break;
                        case 2:
                            addPerson();
                            newOp();
                            break;
                        case 3:
                            updatePerson();
                            newOp();
                            break;
                        case 4:
                            deletePerson();
                            newOp();
                            break;
                        default:
                            startCommand();
                            break;
                    }
            }
            
        } catch(Error err){
            System.out.print(err);
        }
    }
    
    public static void newOp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("New operation? y/n");
        String r = sc.nextLine();
        switch(r) {
            case "y":
                startCommand();
                break;
            case "n":
                System.exit(0);
            default:
                newOp();
        }
        
    }
    
    public static void getUsers(){
        UserAuth userDB = new UserAuth();
        List<User> users = new ArrayList<User>();
        users = userDB.selectUser();
        for(User usr: users) {
            System.out.println("usr = " + usr);
        }
    }
    
    public static void addUser(){
        Scanner sc = new Scanner(System.in);
        UserAuth userDB = new UserAuth();
        User user = new User();
        
        System.out.println("New user name:");
        String username = sc.nextLine();
        
        System.out.println("New password:");
        String password = sc.nextLine();
        
        user.setPassword(password);
        user.setUsername(username);
        
        userDB.insertUser(user);
        System.out.println("New user sucessfuly added to DB!");
    }
    
    public static void updateUser(){
        Scanner sc = new Scanner(System.in);
        UserAuth userDB = new UserAuth();
        User user = new User();
        
        System.out.println("Id user's to update:");
        int id_user = sc.nextInt();
        System.out.println("New user name:");
        String username = sc.nextLine();
        System.out.println("New password:");
        String password = sc.nextLine();
        
        user.setPassword(password);
        user.setUsername(username);
        user.setId_user(id_user);
        
        userDB.updateUser(user);
        System.out.println("User sucessfuly updated!");
        
    }
    
    public static void deleteUser(){
        Scanner sc = new Scanner(System.in);
        UserAuth userDB = new UserAuth();
        User user = new User();
        
        System.out.println("User id to delete:");
        int id_user = sc.nextInt();
        user.setId_user(id_user);
        
        userDB.removeUser(user);
        System.out.println("User sucessfuly deleted!");
    }

    private static void getPersons() {
        List<Person> persons = new ArrayList<Person>();
        Select selectDB = new Select();
        persons = selectDB.select();
                
        for(Person pers: persons) {
            System.out.println("Person: " + pers);
        }
    }

    private static void addPerson() {
        Scanner sc = new Scanner(System.in);
        Insert insertDB = new Insert();
        Person person = new Person();
        
        System.out.println("New person name:");
        String username = sc.nextLine();

        System.out.println("New password:");
        String surname = sc.nextLine();

        System.out.println("New email:");
        String email = sc.nextLine();

        System.out.println("New Telephone:");
        String telephone = sc.nextLine();
        
        
        person.setName(username);
        person.setSurname(surname);
        person.setEmail(email);
        person.setTelephone(telephone);
        
        insertDB.insert(person);
        System.out.println("New user sucessfuly added to DB!");
    }

    private static void updatePerson() {
        Scanner sc = new Scanner(System.in);
        Update updateDB = new Update();
        Person person = new Person();
        
        System.out.println("Person id to update:");
        int id_person = sc.nextInt();
        
        System.out.println("New person name:");
        String username = sc.next();

        System.out.println("New password:");
        String surname = sc.next();

        System.out.println("New email:");
        String email = sc.next();

        System.out.println("New Telephone:");
        String telephone = sc.next();
        
        
        person.setName(username);
        person.setSurname(surname);
        person.setEmail(email);
        person.setTelephone(telephone);
        person.setId_person(id_person);
        
        updateDB.update(person);
        System.out.println("New person sucessfuly updated to DB!");
    }

    private static void deletePerson() {
        Scanner sc = new Scanner(System.in);
        Remove removeDB = new Remove();
        Person person = new Person();
        
        System.out.println("Person id to delete:");
        int id_person = sc.nextInt();
        person.setId_person(id_person);
        
        removeDB.remove(person);
        System.out.println("New person sucessfuly deleted from DB!");
    }
   
}
