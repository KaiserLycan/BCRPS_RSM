package User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrei Samarita
 */
import RealEstate.Block;
import RealEstate.HouseFactory;
import RealEstate.Lot;
import java.util.ArrayList;
 
public class Admin extends User {
    private FileManager userFm;
    private FileManager reFm;
    private HouseFactory houseFactory;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Block> blocks = new ArrayList<>();
    private Browser browser;

 
    //Constructor
    
    public Admin(String userName, String password) {
        super(userName, password);
        super.setType("admin");
    }
 
    //Methods
    
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    
    public void refreshBlocks() {
        blocks.clear();
        int lotIndex = 0;
        int blockIndex = 0;
        ArrayList<String[]> reData = reFm.extractData();
        
        for(int i = 0; i < reData.size(); i++) {
            if(reData.get(i).equals(reData.getFirst())) {
                continue;
            }
            
            if(blocks.isEmpty()) {
                blocks.add(new Block());
                blocks.get(blockIndex).setBlockNo(Integer.parseInt(reData.get(i)[1]));
                
            }
            else if (blocks.get(blockIndex).getBlockNo() != Integer.parseInt(reData.get(i)[1])) {
                blockIndex++;
                lotIndex = 0;
                blocks.add(new Block());
                blocks.get(blockIndex).setBlockNo(Integer.parseInt(reData.get(i)[1]));
            }
            
            blocks.get(blockIndex).getLots().add(new Lot());
            blocks.get(blockIndex).getLots().get(lotIndex).setRealEstateID(Integer.parseInt(reData.get(i)[0]));
            blocks.get(blockIndex).getLots().get(lotIndex).setLotNo(Integer.parseInt(reData.get(i)[2]));
            blocks.get(blockIndex).getLots().get(lotIndex).setType(reData.get(i)[3]);
            blocks.get(blockIndex).getLots().get(lotIndex).setPrice(Float.parseFloat(reData.get(i)[4]));            
            blocks.get(blockIndex).getLots().get(lotIndex).setSize(Float.parseFloat(reData.get(i)[5]));
            blocks.get(blockIndex).getLots().get(lotIndex).setHouse(houseFactory.buildHouse(Integer.parseInt(reData.get(i)[6])));
            blocks.get(blockIndex).getLots().get(lotIndex).setStatus(reData.get(i)[7]);
            lotIndex++;
        }
    }
    
    public void refreshUsers() {
        ArrayList<String[]> userData = userFm.extractData();
        ArrayList<User> newUserData = new ArrayList<>();
        User user;
        for(String[] row : userData ) {
            if(userData.getFirst().equals(row)) {
                continue;
            }
            
            user = new User(row[1], row[2]);
            user.setId(Integer.parseInt(row[0]));
            user.setType(row[3]);
            newUserData.add(user);
        }
        
        users = newUserData;
    }
    
    public void addLot(int blockNo, Lot newLot) {
        boolean canAdd = true;
        if(!blocks.isEmpty()) {
            for(Block block: blocks) {
                if(block.getBlockNo() == blockNo) {
                    if(block.getLots().size() == 10) 
                        canAdd = false;
                }
            }
        }

        if(canAdd) {
            if(newLot.getLotNo() == 0) {
                newLot.setLotNo(blocks.size() + 1);
            }
            reFm.addData(new String[] {String.valueOf(blockNo + "" + newLot.getLotNo()), String.valueOf(blockNo ), String.valueOf(newLot.getLotNo()), newLot.getType(), String.valueOf(newLot.getPrice()), String.valueOf(newLot.getSize()), String.valueOf(newLot.getHouse().getType()), newLot.getStatus()});            
        }
        refreshBlocks();
    }
   
    public void removeLot(int blockNo, int lotNo) {
        for(Block block : blocks) {
            if(block.getBlockNo() != blockNo) {
                continue;
            }
            
            for(Lot lot: block.getLots()) {
                if(lot.getLotNo() != lotNo) {
                    continue;
                }
                reFm.removeData(lot.getRealEstateID());
                refreshBlocks();
                break;
            }
            break;
        }
    }
    
    public void updateLot(int blockNo, int lotNo, String category, String newData) {
        for(Block block : blocks) {
            if(block.getBlockNo() != blockNo) {
                continue;
            }
            
            for(Lot lot: block.getLots()) {
                if(lot.getLotNo() != lotNo) {
                    continue;
                }
                
                reFm.updateData(Integer.parseInt(blockNo + "" + lotNo), category, newData);
                refreshBlocks();
                break;
            }
            break;
        }
    }
    
    public void addUser(User user) {
        if(user.getId() == 0) {
            user.setId(users.size() + 1); 
        }
        userFm.addData(new String[] {String.valueOf(user.getId()), user.getUserName(), user.getPassword(), user.getType()});
        refreshUsers();        
    }
    
    public void removeuser(int id) {
        userFm.removeData(id);
        refreshUsers();
    }
    
    public void updateUser(int id, String category, String newData) {
        userFm.updateData(id, category, newData);
        refreshUsers();
    }
    
    ///////////////////////////////////////////////////////////////////////
    //// Getters and Setters

    public FileManager getUserFm() {
        return userFm;
    }

    public void setUserFm(FileManager userFm) {
        this.userFm = userFm;
    }

    public FileManager getReFm() {
        return reFm;
    }

    public void setReFm(FileManager reFm) {
        this.reFm = reFm;
    }

    public HouseFactory getHouseFacatory() {
        return houseFactory;
    }

    public void setHouseFacatory(HouseFactory houseFacatory) {
        this.houseFactory = houseFacatory;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
    
    
    
    
}
