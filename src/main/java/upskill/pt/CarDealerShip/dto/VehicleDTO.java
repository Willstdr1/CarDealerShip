package upskill.pt.CarDealerShip.dto;

import org.springframework.hateoas.RepresentationModel;
import upskill.pt.CarDealerShip.enums.ConditionEnum;
import upskill.pt.CarDealerShip.enums.FuelEnum;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.enums.TypeEnum;
import upskill.pt.CarDealerShip.models.*;

public class VehicleDTO extends RepresentationModel<VehicleDTO> {

    private int id;
    private VehicleModel model;
    private String licensePlate;
    private FuelEnum fuel;
    private TypeEnum type;
    private StatusEnum status;
    private Suplier suplier;
    private ConditionEnum conditionEnum;
    private double kilometers;

    public VehicleDTO(int id, VehicleModel model, String licensePlate, FuelEnum fuel, TypeEnum type, StatusEnum status, Suplier suplier, ConditionEnum conditionEnum, double kilometers) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.fuel = fuel;
        this.type = type;
        this.status = status;
        this.suplier = suplier;
        this.conditionEnum = conditionEnum;
        this.kilometers = kilometers;
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

    public FuelEnum getFuel() {
        return fuel;
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
        return conditionEnum;
    }

}
