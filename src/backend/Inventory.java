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
import java.time.Period;
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
    
    private static Inventory instance = null;
    
    public static Inventory type() {
        if(instance == null)
            instance = new Inventory();
        return instance;
    }
    
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
    
    public boolean removeItem(int itemUID){
        try {
            int status = 0;
            Item currItem = Inventory.itemsList.get(itemUID);
            Manufacturer currManufacturer = Inventory.manufacturersList.get(currItem.manufacturerID);
            
            Inventory.searchMap.get(currItem.type).get(currItem.manufacturerID).remove(currItem.vehicleType);
            Inventory.itemsList.remove(currItem.uID);
            
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE item_uid = ?");
            ps.setInt(1, currItem.uID);
            status = ps.executeUpdate();
            
            if(currManufacturer.itemCount == 1) {
                Inventory.searchMap.get(currItem.type).remove(currManufacturer.uID);
                Inventory.manufacturersList.remove(currManufacturer.uID);
                
                ps = con.prepareStatement("DELETE FROM manufacturers WHERE manufacturer_uid = ?");
                ps.setInt(1, currManufacturer.uID);
                status = ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (status > 0);
    }
    
    public HashMap<Integer, Integer> getOrderList() {
        HashMap<Integer, Integer> orderList = new HashMap<>();
        for(Map.Entry<Integer, Item> e : Inventory.itemsList.entrySet()) {
            Item currItem = e.getValue();
            int days = Period.between(currItem.startDate, Inventory.currentDate).getDays();
            int threshold = (int)((double)currItem.totalSale / days) * 7;
            if(threshold > currItem.quantity)
                orderList.put(e.getKey(), threshold - currItem.quantity);
        }
        return orderList;
    }
    
    public static void main(String[] args) {
        Inventory.type().retrieveData();
        
        for (Map.Entry<Integer, Manufacturer> e : Inventory.manufacturersList.entrySet()) {
            System.out.println(e.getValue());
        }
        System.out.println("");

        
        for (Map.Entry<Integer, Item> e : Inventory.itemsList.entrySet()) {
            System.out.println(e.getValue());
        }
        System.out.println("");
        
        for (Map.Entry<String, HashMap<Integer, HashMap<String, Item>>> e : Inventory.searchMap.entrySet()) {
            for(Map.Entry<Integer, HashMap<String, Item>> f : e.getValue().entrySet()) {
                for(Map.Entry<String, Item> g : f.getValue().entrySet()) {
                    System.out.println(e.getKey());
                    System.out.println(f.getKey());
                    System.out.println(g.getKey());
                    System.out.println(g.getValue());
                    System.out.println("");
                }
            }
        }
    }
}

