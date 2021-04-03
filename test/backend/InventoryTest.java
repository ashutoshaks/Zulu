/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.HashMap;
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
        Inventory expResult = null;
        Inventory result = Inventory.type();
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveData method, of class Inventory.
     */
    @Test
    public void b_testRetrieveData() {
        System.out.println("retrieveData");
        Inventory instance = new Inventory();
        instance.retrieveData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class Inventory.
     */
    @Test
    public void c_testRemoveItem() {
        System.out.println("removeItem");
        int itemUID = 0;
        Inventory instance = new Inventory();
        boolean expResult = false;
        boolean result = instance.removeItem(itemUID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endDay method, of class Inventory.
     */
    @Test
    public void d_testEndDay() {
        System.out.println("endDay");
        Inventory instance = new Inventory();
        instance.endDay();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderList method, of class Inventory.
     */
    @Test
    public void e_testGetOrderList() {
        System.out.println("getOrderList");
        Inventory instance = new Inventory();
        HashMap<Integer, Integer> expResult = null;
        HashMap<Integer, Integer> result = instance.getOrderList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
