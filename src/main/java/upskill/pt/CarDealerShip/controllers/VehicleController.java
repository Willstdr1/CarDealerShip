package upskill.pt.CarDealerShip.controllers;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.pt.CarDealerShip.dto.StatusDTO;
import upskill.pt.CarDealerShip.dto.VehicleDTO;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.VehicleApi;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/")
public class VehicleController {
    @Autowired
    VehicleApi storage; // não precisa de ter o nome do "VehicleApImpl" o nome da interface é melhor

    @GetMapping("/vehicles")
    public ResponseEntity<CollectionModel<VehicleDTO>> getVehicles(@RequestParam(name = "page") Optional<Integer> page,
                                                                   @RequestParam(name = "size") Optional<Integer> size,
                                                                   @RequestParam(name = "sort")  Optional<String> sort){
        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("id");

        Page<VehicleDTO> vei = this.storage.listVehicles(_page, _size, _sort);
        vei = vei.map((VehicleDTO v)-> v.add(linkTo(methodOn(VehicleController.class).getVehicles(page, size, sort)).withSelfRel()));
        Link link = linkTo(methodOn(VehicleController.class).getVehicles(Optional.of(1),Optional.of(10), Optional.of("id"))).withSelfRel();
        List<Link> links = new ArrayList<>();
        links.add(link);
        if(!vei.isLast()) {
            Link _link = linkTo(methodOn(VehicleController.class).getVehicles(Optional.of(_page + 1), size, Optional.of("id"))).withRel("next");
            links.add(_link);
        }
        if(!vei.isFirst()) {
            Link _link = linkTo(methodOn(VehicleController.class).getVehicles(Optional.of(_page - 1), size, Optional.of("id"))).withRel("previous");
            links.add(_link);
        }
        return ResponseEntity.ok(CollectionModel.of(vei.toList(), links));
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
