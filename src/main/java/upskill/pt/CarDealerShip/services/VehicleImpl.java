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
public class VehicleImpl implements VehicleApi {

    @Autowired
    VehicleRepository storage;

    public VehicleImpl(VehicleRepository storage){
    this.storage = storage;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        if(storage.existsById(vehicle.getId())){
            throw new NotImplementedException();
        }

        storage.save(vehicle);
    }

    @Override
    public List<Vehicle> listVehicles(int page) {
        int[] a = new int []{0,0};
        if(page==1){
            a[1]=99;
        }else{
            a[0]=page*100-100;
            a[1]=page*100-1;
        }

        return storage.findAll().subList(a[0],Math.min(a[1] + 1, storage.findAll().size())) ;
    }

    @Override
    public Vehicle listVehicle(int id) {
        if (storage.existsById(id)) {
            return storage.findById(id).get();
        }else {
            throw new NotImplementedException();
        }
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
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
                veic.setStand(vehicle.getStand());
            }
            storage.save(veic);
            return veic;
        }
        throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
    }

    @Override
    public Vehicle deleteVehicle(int id) {
        if (storage.existsById(id)) {
            Vehicle v = storage.findById(id).orElse(null);
            if (v != null) {
                storage.delete(v);
                return v;
            } else {
                throw new EntityNotFoundException("Vehicle with ID " + id + " not found.");
            }
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + id + " not found.");
        }
    }


    @Override
    public Vehicle ChangeVehicleStatus (Vehicle vehicle, StatusEnum newStatus){
        if (storage.existsById(vehicle.getId())) {
            Vehicle existVehicle = storage.findById(vehicle.getId()).orElse(null);
            if (existVehicle != null) {
                existVehicle.setStatus(newStatus);
                return storage.save(existVehicle);
            } else {
                throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
            }
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
        }
    }



}
