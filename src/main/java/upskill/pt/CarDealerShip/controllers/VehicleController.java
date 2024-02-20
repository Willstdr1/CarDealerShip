package upskill.pt.CarDealerShip.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.pt.CarDealerShip.dto.StatusDTO;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.VehicleApi;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/")
public class VehicleController {
    @Autowired
    VehicleApi storage; // não precisa de ter o nome do "VehicleApi" o nome da interface é melhor

    @GetMapping(value= "/vehicles/{page}", produces = "application/json")
    public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable("page") int page){
        List<Vehicle> v = storage.listVehicles(page);

        return new ResponseEntity<>(v, HttpStatus.OK);
        //ToDo: exexon
    }

    @GetMapping(value= "/vehicle/{id}", produces = "application/json")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id")int id){

        return new ResponseEntity<> (storage.listVehicle(id), HttpStatus.OK);

    }

    @PostMapping(value= "/vehicle", consumes = "application/json", produces = "aplication/json")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        storage.createVehicle(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PutMapping(value= "/vehicle/{id}", produces = "application/json")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id")int id, @RequestBody Vehicle vehicle){
        if(vehicle.getId()==id){
            return new ResponseEntity<>(storage.updateVehicle(vehicle), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value= "/vehicle/{id}", produces = "aplication/json")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") int id){
        if (id>=0){
            storage.deleteVehicle(id);
                return new ResponseEntity<>(storage.deleteVehicle(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping(value= "/vehicle/{id}/status", produces = "application/json")
    public ResponseEntity<Vehicle> changeVehicleStatus(@PathVariable("id") int id, @RequestBody StatusDTO newStatus){
        try {
            Vehicle updatedVehicle = storage.changeVehicleStatus(id, newStatus.getStatus());
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping(value= "/vehicle/{id}/sold", produces = "application/json")
    public ResponseEntity<Vehicle> markVehicleAsSold(@PathVariable("id") int id) {
        try {
            Vehicle updatedVehicle = storage.markVeAsSold(id);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value= "/vehicles/stock", produces = "application/json")
    public ResponseEntity<List<Vehicle>> listVehiclesInStock() {
        List<Vehicle> v = storage.listVehiclesInStock();
        return new ResponseEntity<>(v, HttpStatus.OK);
    }

    @GetMapping(value= "/vehicles/sold", produces = "application/json")
    public ResponseEntity<List<Vehicle>> listVehiclesSold(){
        List<Vehicle> v = storage.listVehiclesSold();

        return new ResponseEntity<>(v, HttpStatus.OK);
        //ToDo: exexon
    }

    @GetMapping(value= "/vehicles/bought", produces = "application/json")
    public ResponseEntity<List<Vehicle>> listVehiclesBought(){
        List<Vehicle> v = storage.listVehiclesBought();

        return new ResponseEntity<>(v, HttpStatus.OK);
        //ToDo: exexon
    }

    @GetMapping(value= "/vehicles/processing", produces = "application/json")
    public ResponseEntity<List<Vehicle>> listVehiclesAsProcessing(){
        List<Vehicle> v = storage.listVehiclesAsProcessing();

        return new ResponseEntity<>(v, HttpStatus.OK);
        //ToDo: exexon
    }

}
