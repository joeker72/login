package com.cubix.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joe
 */
public class ModelTest {
    
    public ModelTest() {
    }
       
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }


    //***************************************************************
    
    @Test
    public void testGenerateHash() {
        String input = "titok";
        String expResult = "5be2bcf5718118eaeab4fe7ae57543262082a8fce89420a5fc4799d99af2f161";
        String result = Model.generateHash(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerateHash_empty() {
        String input = "";
        String expResult = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        String result = Model.generateHash(input);
        assertEquals(expResult, result);
    }    
    
    @Test
    public void testGenerateHash_null() {
        String input = null;
        String expResult = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        String result = Model.generateHash(input);
        assertEquals(expResult, result);
    }        
    
}
