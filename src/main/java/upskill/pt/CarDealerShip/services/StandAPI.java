package upskill.pt.CarDealerShip.services;

import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Suplier;
import upskill.pt.CarDealerShip.models.Vehicle;

public interface StandAPI {
    public Vehicle BuyVehicle(int id); //create
    public Vehicle ListVehicles();
    public Vehicle ListVehicle();
    public Vehicle UpdateVehicle(int id, Vehicle vehicle);
    public Vehicle DeleteVehicle(int id, Vehicle vehicle);

    public Vehicle ChangeVehicleStatus(int id, StatusEnum status);

    public Suplier AddSuplier(Suplier suplier);
    public Suplier ListSuplier();
    public Suplier UpdateSuplier(int id, Suplier suplier);
    public Suplier DeleteSuplier(int id, Suplier suplier);


    /*public Vehicle CreateVehicle();*/
}
