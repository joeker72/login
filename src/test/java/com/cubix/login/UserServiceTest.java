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
public class UserServiceTest {
    
    public UserServiceTest() {
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
    public void testValidate_OK() {
        String login = "teszt";
        String password = "5be2bcf5718118eaeab4fe7ae57543262082a8fce89420a5fc4799d99af2f161";
        UserService instance = new UserService();
       
        User result = instance.validate(login, password);
        assertNotNull(result);
        assertEquals("Dicső Lovag", result.realName);
    }
    
    @Test
    public void testValidate_wrongUsername() {
        String login = "teszt2";
        String password = "5be2bcf5718118eaeab4fe7ae57543262082a8fce89420a5fc4799d99af2f16";
        UserService instance = new UserService();
       
        User result = instance.validate(login, password);
        assertNull(result);
    }      
    
    @Test
    public void testValidate_wrongPassword() {
        String login = "teszt";
        String password = "5be2bcf5718118eaeab4fe7ae57543262082a8fce89420a5fc4799d99af2f16x";
        UserService instance = new UserService();
       
        User result = instance.validate(login, password);
        assertNull(result);
    }       
    
    @Test
    public void testValidate_emptyLogin() {
        String login = "";
        String password = "5be2bcf5718118eaeab4fe7ae57543262082a8fce89420a5fc4799d99af2f161";
        UserService instance = new UserService();
       
        User result = instance.validate(login, password);
        assertNull(result);
    }    
    
    @Test
    public void testValidate_emptyPassword() {
        String login = "teszt";
        String password = "";
        UserService instance = new UserService();
       
        User result = instance.validate(login, password);
        assertNull(result);
    }      
}
