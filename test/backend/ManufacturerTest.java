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

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author achcha
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManufacturerTest {
    
    static Manufacturer arr[] = new Manufacturer[2];
    
    public ManufacturerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM manufacturers");
            ps.executeUpdate();
            arr[0] = new Manufacturer(-1, "MRF", "9, Devaraj Building, Goregaon West, Mumbai", 2);
            arr[1] = new Manufacturer(-1, "Tata", "7th Floor, Amar Business Park, Andheri, Mumbai", 4);
        } catch (SQLException ex) {
            Logger.getLogger(ManufacturerTest.class.getName()).log(Level.SEVERE, null, ex);
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
     * Test of getUID method, of class Manufacturer.
     */
    @Test
    public void a_testGetUID() {
        System.out.println("getUID");
        Manufacturer instance = arr[0];
        int expResult = 1;
        int result = instance.getUID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Manufacturer.
     */
    @Test
    public void b_testGetName() {
        System.out.println("getName");
        Manufacturer instance = arr[0];
        String expResult = "MRF";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Manufacturer.
     */
    @Test
    public void c_testGetAddress() {
        System.out.println("getAddress");
        Manufacturer instance = arr[0];
        String expResult = "9, Devaraj Building, Goregaon West, Mumbai";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemCount method, of class Manufacturer.
     */
    @Test
    public void d_testGetItemCount() {
        System.out.println("getItemCount");
        Manufacturer instance = arr[0];
        int expResult = 2;
        int result = instance.getItemCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of incrementItemCount method, of class Manufacturer.
     */
    @Test
    public void e_testIncrementItemCount() {
        System.out.println("incrementItemCount");
        Manufacturer instance = arr[0];
        instance.incrementItemCount();
        assertEquals(3, instance.getItemCount());
    }

    /**
     * Test of save method, of class Manufacturer.
     */
    @Test
    public void f_testSave() {
        try {
            System.out.println("save");
            Manufacturer.nextUID = 0;
            Manufacturer m1 = arr[0];
            int expResult = 1;
            int result = m1.save();
            assertEquals(expResult, result);
            
            Manufacturer m2 = arr[1];
            expResult = 1;
            result = m2.save();
            assertEquals(expResult, result);
            
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM manufacturers");
            ResultSet rs = ps.executeQuery();
            rs.next();
            assertEquals(rs.getInt("manufacturer_uid"), 1);
            assertEquals(rs.getString("name"), m1.name);
            assertEquals(rs.getString("address"), m1.address);
            assertEquals(rs.getInt("item_count"), m1.itemCount);

            rs.next();
            assertEquals(rs.getInt("manufacturer_uid"), 2);
            assertEquals(rs.getString("name"), m2.name);
            assertEquals(rs.getString("address"), m2.address);
            assertEquals(rs.getInt("item_count"), m2.itemCount);
            
            
        } catch (SQLException ex) {
            fail("save() failed due to SQLException.");
        }  
    }

    /**
     * Test of delete method, of class Manufacturer.
     */
    @Test
    public void g_testDelete() {
        System.out.println("delete");
        
        Manufacturer m1 = arr[0];
        Manufacturer m2 = arr[1];
        int expResult = 1;
        int result = m2.delete();
        assertEquals(expResult, result);
        
        expResult = 1;
        result = m1.delete();
        assertEquals(expResult, result);
    }
    
}
