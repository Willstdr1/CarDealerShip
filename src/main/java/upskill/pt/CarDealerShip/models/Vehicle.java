package upskill.pt.CarDealerShip.models;

import upskill.pt.CarDealerShip.enums.FuelEnum;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.enums.TractionEnum;
import upskill.pt.CarDealerShip.enums.TypeEnum;

public class Vehicle {

    private int id;
    private Brand brand;
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

    public Vehicle(int id, Brand brand, VehicleModel model, License licensePlate, int numberOfSeats, TractionEnum traction, FuelEnum fuel, String color, int numberOfDoors, TypeEnum type, StatusEnum status, Suplier suplier) {
        this.id = id;
        this.brand = brand;
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
    }

    public int getId() {
        return id;
    }
    public Brand getBrand() {
        return brand;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

}
