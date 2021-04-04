/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

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
public class OwnerTest {
    
    public OwnerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Inventory.type().retrieveData();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Owner.type().name = "Zulu Malik";
        Owner.type().username = "VASachcha";
        Owner.type().password = "OKZulu!";
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of type method, of class Owner.
     */
    @Test
    public void a_testType() {
        System.out.println("type");
        Owner expResult = Owner.type();
        Owner result = Owner.type();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Owner.
     */
    @Test
    public void b_testGetName() {
        System.out.println("getName");
        Owner instance = Owner.type();
        String expResult = "Zulu Malik";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Owner.
     */
    @Test
    public void c_testSetName() {
        System.out.println("setName");
        String name = "Lulu Malik";
        Owner instance = Owner.type();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getUsername method, of class Owner.
     */
    @Test
    public void d_testGetUsername() {
        System.out.println("getUsername");
        Owner instance = Owner.type();
        String expResult = "VASachcha";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Owner.
     */
    @Test
    public void e_testSetUsername() {
        System.out.println("setUsername");
        String username = "VASbura";
        Owner instance = Owner.type();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of validate method, of class Owner.
     */
    @Test
    public void f_testValidate() {
        System.out.println("validate");
        String username = "VASachcha";
        String password = "OKZulu!";
        boolean expResult = true;
        boolean result = Owner.validate(username, password);
        assertEquals(expResult, result);
        
        username = "VASachcha";
        password = "HiZulu:)";
        expResult = false;
        result = Owner.validate(username, password);
        assertEquals(expResult, result);
        
        username = "VASbura";
        password = "OKZulu!";
        expResult = false;
        result = Owner.validate(username, password);
        assertEquals(expResult, result);
        
        username = "VASbura";
        password = "HiZulu:)";
        expResult = false;
        result = Owner.validate(username, password);
        assertEquals(expResult, result);
    }
}
