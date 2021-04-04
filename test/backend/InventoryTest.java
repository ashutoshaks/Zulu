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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author achcha
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryTest {
    
    static Item itemArr[] = new Item[2];
    static Manufacturer manufacturerArr[] = new Manufacturer[2];
    
    public InventoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Inventory.searchMap.clear();
        Inventory.itemsList.clear();
        Inventory.manufacturersList.clear();
        Inventory.manufacturerIDList.clear();
        Item.nextUID = 0;
        Manufacturer.nextUID = 0;
        
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM items");
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM manufacturers");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of type method, of class Inventory.
     */
    @Test
    public void a_testType() {
        System.out.println("type");
        Inventory expResult = Inventory.type();
        Inventory result = Inventory.type();
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveData method, of class Inventory.
     */
    @Test
    public void b_testRetrieveData() {
        System.out.println("retrieveData");
        Item item1 = new Item(-1, "Suspension", 5400, 4, 0, 0, 1, "Hatchback", LocalDate.of(2021, 04, 03));
        Item item2 = new Item(-1, "Mirror", 3600, 5, 0, 0, 1, "Minivan", LocalDate.of(2021, 04, 03));
        Manufacturer mf1 = new Manufacturer(-1, "Tata", "7th Floor, Amar Business Park, Andheri, Mumbai", 2);
        item1.save();
        item2.save();
        mf1.save();
        Inventory instance = Inventory.type();
        instance.retrieveData();
        
        assertEquals(Inventory.searchMap.get("Suspension").get(1).get("Hatchback").uID, 1);
        assertEquals(Inventory.searchMap.get("Suspension").get(1).get("Hatchback").type, "Suspension");      
        assertEquals(Inventory.searchMap.get("Suspension").get(1).get("Hatchback").price, 5400.0F, 0.0);
        assertEquals(Inventory.searchMap.get("Suspension").get(1).get("Hatchback").quantity, 4);
        assertEquals(Inventory.searchMap.get("Suspension").get(1).get("Hatchback").manufacturerID, 1);
        assertEquals(Inventory.searchMap.get("Suspension").get(1).get("Hatchback").vehicleType, "Hatchback");
        
        assertEquals(Inventory.itemsList.get(2).uID, 2);
        assertEquals(Inventory.itemsList.get(2).type, "Mirror");
        assertEquals(Inventory.itemsList.get(2).price, 3600.0F, 0.0);
        assertEquals(Inventory.itemsList.get(2).quantity, 5);
        assertEquals(Inventory.itemsList.get(2).manufacturerID, 1);
        assertEquals(Inventory.itemsList.get(2).vehicleType, "Minivan");
        
        assertEquals(Inventory.manufacturersList.get(1).uID, 1);
        assertEquals(Inventory.manufacturersList.get(1).name, "Tata");
        assertEquals(Inventory.manufacturersList.get(1).address, "7th Floor, Amar Business Park, Andheri, Mumbai");
        assertEquals(Inventory.manufacturersList.get(1).itemCount, 2);
    }

    /**
     * Test of removeItem method, of class Inventory.
     */
    @Test
    public void c_testRemoveItem() {
        try {
            System.out.println("removeItem");
            Item item1 = new Item(-1, "Suspension", 5400, 4, 0, 0, 1, "Hatchback", LocalDate.of(2021, 04, 03));
            Item item2 = new Item(-1, "Mirror", 3600, 5, 0, 0, 1, "Minivan", LocalDate.of(2021, 04, 03));
            Manufacturer mf1 = new Manufacturer(-1, "Tata", "7th Floor, Amar Business Park, Andheri, Mumbai", 2);
            item1.save();
            item2.save();
            mf1.save();
            Inventory instance = Inventory.type();
            
            Connection con = DB.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            
            
            int itemUID = 2;
            boolean expResult = true;
            boolean result = instance.removeItem(itemUID);
            assertEquals(expResult, result);
            
            itemUID = 1;
            expResult = true;
            result = instance.removeItem(itemUID);
            assertEquals(expResult, result);
            
            ps = con.prepareStatement("SELECT * FROM items WHERE item_uid = ?");
            ps.setInt(1, itemUID);
            rs = ps.executeQuery();
            assertEquals(rs.next(), false);
            
            Inventory.searchMap.clear();
            Inventory.itemsList.clear();
            Inventory.manufacturersList.clear();
            Inventory.manufacturerIDList.clear();
            Item.nextUID = 0;
            Manufacturer.nextUID = 0;
            
            item1 = new Item(-1, "Suspension", 5400, 4, 0, 0, 1, "Hatchback", LocalDate.of(2021, 04, 03));
            item2 = new Item(-1, "Mirror", 3600, 5, 0, 0, 2, "Minivan", LocalDate.of(2021, 04, 03));
            mf1 = new Manufacturer(-1, "Tata", "7th Floor, Amar Business Park, Andheri, Mumbai", 1);
            Manufacturer mf2 = new Manufacturer(-1, "Michelin", "24, Chanu Road, Bandra, Mumbai", 1);
            item1.save();
            item2.save();
            mf1.save();
            mf2.save();
            
            itemUID = 2;
            expResult = true;
            result = instance.removeItem(itemUID);
            assertEquals(expResult, result);
            
            ps = con.prepareStatement("SELECT * FROM items WHERE item_uid = ?");
            ps.setInt(1, itemUID);
            rs = ps.executeQuery();
            assertEquals(rs.next(), false);
            
            ps = con.prepareStatement("SELECT * FROM manufacturers WHERE manufacturer_uid = ?");
            ps.setInt(1, 2);
            rs = ps.executeQuery();
            assertEquals(rs.next(), false);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
