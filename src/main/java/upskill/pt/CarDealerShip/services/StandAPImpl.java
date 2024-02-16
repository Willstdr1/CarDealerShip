package upskill.pt.CarDealerShip.services;

import jakarta.persistence.EntityNotFoundException;
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
    public Vehicle UpdateVehicle(Vehicle vehicle) {
        if (storage.existsById(vehicle.getId())){
            Vehicle veic = storage.findById(vehicle.getId()).orElse(null);
            if( veic != null){
                veic.setModel(vehicle.getModel());
                veic.setLicensePlate(vehicle.getLicensePlate());
                veic.setNumberOfSeats(vehicle.getNumberOfSeats());
                veic.setTraction(vehicle.getTraction());
                veic.setFuel(vehicle.getFuel());
                veic.setColor(vehicle.getColor());
                veic.setNumberOfDoors(vehicle.getNumberOfDoors());
                veic.setType(vehicle.getType());
                veic.setStatus(vehicle.getStatus());
                veic.setSuplier(vehicle.getSuplier());
                veic.setCondition(vehicle.getCondition());
            }
            storage.save(veic);
            return veic;
        }
        throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
    }

    @Override
    public Vehicle DeleteVehicle(Vehicle vehicle) {
        if (storage.existsById(vehicle.getId())){
            storage.delete(vehicle);
            return vehicle;
        }else {
        throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
        }
    }

    @Override
    public Vehicle ChangeVehicleStatus(Vehicle vehicle, StatusEnum newStatus) {
        if(storage.existsById(vehicle.getId())){
            Vehicle existVehicle = storage.findById(vehicle.getId()).orElse(null);
        if(existVehicle!=null){
            existVehicle.setStatus(newStatus);
            return storage.save(existVehicle);
        }else {
            throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
        }
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
        }
    }

}
