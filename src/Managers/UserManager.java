package Managers;

import MyLibs.Admin;
import MyLibs.Client;
import MyLibs.User;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joseph Rey
 */
public class UserManager {
    private ArrayList<User> users;
    private ArrayList<Client> clients;
    private FileManager fmanager;
    
    ///////////////////////////////////////////////////////////////////////////
    //Constructors
    public UserManager (FileManager fmanager) {
        this.fmanager = fmanager;
        this.users = this.retrieveDataFromFile(this.fmanager.extractData(true));
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //User-defnied methods
    private ArrayList<User> retrieveDataFromFile(ArrayList<String[]> table) {
        ArrayList<User> datas = new ArrayList<User>();
        User user;
        long contentID = 0L;
        for(String[] row : table) {
            
            try{
                contentID = Long.parseLong(row[0]);
            }
            catch(NumberFormatException ex) {
                ex.printStackTrace();
            }
            
            user = new User(row[1], row[2], "USER");
            user.setId(contentID);
            datas.add(user);
        }
        
        return datas;
    }
    
    public Admin loginAdmin(String username, String password) {
        Admin admin = null;
        
        for(User user : users) {
            if(!"ADMIN".equals(user.getType() )) {
                continue;
            }
            
            if(user.verifyLogin(username, password)) {
                admin = new Admin(user.getUsername(), user.getPassword());
                admin.setId(user.getId());
                break;
            }
        }
        
        return admin;
    }
    
    public Client loginClient(String username, String password) {
        Client cl = null;
        
        for(User user : users) {

          if("CLIENT".equals(user.getType() )) {
              continue;
          }

          if(user.verifyLogin(username, password)) {
              cl = new Client(user.getUsername(), user.getPassword());
              //TODO: Retrieve client information
              cl.setId(user.getId());
              break;
          }
      }

      return cl;
    }
    
    public User lookUpUser(String username, String password) {
        User user = null;
        
        if(this.userExist(new User(username, password, "USER"))) {
            for(User xuser : users) {
                if(xuser.verifyLogin(username, password)) {
                    user = xuser;
                    break;
                }
            }
        }
        
        return user;
    }
    
    
    public boolean registerUser(String username, String password, Admin admin, String confirmPassword) {
        Admin newAdmin = new Admin(username, password);
        boolean status = false;
        
        if(!userExist(newAdmin) && admin.getPassword().equals(confirmPassword)) {   
            fmanager.addData(newAdmin);
            refreshUsers();
            status = true;
        }
        
        return status;
    }
    
    public boolean registerUser(String username, String password) {
        Client cl = new Client(username, password);
        
        if(userExist(cl)) {
            return false;
        }
        else {
            fmanager.addData(cl);
            refreshUsers();
            return true;
        }
        
    }
    
    public boolean userExist(User user) {
        boolean exists = false;
        
        if(fmanager.dataExists(user)) {
            exists = true;
        }
        else {
            for(User xuser : users) {
                if(xuser.getUsername().equals(user.getUsername())) {
                    exists = true;
                }
            }
        }
        
        return exists;
    }
    
    public void refreshUsers () {
        this.users = this.retrieveDataFromFile(fmanager.extractData(true));
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Getters and Setters
    
    public ArrayList<User> getUsers() {
        return this.users;
    }

    public FileManager getFmanager() {
        return fmanager;
    }
    
}
