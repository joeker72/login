package com.cubix.login;

/**
 * Felhasználó entitás.
 * @author Papp József
 */
public class User {
    
    protected String username;
    protected String password;
    protected String realName;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    
    
}
