package upskill.pt.CarDealerShip.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Suplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String Name;
    public String Email;
    public int PhoneNumber;

    public Suplier(int id, String name, String email, int phoneNumber) {
        this.id = id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
