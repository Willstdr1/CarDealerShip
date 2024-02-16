package upskill.pt.CarDealerShip.models;

import jakarta.persistence.*;
import upskill.pt.CarDealerShip.enums.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private VehicleModel model;
    private String licensePlate;
    private int numberOfSeats;
    @Enumerated
    private TractionEnum traction;
    @Enumerated
    private FuelEnum fuel;
    private String color;
    private int numberOfDoors;
    @Enumerated
    private TypeEnum type;
    @Enumerated
    private StatusEnum status;
    @OneToOne
    private Suplier suplier;
    @Enumerated
    private ConditionEnum condition;
    @ManyToOne(cascade = CascadeType.ALL)
    private Stand stand;

    public Vehicle(int id, VehicleModel model, String licensePlate, int numberOfSeats, TractionEnum traction, FuelEnum fuel, String color, int numberOfDoors, TypeEnum type, StatusEnum status, Suplier suplier, ConditionEnum condition, Stand stand) {
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
        this.stand = stand;
    }


    public Vehicle() {
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

    public Suplier getSuplier() {
        return suplier;
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

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    public void setCondition(ConditionEnum conditionEnum) {
        this.condition = conditionEnum;
    }

}
