/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.Date;

/**
 *
 * @author ashutosh
 */
public class Inventory {
    static HashMap<String, HashMap<Integer, HashMap<String, Item>>> searchMap;
    static HashMap<Integer, Item> itemsList;
    static HashMap<Integer, Manufacturer> manufacturersList;
    static Date currentDate;
    
    public void retrieveData(){
        
    }
    
    public boolean removeItem(){
        return true;
    }
}
