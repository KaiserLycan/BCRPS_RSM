package RealEstate;


import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
public class Duplex implements IHouse {
    private float fixedPrice;
    private ImageIcon image = new ImageIcon("./src/Images/house.png");
    private String description;
    private int type = 4;

    ///////////////////////////////////////////////////////////////////////////
    ///Constructor
    
    public Duplex(float fixedPrice, String description) {
        this.fixedPrice = fixedPrice;
        this.description = description;
    }

    //////////////////////////////////////////////////////////////////////////
    ///Getter
    

    public ImageIcon getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public float getHousePrice() {
        return fixedPrice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
