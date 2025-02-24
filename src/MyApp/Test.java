 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyApp;
import MyLib.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Joseph Rey
 */
public class Test {
    public static void main(String[] args) {
        Admin master = new Admin("Kaiser", "1234");
        User user;
        Admin admin;
        Client client;
        String username;
        String password;
        
        FileManager usersFile = new FileManager(new File("./src/TextFiles/usersTable.txt"));
        FileManager resFile = new FileManager(new File("./src/TextFiles/reTable.txt"));
        RealEstateManager rem = new RealEstateManager(resFile);
        UserManager um = new UserManager(usersFile);
        
        master.setRem(rem);
        master.setUm(um);
        
        master.viewUsers();
        
        username = "Kaiser";
        password = "_admin123";
        
        user = um.lookUpUser(username, password);
        
        
        if(user == null) {
            System.out.println("User does not exist");
            um.registerUser(username, password);
        }
        else if("ADMIN".equals(user.getType())) {
            admin = um.loginAdmin(username, password);
            admin.setRem(rem);
            admin.setUm(um);
            System.out.println("Login as admin");
        }
        else {
            client = um.loginClient(username, password);
            System.out.println("Login as client");
        }
        
        
    }
} 
