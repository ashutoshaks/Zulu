/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import controller.DB;
import static java.lang.Integer.max;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achcha
 */

public class Manufacturer {
    int uID;
    String name;
    String address;
    int itemCount;
    
    static int nextUID = 0;
    
    public Manufacturer(int uID_, String name_, String address_, int itemCount_) {
        if(uID_ == -1) 
            this.uID = ++Manufacturer.nextUID;
        else {
            this.uID = uID_;
            Manufacturer.nextUID = max(Manufacturer.nextUID, uID_);
        }
        this.name = name_;
        this.address = address_;
        this.itemCount = itemCount_;
        if(uID_ == -1) {
            Inventory.manufacturersList.put(this.uID, this);
            Inventory.manufacturerIDList.put(this.name, this.uID);
        }
    }
    
    public int getUID(){
        return uID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public int getItemCount(){
        return itemCount;
    }
    
    public void incrementItemCount() {
        this.itemCount++;
    }
    
    public int save(){
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO manufacturers(manufacturer_uid, name, address, item_count) VALUES(?, ?, ?, ?)");
            ps.setInt(1, this.uID);
            ps.setString(2, this.name);
            ps.setString(3, this.address);
            ps.setInt(4, this.itemCount);
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public int delete(){
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM manufacturers WHERE manufacturer_uid = ?");
            ps.setInt(1, this.uID);
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Manufacturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    @Override
    public String toString() {
        String outString = "Manufacturer ID = " + uID + "\nName = " + name + "\nAddress = " + address + "\nItem Count = " + itemCount + "\n";
        return outString;
    }
}
