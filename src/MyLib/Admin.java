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
    private RealEstateManager rem;
    private UserManager um;
    
    ////////////////////////////////////////////////////////////////////////////
    //Constructors
    /**
     * @param username
     * @param password
     */
    public Admin(String username, String password) {
        super(username, password);
        super.type = "ADMIN";
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //User-Defined Methods
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
    
    ///////////////////////////////////////////////////////////////////////////
    //Getters and Setters

    public void setRem(RealEstateManager rem) {
        this.rem = rem;
    }
    
    public void setUm(UserManager um) {
        this.um = um;
    }
    
    
    
}
