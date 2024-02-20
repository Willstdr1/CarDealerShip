package upskill.pt.CarDealerShip.services;

import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Vehicle;

import java.util.List;

public interface VehicleApi {
    public void createVehicle(Vehicle vehicle); //create
    public List<Vehicle> listVehicles(int page);
    public Vehicle listVehicle(int id);
    public Vehicle updateVehicle(Vehicle vehicle);
    public Vehicle deleteVehicle(int id);
    public Vehicle changeVehicleStatus(int id, StatusEnum newStatus);
    public Vehicle markVeAsSold(int id, StatusEnum newStatus);
    public List<Vehicle> ListVehiclesInStock();
    public List<Vehicle> ListVehiclesSold();
    public List<Vehicle> ListVehiclesBought();
    public List<Vehicle> ListVehiclesAsProcessing();



}
