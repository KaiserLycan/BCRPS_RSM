/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Joseph Rey, Andrei, and Busano
 */


public class RealEstate {
    private Long id;
    private String blockNumber;
    private String streetName;
    private float size;
    private float price;
    private String status;
    private Client owner;
    private Invoice invoice;

    ///////////////////////////////////////////////////////////////////////////////////
    // Constructors
    public RealEstate(String blockNumber, String streetName, float size, float prize) {
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.size = size;
        this.price = prize;
    }

    public RealEstate(Long id) {
        this.id = id;
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    // User-defined methods




    ///////////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters

    public Long getId() {
        return id;
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

    public float getPrize() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Client getOwner() {
        return owner;
    }

    public Invoice getInvoice() {
        return invoice;
    }
    

}

