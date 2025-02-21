/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author Joseph Rey
 */


// This is a sample class for testing purposes only
public class RealEstate {
    private static int totalRealEstate = 0; 
    private String realEstateID; 
    private int blockNumber;
    private String address;
    private double price;
    private double size;
    
    public RealEstate(int blockNumber, String address, double price, double size) {
        this.blockNumber = blockNumber;
        this.address = address;
        this.price = price;
        this.size = size;
        totalRealEstate++;
        realEstateID = totalRealEstate + "" + blockNumber;
    }
    
    public RealEstate(String id, int blockNumber, String address, double price, double size) {
        this.blockNumber = blockNumber;
        this.address = address;
        this.price = price;
        this.size = size;
        realEstateID = id;
        totalRealEstate++;
    }
    
    public void printInfo() {
        System.out.println( 
            "ID: " + realEstateID + "\n" +
            "Block number: " + blockNumber + "\n" + 
            "Address: " + address + "\n" + 
            "Price: " + String.format("%.2f", price) + "\n" +
            "Size: " + String.format("%.2f", size)
        );
    }
    
    @Override
    public String toString(){
        return realEstateID + "\t\t\t" + blockNumber + "\t\t\t" + address + "\t\t\t"
            + String.format("%.2f", price) + "\t\t\t" + String.format("%.2f", size) + "\n";
    }

    public String getRealEstateID() {
        return realEstateID;
    }
    
    
    
}
