package com.cubix.login;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * A ki-, és beléptetést végző kontroller.
 * @author Papp József
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    
    protected String username;
    protected String enteredPassword;
    protected User user;
    protected Model model;
    
    @EJB
    protected UserService service;

    public LoginController() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return enteredPassword;
    }

    public void setPassword(String password) {
        this.enteredPassword = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    //************************************************
    
    
    /**
     * Beléptetés.
     * @throws IOException 
     */
    public void login() throws IOException {
        try {
            if (username.trim().isEmpty()) {
                throw new IllegalArgumentException("Kérjük adja meg a felhasználónevét!");
            }
            if (enteredPassword.trim().isEmpty()) {
                throw new IllegalArgumentException("Kérjük adja meg a jelszót!");
            }            
                       
            user = service.validate(username.trim(), Model.generateHash(enteredPassword.trim() ) );
            if (user == null) {
                throw new IllegalArgumentException("Ismeretlen felhasználónév vagy hibás jelszó!");
            }
            FacesContext.getCurrentInstance().getExternalContext().redirect("secured/main.xhtml");
            
        } catch (IOException | IllegalArgumentException ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();   
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, ex.getMessage() );
            facesContext.addMessage(null, facesMessage);              
        }
    }    
    
    
    /**
     * Kiléptetés, visszatérés a kezdőoldalra.
     * @return Kezdőoldal
     * @throws IOException
     * @throws ServletException 
     */
    public String logout() throws IOException, ServletException {
        try {
            user = null;

            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.invalidateSession();

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequest();
            request.logout();

            ec.redirect(ec.getRequestContextPath() + "/");

            return "login";
        } catch (IOException | ServletException ex) {
            FacesContext facesContext = FacesContext.getCurrentInstance();   
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, ex.getMessage() );
            facesContext.addMessage(null, facesMessage);  
        }
        return "login.xhtml";
    }    
    
    
}
