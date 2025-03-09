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
public class TownHouse implements IHouse {
    private float fixedPrice;
    private ImageIcon image = new ImageIcon("./src/Images/TownHouse.png");
    private String description;
    private int type = 2;

    ///////////////////////////////////////////////////////////////////////////
    ////Constructor
    public TownHouse(float fixedPrice, String description) {
        this.fixedPrice = fixedPrice;
        this.description = description;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    ///Getter

    public String getDescription() {
        return description;
    }

    @Override
    public float getHousePrice() {
        return fixedPrice;
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
