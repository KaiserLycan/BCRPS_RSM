/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Andrei Samarita and Busano
 */
public class Admin extends User{
    private UserManager um;
    private RealEstateManager rem;

    //////////////////////////////////////////////////////////////////
    /// Constructors
    public Admin(String username, String password) {
        super(username, password, ADMIN);
    }


    ////////////////////////////////////////////////////////////////
    /// User defined functoins
    public void addRealEsate(RealEstate re) {
        rem.getFmanager().addData(re);
        rem.refreshListings();
    }
    
    public void deleteRealEstate(RealEstate re) {
        rem.getFmanager().removeData(re);
        rem.refreshListings();
    }
    
    public void changRealEstatePrice(long id, float price) {
        for(RealEstate re : rem.getListings()) {
            if(re.getID() == id) {
                re.setPrice(price);
            }
        }
    }
    
    public void viewUsers() {
        for(User user : um.getUsers()) {
            System.out.println( user.getID() + "\t\t\t" + user.toString());
        }
    }
    
    public void registerNewAdmin(String username, String password, String confirmPassword) {
        um.registerUser(username, password, this, confirmPassword);
    }
    

    ///////////////////////////////////////////////////////////////////////////////////////
    /// Getters and Setters
    
}
