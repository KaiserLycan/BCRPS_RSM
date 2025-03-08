/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author Joseph Rey
 */
public class Login {
    
    public User login(String username, String password) {
        Admin ad = new Admin("master", "234");
        User user = null;
        
        for(User xuser : ad.getUsers()) {
            if(user.verifyLogin(username, password)) {
                user = xuser;
            }
        }
        
        return user;
    } 
}
