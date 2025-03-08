package RealEstate;

import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
public class Lot {
    private int RealEstateID;
    private int lotNo;
    private float size;
    private float price;
    private String type;
    private String status;
    private IHouse house;
    private ImageIcon lotImage = new ImageIcon("./src/Images/profile.png");
   
    ////////////////////////////////////////////////////////////////////////////

    public int getLotNo() {
        return lotNo;
    }

    public void setLotNo(int lotNo) {
        this.lotNo = lotNo;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IHouse getHouse() {
        return house;
    }

    public void setHouse(IHouse house) {
        this.house = house;
    }

    public int getRealEstateID() {
        return RealEstateID;
    }

    public void setRealEstateID(int RealEstateID) {
        this.RealEstateID = RealEstateID;
    }
    
    

    
}
