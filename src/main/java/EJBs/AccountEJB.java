package EJBs;

import JPA.Staff;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateful
public class AccountEJB implements Account {

    @Override
    public List<Staff> getAllAccount(EntityManager em) {
        TypedQuery q = (TypedQuery) em.createNativeQuery("SELECT * FROM Account",Staff.class);
        try{
            return  q.getResultList();
        }catch (NullPointerException e){
            e.printStackTrace();
            return q.getResultList();
        }


    }

    @Override
    @Transactional
    public void addAccount(Staff staff, EntityManager em, String confirm) {
        if(staff.getPassword().equals(confirm)){
            try{
               em.merge(staff);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    @Override
    public void disable(Staff acc, EntityManager em) {
        try{
            acc.setEnabled(false);
            em.merge(acc);
        }catch(Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public void enable(Staff acc, EntityManager em) {

        try{
            acc.setEnabled(true);
            em.merge(acc);
        }catch(Exception e){
            e.printStackTrace();

        }

    }
}
