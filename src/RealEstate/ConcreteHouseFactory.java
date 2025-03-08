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
                house = new Bungalow(1000f, "A low house, with a broad front porch, having either no upper floor or upper rooms set in the roof, typically with dormer windows.");
                break;
            case 2: 
                house = new TownHouse(2000f, "A tall, narrow, traditional row house, generally having three or more floors.");
                break;
            case 3: 
                house = new ModernMinimalist(2000f, "Modern minimalist architecture is a design style that emphasizes simplicity, clean lines, open spaces, and a neutral color palette, using high-quality materials with minimal ornamentation.");
                break;
            case 4: 
                house = new Duplex(2000f, "A duplex house plan has two living units attached to each other, either next to each other as townhouses, condominiums or one above the other like apartments");
                break;
            case 5: 
                house = new TwoStory(2000f, "A two story home is a residential building that has two floors. The second floor is usually used for the bedrooms and the ground floor serves as an entrance hall, living room and dining area. ");
                break;        
        }
        return house;
    }
    
}
