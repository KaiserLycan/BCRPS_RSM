/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph Rey
 */
public class RealEstateManager {
    private ArrayList<RealEstate> listings;
    private FileManager fmanager;
    
    ///////////////////////////////////////////////////////////////////////////
    //Constructor
    
    /**
     * @param fmanager
     */
    public RealEstateManager(FileManager fmanager) {
        this.fmanager = fmanager;
        this.listings = this.retrieveDataFromFile(
                this.fmanager.extractData(true)
        );
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //User-defined methods
    private ArrayList<RealEstate> retrieveDataFromFile(ArrayList<String[]> table) {
        ArrayList<RealEstate> data = new ArrayList<>();
        long id;
        String blockNumber;
        String streetName;
        float price;
        float size;
        String status;
        
        for(String[] row: table) {
            id = Long.parseLong(row[0]);
            blockNumber = row[1];
            streetName = row[2];
            price = Float.parseFloat(row[3]);
            size = Float.parseFloat(row[4]);
            status = row[5];
            
            RealEstate re = new RealEstate(blockNumber, streetName, price);
            re.changeID(id);
            re.setPrice(price);
            re.setStatus(status);
            
            data.add(re);
        }
        
        return data;
    }
    
    public void refreshListings() {
        this.listings = this.retrieveDataFromFile(this.fmanager.extractData(true));
    }
    
    public boolean RealEstateExists(RealEstate re) {
        return this.fmanager.dataExists(re) && this.listings.contains(re);
    }
    
    public void updateRealEstateStatus(Long id, String status) {
        for(RealEstate re : this.listings) {
            if(id == re.getID()) {
                re.setStatus(status.toUpperCase());
                this.fmanager.updateData(re);
            }
        }
    }
    
    public void viewListings() {
        for(RealEstate re : listings) {
            System.out.println(re.getID() + "\t\t\t" + re.toString());
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //Getters and Setters
    FileManager getFmanager() {
        return fmanager;
    }
    
    public ArrayList<RealEstate> getListings() {
        return this.listings;
    }
    
} // end of class RealEstateManager
