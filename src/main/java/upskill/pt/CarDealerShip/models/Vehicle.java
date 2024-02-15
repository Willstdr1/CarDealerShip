package upskill.pt.CarDealerShip.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import upskill.pt.CarDealerShip.enums.FuelEnum;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.enums.TractionEnum;
import upskill.pt.CarDealerShip.enums.TypeEnum;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private VehicleModel model;
    private License licensePlate;
    private int numberOfSeats;
    private TractionEnum traction;
    private FuelEnum fuel;
    private String color;
    private int numberOfDoors;
    private TypeEnum type;
    private StatusEnum status;
    private Suplier suplier;

    private Condition condition;
    private double kilometers;

    public Vehicle(int id, VehicleModel model, License licensePlate, int numberOfSeats, TractionEnum traction, FuelEnum fuel, String color, int numberOfDoors, TypeEnum type, StatusEnum status, Suplier suplier, Condition condition, double kilometers) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.numberOfSeats = numberOfSeats;
        this.traction = traction;
        this.fuel = fuel;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.type = type;
        this.status = status;
        this.suplier = suplier;
        this.condition = condition;
        this.kilometers = kilometers;
    }

    public int getId() {
        return id;
    }

    public VehicleModel getModel() {
        return model;
    }
    public License getLicensePlate() {
        return licensePlate;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public TractionEnum getTraction() {
        return traction;
    }

    public FuelEnum getFuel() {
        return fuel;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public TypeEnum getType() {
        return type;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public Suplier getSuplier() {
        return suplier;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getKilometers() {
        return kilometers;
    }
    public void setId(int id) {
        this.id = id;
    }


    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public void setLicensePlate(License licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setTraction(TractionEnum traction) {
        this.traction = traction;
    }

    public void setFuel(FuelEnum fuel) {
        this.fuel = fuel;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }
}
