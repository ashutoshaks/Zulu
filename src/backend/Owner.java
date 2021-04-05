/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import controller.DB;
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

// Owner class, modelled as a singleton

public class Owner {
    String name;
    String username;
    String password;
    
    private static Owner instance = null;
    
    // private constructor for a singleton
    private Owner() {
        this.name = "Zulu Malik";
        this.username = "VASachcha";
        this.password = "OKZulu!";
    }
    
    // Function to get the singleton instance
    public static Owner type() {
        if(instance == null)
            instance = new Owner();
        return instance;
    }
    
    // Getters and Setters
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    // Function that validates the username and password enterd for verification
    public static boolean validate(String username, String password){
        boolean flag = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM owner WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            flag = rs.next();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Owner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
