package EJBs;

import JPA.Contract;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Stateless
public class ContractEJB implements ContractManager {


    @Override
    public String delete(Contract c, EntityManager em) {
      Query q =  em.createQuery("DELETE Contract c where Contract.ID = :id").setParameter("id",c.getID());
      try{
          q.executeUpdate();
          return "Contract deleted";
      }catch (EntityNotFoundException e){
          e.printStackTrace();
          return "Contract not found";
      }


    }

    @Override
    @Transactional
    public String add(Contract c, EntityManager em) {
        try{
            em.persist(c);
            return "sucessfully added contract";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public ArrayList<Contract> getAllContract(EntityManager em) {
        Query q = em.createQuery("SELECT Contract FROM Contract ");
        ArrayList<Contract> res = (ArrayList<Contract>) q.getResultList();
        return res;
    }
}
