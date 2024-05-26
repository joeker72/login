package com.cubix.login;

import javax.ejb.Stateless;

/**
 * DAO objektum szimulálása.
 * @author Papp József
 */
@Stateless
public class UserService {
    
        protected final String DEFAULT_HASH = "5be2bcf5718118eaeab4fe7ae57543262082a8fce89420a5fc4799d99af2f161";
        protected final String DEFAULT_USERNAME = "teszt";
        protected final String DEFAULT_REALNAME = "Dicső Lovag";
        
    
        /**
         * Név, jelszó ellenőrzés szimulálása.
         * Sikeres belépés esetén visszaadja a felhasználó entitást, egyébként null-t.
         * @param login Belépési név
         * @param password Jelszó hash
         * @return Felhasználó entitás
         */
        public User validate(String login, String password) {
            if (login == null || password == null) return null;
            User entity = null;
            
            if (login.equalsIgnoreCase(DEFAULT_USERNAME) 
                    && password.equalsIgnoreCase(DEFAULT_HASH)) {
                entity = new User();
                entity.setUsername(DEFAULT_USERNAME);
                entity.setPassword(DEFAULT_HASH);
                entity.setRealName(DEFAULT_REALNAME);            
            }          
            return entity;            
        }
    
}
