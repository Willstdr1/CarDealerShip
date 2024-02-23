package upskill.pt.CarDealerShip.services;


import jakarta.transaction.Status;
import org.springframework.data.domain.Page;
import upskill.pt.CarDealerShip.dto.VehicleDTO;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Vehicle;

import java.util.List;

public interface VehicleApi {
    public VehicleDTO createVehicle(Vehicle vehicle);
    public Page<VehicleDTO> listVehicles(int page, int size, String sort);
    public Vehicle listVehicle(int id);
    public Vehicle updateVehicle(Vehicle vehicle);
    public Vehicle deleteVehicle(int id);
    public Vehicle changeVehicleStatus(int id, StatusEnum newStatus);
    public Vehicle markVeAsSold(int id, int transactionID);

    public Page<VehicleDTO> listVehiclesByStatus(StatusEnum status, int page, int size, String sort);
    public Page<VehicleDTO> listVehicleByTransaction(int transaction, int page, int size, String sort);
    public Page<VehicleDTO> listVehicleByBrandId(int brandID, int page, int size, String sort);




}


//    public void createVehicle(Vehicle vehicle); //create
//    public List<Vehicle> listVehicles(int page);
//    public Vehicle listVehicle(int id);
//    public Vehicle updateVehicle(Vehicle vehicle);
//    public Vehicle deleteVehicle(int id);
//    public Vehicle changeVehicleStatus(int id, StatusEnum newStatus);
//    public Vehicle markVeAsSold(int id);
//    public List<Vehicle> listVehiclesInStock();
//    public List<Vehicle> listVehiclesSold();
//    public List<Vehicle> listVehiclesBought();
//    public List<Vehicle> listVehiclesAsProcessing();