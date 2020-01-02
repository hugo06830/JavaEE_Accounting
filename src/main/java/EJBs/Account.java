package EJBs;

import JPA.Staff;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import java.util.List;


@Local
public interface Account {
    List<Staff> getAllAccount(EntityManager em);

    void addAccount(Staff staff, EntityManager em, String confirm);

    void disable(Staff acc, EntityManager em);

    void enable(Staff acc, EntityManager em);
}
