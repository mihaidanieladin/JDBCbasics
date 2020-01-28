package Main;

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
                            break;
                        case 2:
                            addUser();
                            break;
                        case 3:
                            updateUser();
                            break;
                        case 4:
                            deleteUser();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Choose person options: \n"
                            + "1.Get persons \n"
                            + "2.Insert person \n"
                            + "3.Update person \n"
                            + "4.Delete person");
                    switch(option){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
            }
            
        } catch(Error err){
            System.out.print(err);
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
        user.setUsername(username.toString());
        
        System.out.println("New password:");
        String password = sc.nextLine();
        user.setPassword(password.toString());
        
        userDB.insertUser(user);
        System.out.println("New user sucessfuly added to DB!");
    }
    
    public static void updateUser(){
        Scanner sc = new Scanner(System.in);
        UserAuth userDB = new UserAuth();
        User user = new User();
        
        System.out.println("Id user's to update:");
        int id_user = sc.nextInt();
        System.out.println("usrID = " + id_user);
        System.out.println("New user name:");
        String username = sc.next();
        System.out.println("username = " + username);
        System.out.println("New password:");
        String password = sc.next();
        System.out.println("password = " + password);
        
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
}
