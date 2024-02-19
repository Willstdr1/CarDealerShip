package upskill.pt.CarDealerShip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.VehicleApi;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class VehicleController {
    @Autowired
    VehicleApi storage; // não precisa de ter o nome do "StandAPImpl" ele sabe por causa da interface

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
    public ResponseEntity<Vehicle> buyVehicle(@RequestBody Vehicle vehicle){
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

}
