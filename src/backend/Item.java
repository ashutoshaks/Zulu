/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import controller.DB;
import static java.lang.Integer.max;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author achcha
 */

public class Item {
    int uID;
    String type;
    float price;
    int quantity;
    int daySale;
    int totalSale;
    int manufacturerID;
    String vehicleType;
    LocalDate startDate;
    
    static int nextUID = 1;
    
    public Item(int uID_, String type_, float price_, int quantity_, int daySale_, int totalSale_, int manufacturerID_, String vehicleType_, LocalDate startDate_) {
        if(uID_ == -1) 
            this.uID = Item.nextUID++;
        else {
            this.uID = uID_;
            Item.nextUID = max(Item.nextUID, uID_);
        }
        this.type = type_;
        this.price = price_;
        this.quantity = quantity_;
        this.daySale = daySale_;
        this.totalSale = totalSale_;
        this.manufacturerID = manufacturerID_;
        this.vehicleType = vehicleType_;
        this.startDate = startDate_;
    }
    
    public int getUID(){
        return uID;
    }
    
    public String getType(){
        return type;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public int getManufacturerID(){
        return manufacturerID;
    }
    
    public String getVehicleType(){
        return vehicleType;
    }
    
    public LocalDate getStartDate(){
        return startDate;
    }
    
    public int save(){
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO items(item_uid, type, price, quantity, day_sale, total_sale, manufacturer_uid, vehicle_type, start_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, this.uID);
            ps.setString(2, this.type);
            ps.setFloat(3, this.price);
            ps.setInt(4, this.quantity);
            ps.setInt(5, this.daySale);
            ps.setInt(6, this.totalSale);
            ps.setInt(7, this.manufacturerID);
            ps.setString(8, this.vehicleType);
            ps.setDate(9, java.sql.Date.valueOf(this.startDate));
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public int delete(){
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE item_uid = ?");
            ps.setInt(1, this.uID);
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public boolean updateSale(int numSold){
        return true;
    }
    
    @Override
    public String toString() {
        String outString = "id = " + uID + ", type = " + type + ", price = " + price + ", quantity = " + quantity + ", daysale = " + daySale + ", totalsale = " + totalSale + ", manid = " + manufacturerID + ", vehicletype = " + vehicleType + ", startdate = " + startDate;
        return outString;
    }
}
