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
            
            user = new User(row[1], row[2], row[3]);
            user.setId(contentID);
            datas.add(user);
        }
        
        return datas;
    }
    
    public User LoginUser(String username, String password) {
        User user = null;
        
        for(User xuser : users) {
            if(xuser.verifyLogin(username, password)) {
                user = xuser;
                break;
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
