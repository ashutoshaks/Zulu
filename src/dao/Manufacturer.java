/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ashutosh
 */
public class Manufacturer {
    int uID;
    String name;
    String address;
    int itemCount;
    
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
    
    public int save(){
        return 1;
    }
    
    public int delete(){
        return 1;
    }
}
