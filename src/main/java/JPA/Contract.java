package JPA;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Contract {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;

    private String Title;
    private String description;
    private float Total_cost;
    private Date Start_date;
    private Date End_date;


    private int provider_Id;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTotal_cost() {
        return Total_cost;
    }

    public void setTotal_cost(float total_cost) {
        Total_cost = total_cost;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date start_date) {
        Start_date = start_date;
    }

    public Date getEnd_date() {
        return End_date;
    }

    public void setEnd_date(Date end_date) {
        End_date = end_date;
    }

    public int getProviderId() {
        return provider_Id;
    }

    public void setProviderId(int providerId) {
        this.provider_Id = providerId;
    }


}
