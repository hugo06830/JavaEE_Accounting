package JPA;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
public class Staff {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Acc_id;
    private String Username;
    private  String Password;
    @Enumerated(EnumType.STRING)
    private Category Category;
    private boolean enabled = true;

    @OneToMany
    @JoinColumn(name = "ID")
    private List<Contract> contractList = new ArrayList<>();


    public int getAcc_id() {
        return Acc_id;
    }

    public void setAcc_id(int acc_id) {
        Acc_id = acc_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public JPA.Category getCategory() {
        return Category;
    }

    public void setCategory(JPA.Category category) {
        Category = category;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
