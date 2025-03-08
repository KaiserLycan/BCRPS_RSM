/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealEstate;

/**
 *
 * @author Joseph Rey
 */
public abstract class HouseFactory {
    protected abstract IHouse createHouse(int type);
    
    public IHouse buildHouse(int type) {
        return createHouse(type);
    }
}
