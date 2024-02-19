package upskill.pt.CarDealerShip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.pt.CarDealerShip.models.Brand;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.models.VehicleModel;
import upskill.pt.CarDealerShip.services.BrandModelApi;
import upskill.pt.CarDealerShip.services.VehicleApi;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class BrandModelController {


    @Autowired
    BrandModelApi storage; // não precisa de ter o nome do "StandAPImpl" ele sabe por causa da interface

    @GetMapping(value= "/brand/{page}", produces = "application/json")
    public ResponseEntity<List<Brand>> getBrands(@PathVariable("page") int page){
        List<Brand> v = storage.listBrands(page);

        return new ResponseEntity<>(v, HttpStatus.OK);
        //ToDo: exexon
    }

    @GetMapping(value= "/brand/{id}", produces = "application/json")
    public ResponseEntity<Brand> getBrand(@PathVariable("id")int id){

        return new ResponseEntity<> (storage.listBrand(id), HttpStatus.OK);

    }

    @PostMapping(value= "/brand", consumes = "application/json", produces = "aplication/json")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand){
        storage.createBrand(brand);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PutMapping(value= "/brand/{id}", produces = "application/json")
    public ResponseEntity<Brand> updateBrand(@PathVariable("id")int id, @RequestBody Brand brand){
        if(brand.getId()==id){
            return new ResponseEntity<>(storage.updateBrand(brand), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value= "/brand/{id}", produces = "aplication/json")
    public ResponseEntity<Brand> deleteBrand(@PathVariable("id") int id){
        if (id>=0){
            storage.deleteBrand(id);
            return new ResponseEntity<>(storage.deleteBrand(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value= "/model/{page}", produces = "application/json")
    public ResponseEntity<List<VehicleModel>> getModels(@PathVariable("page") int page){
        List<VehicleModel> mod = storage.listModels(page);

        return new ResponseEntity<>(mod, HttpStatus.OK);
        //ToDo: exexon
    }

    @GetMapping(value= "/model/{id}", produces = "application/json")
    public ResponseEntity<VehicleModel> getModel(@PathVariable("id")int id){

        return new ResponseEntity<> (storage.listModel(id), HttpStatus.OK);

    }

    @PostMapping(value= "/model", consumes = "application/json", produces = "aplication/json")
    public ResponseEntity<VehicleModel> createModel(@RequestBody VehicleModel model){
        storage.createModel(model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping(value= "/model/{id}", produces = "application/json")
    public ResponseEntity<VehicleModel> updateModel(@PathVariable("id")int id, @RequestBody VehicleModel model){
        if(model.getId()==id){
            return new ResponseEntity<>(storage.updateModel(model), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value= "/model/{id}", produces = "aplication/json")
    public ResponseEntity<VehicleModel> deleteModel(@PathVariable("id") int id){
        if (id>=0){
            storage.deleteModel(id);
            return new ResponseEntity<>(storage.deleteModel(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
