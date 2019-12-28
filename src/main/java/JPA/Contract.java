package JPA;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Contract {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int ID;

    private String Title;
    private String description;
    private float Total_cost;
    private Date Start_date;
    private Date End_date;
    private int providerId;


}
