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
    private float price;

    public RealEstate(String blockNumber, String streetName, float size, float price) {
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.size = size;
        this.price = price;
        this.id = this.generateID();
    }
    
    public RealEstate(long id, String blockNumber, String streetName, float size, float price) {
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.size = size;
        this.price = price;
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
        return id + "\t\t\t" + blockNumber + "\t\t\t" + streetName + "\t\t\t" + size + "\t\t\t" + price;
    }

    @Override
    public long getID() {
        return id;
    }
    
    
    
}
