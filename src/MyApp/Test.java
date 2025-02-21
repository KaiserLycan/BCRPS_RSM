/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyApp;
import MyLib.*;

/**
 *
 * @author Joseph Rey
 */
public class Test {
    public static void main(String[] args) {
        FileManager fmanager = new FileManager();
        fmanager.openFile("reTable");
        fmanager.removeData(new RealEstate(6112565634L,"1B", "McArthur", 304f, 209f));
        
    }
}
