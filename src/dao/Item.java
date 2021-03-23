/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;

/**
 *
 * @author ashutosh
 */
public class Item {
    int uID;
    String type;
    double price;
    int quantity;
    int daySale;
    int totalSale;
    int manufacturerID;
    String vehicleType;
    Date startDate;
    
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
    
    public Date getStartDate(){
        return startDate;
    }
    
    public int save(){
        return 1;
    }
    
    public int delete(){
        return 1;
    }
    
    public boolean updateSale(int numSold){
        return true;
    }
}
