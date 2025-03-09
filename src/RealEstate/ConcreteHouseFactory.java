/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealEstate;

/**
 *
 * @author Joseph Rey
 */
public class ConcreteHouseFactory extends HouseFactory {

    @Override
    protected IHouse createHouse(int type) {
        IHouse house = null;
        switch(type) {
                case 1:
                    house = new Bungalow(1000f, "A low, wide house with a porch and dormer windows, usually single-story.");
                    break;
                case 2: 
                    house = new TownHouse(2000f, "A tall, narrow row house with three or more floors.");
                    break;
                case 3: 
                    house = new ModernMinimalist(2000f, "A sleek design with clean lines, open spaces, and a neutral palette.");
                    break;
                case 4: 
                    house = new Duplex(2000f, "A two-unit home, side by side or stacked like apartments.");
                    break;
                case 5: 
                    house = new TwoStory(2000f, "A home with two floors, bedrooms upstairs, and living spaces below.");
                    break;        
        }
        return house;
    }
    
}
