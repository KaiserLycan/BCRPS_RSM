package Database;


import Admin.Admin;
import Admin.RealEstate;
import Admin.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joseph Rey
 */
public class FileManager {
    File file;
    FileWriter writer = null;
    Scanner sc = null;
    String [] column;
    boolean firstTime;
    
    //Creates a new file into the Database folder.
    //If the file already exist or an problem occured an error msg will pop out
    //Else the file will be created.
    public void createNewFile(String fileName) {
        file = new File("./src/Database/" + fileName + ".txt");
        
        try {
            if(file.createNewFile()) {
                System.out.println("File " + fileName + " has been successfully"
                        + " created.");
            }
            else {
                throw(new IOException("File Already Exist"));
            }
        }
        catch (IOException ex) {
            System.out.println("Error: Cannot create file " + fileName + " "
                    + " the file name may have invalid symbols in it or"
                    + "it already exist");
        }
    }
    
    //Deletes the existing files
    public void deleteFile(String fileName) {
        file = new File("./src/Database/" + fileName + ".txt");
        if(file.exists()) {
            file.delete();
            System.out.println("File " + fileName + " has been deleted");
        }
        else {
            System.out.println("Error: Cannot delete non-existing files");
        }
    }
    
    public ArrayList<User> extractUsersData(String fileName) {
        ArrayList<User> users = new ArrayList<User>();
        file = new File("./src/Database/" + fileName + ".txt");
        firstTime = true;
        
        try {
            sc = new Scanner(file);
        }
        catch(IOException ex) {
            System.out.println("Error: Cannot Extract data from non-existing files");
            return null;
        }
        
        while(sc.hasNextLine()) {
            if(firstTime) {
                sc.nextLine();
                firstTime = false;
                continue;
            }

            column = sc.nextLine().split("\\t*\\s");
            if(column[2].equals("ADMIN")) {
                users.add(new Admin(column[0], column[1]));
            }
            else {
                users.add(new User(column[0], column[1]));
            }

        }   
        return users;
    }
    
    public void addUserData(String fileName, User user) {
        file = new File("./src/Database/" + fileName + ".txt");
        
        try {
            writer = new FileWriter(file, true);
            writer.append(user.toString());
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Error: cannot add data to non-existing files");
        }
    }
    
    public void removeUserData(String fileName, User user) {
        ArrayList<String[]> table = new ArrayList<String[]>();
        file = new File("./src/Database/" + fileName + ".txt");
        firstTime = true;
        String[] itemToRemove = null;
        
        try {
            sc = new Scanner(file);
        }
        catch( IOException e) {
            System.out.println("Error cannot remove data from a non-exisitng file.");
        }
        
        while(sc.hasNextLine()) {
            table.add(sc.nextLine().split("\\s\\t*"));
        }
        
        for(String[] row : table) {
            if(firstTime) {
                firstTime = false;
                continue;
            }
            
            if(row[0].equals(user.getName()) && row[1].equals(user.getPassword())) {
                itemToRemove = row;
            }
        }
        
        if(table.remove(itemToRemove)) {
            try {
                writer = new FileWriter(file);
                for(String[] row: table) {
                    writer.append(String.join("\t\t\t", row) + "\n");
                }
                writer.close();
            }
            catch(IOException ex) {
                System.out.println("Error: Cannot Delete data from the file");
            }
        }
        else {
            System.out.println("Cannot Remove Data with ID of " + user.getName() + " as it does not exist in the database");
        }
        
    }
    
    public ArrayList<RealEstate> extractRealEstateData(String fileName) {
        ArrayList<RealEstate> realestates = new ArrayList<RealEstate>();
        file = new File("./src/Database/" + fileName + ".txt");
        firstTime = true;
        
        try {
            sc = new Scanner(file);
        }
        catch(IOException ex) {
            System.out.println("Error: cannot extract data from non-existing file.");
            return null;
        }
        
        while(sc.hasNextLine()) {
            if(firstTime) {
                firstTime = false;
                sc.nextLine();
                continue;
            }
            
            column = sc.nextLine().split("\\s\\t*");
            realestates.add(new RealEstate(column[0], Integer.parseInt(column[1]), column[2], Double.parseDouble(column[3]), Double.parseDouble(column[4])));
            
        }
        
        return realestates;
    }
    
    public void addRealEstateData(String fileName, RealEstate realestate) {
        file = new File("./src/Database/" + fileName + ".txt");
        
        try {
            writer = new FileWriter(file, true);
            writer.append(realestate.toString());
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Error: cannot add data to non-existing files");
        }
    }
    
    public void removeRealEstateData(String fileName, String id) {
        ArrayList<String[]> table = new ArrayList<String[]>();
        file = new File("./src/Database/" + fileName + ".txt");
        firstTime = true;
        String[] itemToRemove = null;
        
        try {
            sc = new Scanner(file);
        }
        catch( IOException e) {
            System.out.println("Error cannot remove data from a non-exisitng file.");
        }
        
        while(sc.hasNextLine()) {
            table.add(sc.nextLine().split("\\s\\t*"));
        }
        
        for(String[] row : table) {
            if(firstTime) {
                firstTime = false;
                continue;
            }
            
            if(row[0].equals(id)) {
                itemToRemove = row;
            }
        }
        
        if(table.remove(itemToRemove)) {
            try {
                writer = new FileWriter(file);
                for(String[] row: table) {
                    writer.append(String.join("\t\t\t", row) + "\n");
                }
                writer.close();
            }
            catch(IOException ex) {
                System.out.println("Error: Cannot Delete data from the file");
            }
        }
        else {
            System.out.println("Cannot Remove Data with ID of " + id + " as it does not exist");
        }
        
        
    }
    
}
