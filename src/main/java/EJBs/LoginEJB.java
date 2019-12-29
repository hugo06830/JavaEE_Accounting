package EJBs;
import JPA.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Stateless
public class LoginEJB implements Login {



    @Override
    public String login(String username, String password,EntityManager em) {
        TypedQuery<Staff> accountQuery = em.createQuery("SELECT acc FROM Staff acc WHERE Password = :pwd AND Username=:username",Staff.class);
        accountQuery.setParameter("pwd",password).setParameter("username",username);
        try {
            Staff staff = accountQuery.getSingleResult();
            if(!staff.isEnabled()){
                return "Disabled account";
            }
            switch(staff.getCategory()){
                case admin: return "Admin account";
                case normal: return "Normal account";
                case accounting: return "Accounting account";
                default: return "Unexpected error";
            }
        }catch(NoResultException e){
            e.printStackTrace();
            return "No account";
        }




    }
}
