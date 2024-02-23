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
    double initialPrice;
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

    public static VehicleDTO toVehicleDTO(Vehicle vehicle){
        return new VehicleDTO(vehicle.getId(), vehicle.getModel(), vehicle.getLicensePlate(), vehicle.getInitialPrice(), vehicle.getNumberOfSeats(), vehicle.getTraction(), vehicle.getFuel(), vehicle.getColor(),  vehicle.getNumberOfDoors(), vehicle.getType(), vehicle.getStatus(), vehicle.getSupplier(), vehicle.getCondition(),  vehicle.getStand(), vehicle.getTransaction());
    }

/*    public static Vehicle toVehicle(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle();

        if(vehicleDTO!=null){
            vehicle.setId(vehicleDTO.getId());
            vehicle.setModel(vehicleDTO.getModel());
            vehicle.setLicensePlate(vehicleDTO.getLicensePlate());
            vehicle.setNumberOfSeats(vehicleDTO.getNumberOfSeats());
            vehicle.setTraction(vehicleDTO.getTraction());
            vehicle.setFuel(vehicleDTO.getFuel());
            vehicle.setColor(vehicleDTO.getColor());
            vehicle.setNumberOfDoors(vehicleDTO.getNumberOfDoors());
            vehicle.setType(vehicleDTO.getType());
            vehicle.setStatus(vehicleDTO.getStatus());
            vehicle.setSupplier(vehicleDTO.getSupplier());
            vehicle.setCondition(vehicleDTO.getCondition());
            vehicle.setStand(vehicleDTO.getStand());
            vehicle.setTransaction(vehicleDTO.getTransaction());
        }
        return vehicle;
    }*/

}
