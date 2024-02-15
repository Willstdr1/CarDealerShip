package upskill.pt.CarDealerShip.models;

import jakarta.persistence.*;

public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne//ToDo: se calhar é ao contraio
    private Brand brand;
    private String name;

    public VehicleModel(int id, Brand brand, String name) {
        this.id = id;
        this.brand = brand;
        this.name = name;
    }
    public VehicleModel() {
    }

    public int getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }
}
