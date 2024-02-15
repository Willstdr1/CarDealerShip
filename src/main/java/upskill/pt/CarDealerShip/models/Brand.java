package upskill.pt.CarDealerShip.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Name;

    public Brand(int id, String name) {
        this.id = id;
        Name = name;
    }

    public Brand(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}
