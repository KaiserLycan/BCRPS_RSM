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
    private Admin ad;
    private User user;

    public Login(Admin admin) {
        this.ad = admin;
    }

    public User login(String username, String password) {
        for(User xuser : ad.getUsers()) {
            if(xuser.verifyLogin(username, password)) {
                user = xuser;
            }
        }
        
        return user;
    } 
}
