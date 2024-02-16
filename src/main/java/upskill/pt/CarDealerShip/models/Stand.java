package upskill.pt.CarDealerShip.models;

import jakarta.persistence.*;

@Entity
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public int phoneNumber;
    public String emailAdress;

    @ManyToOne(cascade = CascadeType.ALL)
    private Suplier suplier;

    public Stand(int id, String name, int phoneNumber, String emailAdress, Suplier suplier) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.suplier = suplier;
    }

    public Stand() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Suplier getSuplier() {
        return suplier;
    }


    public void setPhoneNumber(int phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        emailAdress = emailAdress;
    }
    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }
}
