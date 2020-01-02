package NammedBeans;


import EJBs.ContractManager;
import JPA.Contract;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;


@Named("contract")
@SessionScoped
public class ContractBean implements Serializable {

private Contract c = new Contract();



@EJB
private ContractManager contractManager;

    @PersistenceContext(name = "accounting")
    private EntityManager em;



    public Contract getC() {
        return c;
    }

    public void setC(Contract c) {
        this.c = c;
    }

    @PostConstruct        //fetch all the contract depending on the type of user
    public void init(){


    }

    public String deleteContract(){
        return contractManager.delete(c,em);
    }

    public String addContract(){

        if(c.getTotal_cost() < 0){
            return "error cost";
        }if(c.getStart_date().compareTo(c.getEnd_date()) > 0){
            return "error date";
        }


        String resp =  contractManager.add(c,em);
        return resp;
    }

    public ArrayList<Contract> getAllContract(){
        return contractManager.getAllContract(em);
    }



}
