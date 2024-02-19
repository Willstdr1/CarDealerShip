package upskill.pt.CarDealerShip.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.pt.CarDealerShip.models.Supplier;
import upskill.pt.CarDealerShip.services.SupplierApi;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SupplierController {

    SupplierApi storage; // não precisa de ter o nome do "StandAPImpl" ele sabe por causa da interface

    @GetMapping(value= "/suppliers/{page}", produces = "application/json")
    public ResponseEntity<List<Supplier>> listSuppliers(@PathVariable("page") int page){
        List<Supplier> supp = storage.listSupliers(page);

        return new ResponseEntity<>(supp, HttpStatus.OK);
        //ToDo: exexon
    }

    @GetMapping(value= "/supplier/{id}", produces = "application/json")
    public ResponseEntity<Supplier> listSupplier(@PathVariable("id")int id){

        return new ResponseEntity<> (storage.listSupplier(id), HttpStatus.OK);

    }

    @PostMapping(value= "/supplier", consumes = "application/json", produces = "aplication/json")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
        storage.createSupplier(supplier);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PutMapping(value= "/supplier/{id}", produces = "application/json")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id")int id, @RequestBody Supplier supplier){
        if(supplier.getId()==id){
            return new ResponseEntity<>(storage.updateSupplier(supplier), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value= "/supplier/{id}", produces = "aplication/json")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("id") int id){
        if (id>=0){
            storage.deleteSupplier(id);
            return new ResponseEntity<>(storage.deleteSupplier(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
