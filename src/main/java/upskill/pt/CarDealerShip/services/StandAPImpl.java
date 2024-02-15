package upskill.pt.CarDealerShip.services;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.repos.VehicleRepository;

import java.util.List;

@Service
public class StandAPImpl implements StandAPI{

    @Autowired
    VehicleRepository storage;

    public StandAPImpl(VehicleRepository storage){
    this.storage = storage;
    }

    @Override
    public void BuyVehicle(Vehicle vehicle) {
        if(storage.existsById(vehicle.getId())){
            throw new NotImplementedException();
        }

        storage.save(vehicle);
    }

    @Override
    public List<Vehicle> ListVehicles(int page) {
        int[] a = new int []{0,0};
        if(page==1){
            a[1]=99;
        }else{
            a[0]=page*100-100;
            a[1]=page*100-1;
        }
        return storage.findAll().subList(a[0],a[1]) ;
    }

    @Override
    public Vehicle ListVehicle(int id) {
        if (storage.existsById(id)) {
            return storage.findById(id).get();
        }else {
            throw new NotImplementedException();
        }
    }

    @Override
    public Vehicle UpdateVehicle(int id, Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle DeleteVehicle(int id, Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle ChangeVehicleStatus(int id, StatusEnum status) {
        return null;
    }

}
