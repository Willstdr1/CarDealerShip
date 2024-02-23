package upskill.pt.CarDealerShip.models;

import jakarta.persistence.*;
import upskill.pt.CarDealerShip.enums.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private VehicleModel model;
    private String licensePlate;
    private double initialPrice;
    private int numberOfSeats;
    @Enumerated(EnumType.STRING)
    private TractionEnum traction;
    @Enumerated(EnumType.STRING)
    private FuelEnum fuel;
    private String color;
    private int numberOfDoors;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @ManyToOne
    private Supplier supplier;
    @Enumerated(EnumType.STRING)
    private ConditionEnum condition;
    @ManyToOne
    private Stand stand;
    private int transaction;

    public Vehicle(int id, VehicleModel model, String licensePlate, double initialPrice, int numberOfSeats, TractionEnum traction, FuelEnum fuel, String color, int numberOfDoors, TypeEnum type, StatusEnum status, Supplier supplier, ConditionEnum condition, Stand stand, int transaction) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.initialPrice = initialPrice;
        this.numberOfSeats = numberOfSeats;
        this.traction = traction;
        this.fuel = fuel;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.type = type;
        this.status = status;
        this.supplier = supplier;
        this.condition = condition;
        this.stand = stand;
        this.transaction = transaction;
    }

    public Vehicle() {
    }

    public int getTransaction() {
        return transaction;
    }

    public int getId() {
        return id;
    }

    public VehicleModel getModel() {
        return model;
    }
    public String getLicensePlate() {
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

    public double getInitialPrice() {
        return initialPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public void setLicensePlate(String licensePlate) {
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

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setCondition(ConditionEnum conditionEnum) {
        this.condition = conditionEnum;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }
}
