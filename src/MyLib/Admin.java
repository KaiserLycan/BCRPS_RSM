/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

/**
 *
 * @author Joseph Rey
 */
public class Admin extends User{
    private FileManager fmanager;
    
    public Admin(String username, String password) {
        super(username, password);
    }

    public void setFmanager(FileManager fmanager) {
        this.fmanager = fmanager;
    }
    
    
}
