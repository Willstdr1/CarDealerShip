package upskill.pt.CarDealerShip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.StandAPI;
import upskill.pt.CarDealerShip.services.StandAPImpl;
import upskill.pt.CarDealerShip.services.repos.VehicleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StandController {
    @Autowired
    StandAPImpl storage;

    @GetMapping(value= "/vehicles/{page}", produces = "application/json")
    public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable("page") int page){
        List<Vehicle> v = storage.ListVehicles(page);

        return new ResponseEntity<>(v, HttpStatus.OK);
        //ToDo: exexecon
    }

    @GetMapping(value= "/vehicle/{id}", produces = "application/json")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id")int id){

        return new ResponseEntity<> (storage.ListVehicle(id), HttpStatus.OK);

    }

    @PutMapping(value= "/vehicle/{vehicle}", produces = "application/json")
    public ResponseEntity<Vehicle> buyVehicle(@PathVariable("vehicle")Vehicle vehicle){
        storage.BuyVehicle(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }



}
