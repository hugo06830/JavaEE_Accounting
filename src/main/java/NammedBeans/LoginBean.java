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

    public  LoginBean(){

    }

    public String login(){
        String usr = Username;
        String pwd = Password;
        clear();
        return logger.login(usr,pwd,em);
    }

    public void clear(){
        Username = "";
        Password = "";
    }



}
