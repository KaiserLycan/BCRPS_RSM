/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Joseph Rey, Andrei, and Busano
 */


public class RealEstate implements IGenerateID {
    private Long id;
    private String blockNumber;
    private int lotNumber;
    private float size;
    private float price;
    private String status;
    private Client owner;
    private Invoice invoice;

    ///////////////////////////////////////////////////////////////////////////////////
    // Constructors
    public RealEstate(String blockNumber, int lotNumber, float size, float price) {
        this.blockNumber = blockNumber;
        this.lotNumber = lotNumber;
        this.size = size;
        this.price = price;
    }

    public RealEstate(Long id) {
        this.id = id;
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    // User-defined methods

    
    @Override
    public long generateId() {
        return 0l;
    }
    


    ///////////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters

    @Override
    public long getId() {
        return id;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public float getSize() {
        return size;
    }

    public float getPrice() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    


}

