/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import Database.FileManager;
import java.util.ArrayList;
/**
 *
 * @author Joseph Rey
 */
public class Admin extends User{
    private ArrayList<RealEstate> listing = new ArrayList<RealEstate>();
    private FileManager fmanager;

    public Admin(String name, String password) {
        super(name, password);
        super.type = "ADMIN";
    }
    
    public void retrieveRestateData(String fileName) {
        listing = fmanager.extractRealEstateData(fileName);
    }
    
    // adds Real Estate to the array list 
    public void addRealEstate(RealEstate newRealEstate) {
        listing.add(newRealEstate);
        fmanager.addRealEstateData("realEstateTable", newRealEstate);
        System.out.println("Sucessfully Added Real Estate to the Database!");
    }
    
    // Removes the real Esate from the array List
    public void deleteRealEstate(RealEstate realEstate) {
        if(this.listing.contains(realEstate)) {
            this.fmanager.removeRealEstateData("realestateTable", realEstate.getRealEstateID());
            this.listing.remove(realEstate);
            System.out.println("Successfully Removed Real Estate!");
        }
        else {
            System.out.println("Error! Real Estate Does not Exist in the Database.");
        }
    }

    // Getters and Setters
    public ArrayList<RealEstate> getListing() {
        return listing;
    }

    public void setFmanager(FileManager fmanager) {
        this.fmanager = fmanager;
    }
    
    
}
