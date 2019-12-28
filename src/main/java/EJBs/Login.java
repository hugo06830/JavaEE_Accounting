package EJBs;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface Login {

    public String login(String username, String password, EntityManager em);
}
