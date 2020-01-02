package NammedBeans;

import EJBs.Account;
import JPA.Staff;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("account")
public class AccountBean implements Serializable {
    private List<Staff> allAcc;
    private Staff staff = new Staff();
    private String confirm;

    public void setAllAcc(List<Staff> allAcc) {
        this.allAcc = allAcc;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }



    @PostConstruct
    public void init(){
     allAcc = InitAllAcc();
    }

    AccountBean(){

    }

    @PersistenceContext(unitName = "accounting")
    EntityManager em;

    @EJB
    private Account accountManager;


    public List<Staff> InitAllAcc(){

        return accountManager.getAllAccount(em);
    }

    public void addAccount(){
        accountManager.addAccount(staff,em,confirm);
    }

    public List<Staff> getAllAcc() {
        return allAcc;
    }

    public void disable(Staff acc){
        accountManager.disable(acc,em);

    }

    public void enable(Staff acc){
        accountManager.enable(acc,em);
    }
}
