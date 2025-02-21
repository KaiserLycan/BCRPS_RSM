/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author Joseph Rey
 */
public class User {
    private String name;
    private String password;
    protected String type = "USER";
    
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public boolean verifyLogin(String inputName, String inputPassword) {
        return name.equals(inputName) && password.equals(inputPassword);
    }
    
    public void printInfo() {
        System.out.println("Name: " + name + "\t\t" + "Password: " + password);
    }
    
    @Override
    public String toString() {
        return name + "\t\t\t" + password + "\t\t\t" + type + "\n";
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    
}
