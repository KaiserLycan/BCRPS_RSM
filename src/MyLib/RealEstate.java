/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLib;

import java.util.Date;

/**
 *
 * @author Joseph Rey
 */
public class RealEstate implements IGenerateID{
     private long id;
    private String blockNumber;
    private String streetName;
    private float size;
    private float price = 0f;
    private String status = "AVAILABLE";

    public RealEstate(String blockNumber, String streetName, float size) {
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.size = size;
        this.id = this.generateID();
    }
    
    public RealEstate(long id) {
        this.id = id;
    }
    
    public void changeID(Long id) {
        this.id = id;
    }

    @Override
    public long generateID() {
        Date date = new Date();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        return Long.parseLong(day + "" + month + "" + year + "" + hours + "" + minutes + "" + seconds);
    }
    
    @Override
    public String toString() {
        return blockNumber + "\t\t\t" + streetName + "\t\t\t" + String.format("%.2f", size) + "\t\t\t" + String.format("%.2f", price) + "\t\t\t" + status;
    }

    @Override
    public long getID() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public float getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    
    
    
}
