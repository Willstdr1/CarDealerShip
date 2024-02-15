package upskill.pt.CarDealerShip.services;

import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Suplier;
import upskill.pt.CarDealerShip.models.Vehicle;

import java.util.List;

public interface StandAPI {
    public void BuyVehicle(Vehicle vehicle); //create
    public List<Vehicle> ListVehicles(int page);
    public Vehicle ListVehicle(int id);
    public Vehicle UpdateVehicle(int id, Vehicle vehicle);
    public Vehicle DeleteVehicle(int id, Vehicle vehicle);
    public Vehicle ChangeVehicleStatus(int id, StatusEnum status);
/*    public Suplier AddSuplier(Suplier suplier);
    public Suplier ListSuplier();
    public Suplier UpdateSuplier(int id, Suplier suplier);
    public Suplier DeleteSuplier(int id, Suplier suplier);*/


    /*public Vehicle CreateVehicle();*/
}
