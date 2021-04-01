/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend;

import controller.DB;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achcha
 */
public class Inventory {
    static HashMap<String, HashMap<Integer, HashMap<String, Item>>> searchMap = new HashMap<String, HashMap<Integer, HashMap<String, Item>>>();
    static HashMap<Integer, Item> itemsList = new HashMap<Integer, Item>();
    static HashMap<Integer, Manufacturer> manufacturersList = new HashMap<Integer, Manufacturer>();
    static LocalDate currentDate;
    
    public void retrieveData(){
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * FROM owner");
            rs = ps.executeQuery();
            rs.next();
            Inventory.currentDate = rs.getDate("current_date").toLocalDate();
            
            ps = con.prepareStatement("SELECT * FROM manufacturers");
            rs = ps.executeQuery();
            while(rs.next()) {
                int uID = rs.getInt("manufacturer_uid");
                String name = rs.getString("name");
                String address = rs.getString("address");
                int itemCount = rs.getInt("item_count");
                Manufacturer manObj = new Manufacturer(uID, name, address, itemCount);
                Inventory.manufacturersList.put(uID, manObj);
            }
            
            ps = con.prepareStatement("SELECT * FROM items");
            rs = ps.executeQuery();
            while(rs.next()) {
                int uID = rs.getInt("item_uid");
                String type = rs.getString("type");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                int daySale = rs.getInt("day_sale");
                int totalSale = rs.getInt("total_sale");
                int manufacturerID = rs.getInt("manufacturer_uid");
                String vehicleType = rs.getString("vehicle_type");
                LocalDate startDate = rs.getDate("start_date").toLocalDate();
                Item itemObj = new Item(uID, type, price, quantity, daySale, totalSale, manufacturerID, vehicleType, startDate);
                Inventory.itemsList.put(uID, itemObj);
                
                if(Inventory.searchMap.containsKey(type)) {
                    if(Inventory.searchMap.get(type).containsKey((manufacturerID))) {
                        Inventory.searchMap.get(type).get(manufacturerID).put(vehicleType, itemObj);
                    }
                    else {
                        HashMap<String, Item> temp1 = new HashMap<>();
                        temp1.put(vehicleType, itemObj);
                        
                        Inventory.searchMap.get(type).put(manufacturerID, temp1);
                    }
                }
                else {
                    HashMap<String, Item> temp1 = new HashMap<>();
                    temp1.put(vehicleType, itemObj);
                
                    HashMap<Integer, HashMap<String, Item>> temp2 = new HashMap<>();
                    temp2.put(manufacturerID, temp1);
                
                    Inventory.searchMap.put(type, temp2);
                }
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public boolean removeItem(){
        return true;
    }
    
//    public static void main(String[] args) {
//        Inventory ob = new Inventory();
//        ob.retrieveData();
//        
//        for (Map.Entry<Integer, Manufacturer> e : Inventory.manufacturersList.entrySet()) {
//            System.out.println(e.getValue());
//        }
//        System.out.println("");
//
//        
//        for (Map.Entry<Integer, Item> e : Inventory.itemsList.entrySet()) {
//            System.out.println(e.getValue());
//        }
//        System.out.println("");
//        
//        for (Map.Entry<String, HashMap<Integer, HashMap<String, Item>>> e : Inventory.searchMap.entrySet()) {
//            for(Map.Entry<Integer, HashMap<String, Item>> f : e.getValue().entrySet()) {
//                for(Map.Entry<String, Item> g : f.getValue().entrySet()) {
//                    System.out.println(e.getKey());
//                    System.out.println(f.getKey());
//                    System.out.println(g.getKey());
//                    System.out.println(g.getValue());
//                    System.out.println("");
//                }
//            }
//        }
//    }
}

