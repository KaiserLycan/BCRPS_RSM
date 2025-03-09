
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package RealEstate;

import javax.swing.ImageIcon;

/**
 *
 * @author Andrei Samarita
 */

public class Bungalow implements IHouse {
    private float fixedPrice;
    private String description;
    private int type = 1;
    private ImageIcon image = new ImageIcon("./src/Images/bungalow.jpg");

    
    ///////////////////////////////////////////////////////////////////////////
    /// Constructor
    public Bungalow(float fixedPrice, String description) {
        this.fixedPrice = fixedPrice;
        this.description = description;
    }
 
    /////////////////////////////////////////////////////////////////////////
    ///User defined method
    
    @Override
    public float getHousePrice() {
        return fixedPrice;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
    
    @Override
    public ImageIcon getHouseImage() {
        return image;
    }
    
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
