package EJBs;

import JPA.Contract;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import java.util.ArrayList;


@Local
public interface ContractManager {

     String delete(Contract c, EntityManager em);

    String add(Contract c,EntityManager em);

    ArrayList<Contract> getAllContract(EntityManager em);
}
