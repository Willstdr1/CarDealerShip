package upskill.pt.CarDealerShip.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.NotImplementedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import upskill.pt.CarDealerShip.dto.VehicleDTO;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.repos.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleImpl implements VehicleApi {

    @Autowired
    VehicleRepository storage;

    public VehicleImpl(VehicleRepository storage){
    this.storage = storage;
    }

    @Transactional
    @Override
    public VehicleDTO createVehicle(Vehicle vehicle) {
        if (storage.existsById(vehicle.getId())) {
            throw new EntityExistsException("Vehicle with ID " + vehicle.getId() + " already exists.");
        }

        VehicleDTO v2 = new VehicleDTO();

        storage.save(vehicle);

        return  VehicleDTO.toVehicleDTO(vehicle);
    }


    @Override
    public Page<VehicleDTO> listVehicles(int page, int size, String sort) {
        return this.storage.findAll(PageRequest.of(page, size, Sort.by(sort))).map(VehicleDTO::toVehicleDTO) ;

    }

    @Override
    public Vehicle listVehicle(int id) {
        if (storage.existsById(id)) {
            return storage.findById(id).get();
        }else {
            throw new NotImplementedException();
        }
    }

    @Transactional
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
                veic.setSupplier(vehicle.getSupplier());
                veic.setCondition(vehicle.getCondition());
                veic.setStand(vehicle.getStand());
            }
            storage.save(veic);
            return veic;
        }
        throw new EntityNotFoundException("Vehicle with ID " + vehicle.getId() + " not found.");
    }

    @Transactional
    @Override
    public Vehicle deleteVehicle(int id) {
            Vehicle v = storage.findById(id).orElse(null);
            if (v != null) {
                storage.delete(v);
                return v;
            } else {
                throw new EntityNotFoundException("Vehicle with ID " + id + " not found.");
            }
    }


    @Transactional
    @Override
    public Vehicle changeVehicleStatus(int id, StatusEnum newStatus) {
        Vehicle existVehicle = storage.findById(id).orElse(null);
        if (existVehicle != null) {
            existVehicle.setStatus(newStatus);
            return storage.save(existVehicle);
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + id + " not found.");
        }
    }

    @Transactional
    @Override
    public Vehicle markVeAsSold(int id, int transactionID) {
        Vehicle existVehicle = storage.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Vehicle with ID " + id + " not found."));
        existVehicle.setStatus(StatusEnum.SOLD);
        existVehicle.setTransaction(transactionID);
        return storage.save(existVehicle);
    }


    @Override
    public Page<VehicleDTO> listVehiclesByStatus(StatusEnum status, int page, int size, String sort){
        return storage.findByStatus(status, PageRequest.of(page,size, Sort.by(sort))).map(VehicleDTO::toVehicleDTO);
    }

    @Override
    public Page<VehicleDTO> listVehicleByTransaction(int transaction, int page, int size, String sort){
        return storage.findByTransaction(transaction, PageRequest.of(page, size, Sort.by(sort))).map(VehicleDTO::toVehicleDTO);
    }

    @Override
    public Page<VehicleDTO> listVehicleByBrandId(int brandID, int page, int size, String sort){
        return storage.findByBrandId(brandID, PageRequest.of(page, size, Sort.by(sort))).map(VehicleDTO::toVehicleDTO);
    }



    //@Transactional ou vai tudo ou nada da info
    //@Getter @Setter @NoArgsConstructor @AllArgsConstructor -> lombok atalhos para menos work
}
