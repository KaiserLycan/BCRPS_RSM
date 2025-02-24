/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package realestate;

/**
 *
 * @author Joseph Rey
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

    public RealEstate(String blockNumber, String streetName, float size, float prize) {
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.size = size;
        this.price = prize;
    }

    public RealEstate(Long id) {
        this.id = id;
    }

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

