package NammedBeans;

import EJBs.Login;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


@Named("login")
@SessionScoped
public class LoginBean implements Serializable {
    private String Username;
    private String Password;
    private String type;

    @PersistenceContext(unitName = "accounting")
    private EntityManager em;



    @EJB
    private Login logger;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public  LoginBean(){

    }

    public String login(){
        type = logger.login(Username,Password,em);
        clear();
        return  type;
    }

    public void clear(){
        Username = null;
        Password = null;
    }



}
