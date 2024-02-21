package upskill.pt.CarDealerShip.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import upskill.pt.CarDealerShip.enums.*;
import upskill.pt.CarDealerShip.models.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO extends RepresentationModel<VehicleDTO> {



    int id;
    VehicleModel model;
    String licensePlate;
    int numberOfSeats;
    TractionEnum traction;
    FuelEnum fuel;
    String color;
    int numberOfDoors;
    TypeEnum type;
    StatusEnum status;
    Supplier supplier;
    ConditionEnum condition;
    Stand stand;
    int transaction;

    public static VehicleDTO toVehicleDTO(Vehicle v){
        return new VehicleDTO(v.getId(), v.getModel(), v.getLicensePlate(), v.getNumberOfSeats(), v.getTraction(), v.getFuel(), v.getColor(),  v.getNumberOfDoors(), v.getType(), v.getStatus(), v.getSupplier(), v.getCondition(),  v.getStand(), v.getTransaction());
    }

    public static Vehicle toVehicle(VehicleDTO v){
        return new Vehicle(v.getId(), v.getModel(), v.getLicensePlate(), v.getNumberOfSeats(), v.getTraction(), v.getFuel(), v.getColor(),  v.getNumberOfDoors(), v.getType(), v.getStatus(), v.getSupplier(), v.getCondition(),  v.getStand(), v.getTransaction());
    }

}
