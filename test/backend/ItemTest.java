/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import controller.DB;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ItemTest {
    
    static Item arr[] = new Item[2];
    
    public ItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM items");
            ps.executeUpdate();
            arr[0] = new Item(-1, "Suspension", 5400, 4, 0, 0, 1, "Hatchback", LocalDate.of(2021, 04, 03));
            arr[1] = new Item(-1, "Mirror", 3600, 5, 0, 0, 1, "Minivan", LocalDate.of(2021, 04, 03));
        } catch (SQLException ex) {
            Logger.getLogger(ItemTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUID method, of class Item.
     */
    @Test
    public void a_testGetUID() {
        System.out.println("getUID");
        Item instance = arr[0];
        int expResult = 1;
        int result = instance.getUID();
        assertEquals(expResult, result);
        
        instance = arr[1];
        expResult = 2;
        result = instance.getUID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Item.
     */
    @Test
    public void b_testGetType() {
        System.out.println("getType");
        Item instance = arr[0];
        String expResult = "Suspension";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void c_testGetPrice() {
        System.out.println("getPrice");
        Item instance = arr[0];
        float expResult = 5400.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getQuantity method, of class Item.
     */
    @Test
    public void d_testGetQuantity() {
        System.out.println("getQuantity");
        Item instance = arr[0];
        int expResult = 4;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getManufacturerID method, of class Item.
     */
    @Test
    public void e_testGetManufacturerID() {
        System.out.println("getManufacturerID");
        Item instance = arr[0];
        int expResult = 1;
        int result = instance.getManufacturerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVehicleType method, of class Item.
     */
    @Test
    public void f_testGetVehicleType() {
        System.out.println("getVehicleType");
        Item instance = arr[0];
        String expResult = "Hatchback";
        String result = instance.getVehicleType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Item.
     */
    @Test
    public void g_testGetStartDate() {
        System.out.println("getStartDate");
        Item instance = arr[0];
        LocalDate expResult = LocalDate.of(2021, 04, 03);
        LocalDate result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class Item.
     */
    @Test
    public void h_testSave() {
        try {
            System.out.println("save");
            Item instance = arr[0];
            int expResult = 1;
            int result = instance.save();
            assertEquals(expResult, result);
            
            instance = arr[1];
            expResult = 1;
            result = instance.save();
            assertEquals(expResult, result);

            Connection con = DB.getConnection();
            instance = arr[0];
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();
            rs.next();
            assertEquals(rs.getInt("item_uid"), 1);
            assertEquals(rs.getString("type"), instance.type);
            assertEquals(rs.getFloat("price"), instance.price, 0.0F);
            assertEquals(rs.getInt("quantity"), instance.quantity);
            assertEquals(rs.getInt("day_sale"), instance.daySale);
            assertEquals(rs.getInt("total_sale"), instance.totalSale);
            assertEquals(rs.getInt("manufacturer_uid"), instance.manufacturerID);
            assertEquals(rs.getString("vehicle_type"), instance.vehicleType);
            assertEquals(rs.getDate("start_date").toLocalDate(), instance.startDate);
            
            instance = arr[1];
            rs.next();
            assertEquals(rs.getInt("item_uid"), 2);
            assertEquals(rs.getString("type"), instance.type);
            assertEquals(rs.getFloat("price"), instance.price, 0.0F);
            assertEquals(rs.getInt("quantity"), instance.quantity);
            assertEquals(rs.getInt("day_sale"), instance.daySale);
            assertEquals(rs.getInt("total_sale"), instance.totalSale);
            assertEquals(rs.getInt("manufacturer_uid"), instance.manufacturerID);
            assertEquals(rs.getString("vehicle_type"), instance.vehicleType);
            assertEquals(rs.getDate("start_date").toLocalDate(), instance.startDate);
        } catch (SQLException ex) {
            fail("save() failed due to SQLException.");
        }
    }

    /**
     * Test of delete method, of class Item.
     */
    @Test
    public void i_testDelete() {
        System.out.println("delete");
        Item item1 = arr[0];
        Item item2 = arr[1];
        int expResult = 1;
        int result = item2.delete();
        assertEquals(expResult, result);
        
        expResult = 1;
        result = item1.delete();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateSale method, of class Item.
     */
    @Test
    public void j_testUpdateSale() {
        System.out.println("updateSale");
        int numSold = 2;
        Item instance = arr[0];
        instance.save();
        boolean expResult = true;
        boolean result = instance.updateSale(numSold);
        assertEquals(expResult, result);
        assertEquals(instance.quantity, 2);
    }
    
}
