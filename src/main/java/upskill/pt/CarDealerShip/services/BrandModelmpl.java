package upskill.pt.CarDealerShip.services;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upskill.pt.CarDealerShip.models.Brand;
import upskill.pt.CarDealerShip.models.VehicleModel;
import upskill.pt.CarDealerShip.services.repos.BrandRepository;
import upskill.pt.CarDealerShip.services.repos.ModelRepository;

import java.util.List;
@Service
public class BrandModelmpl implements BrandModelApi{

    @Autowired
    BrandRepository storage;
    @Autowired
    ModelRepository storage2;


    @Override
    public void createBrand(Brand brand) {
        if(storage.existsById(brand.getId())){
            throw new NotImplementedException();
        }

        storage.save(brand);
    }

    @Override
    public List<Brand> listBrands(int page) {
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
    public Brand listBrand(int id) {
        if (storage.existsById(id)) {
            return storage.findById(id).get();
        }else {
            throw new NotImplementedException();
        }
    }

    @Override
    public Brand updateBrand(Brand brand) {
        if (storage.existsById(brand.getId())){
            Brand brand1 = storage.findById(brand.getId()).orElse(null);
            if( brand1 != null){
                brand1.setName(brand.getName());
            }
            storage.save(brand1);
            return brand1;
        }
        throw new EntityNotFoundException("Brand with ID " + brand.getId() + " not found.");
    }

    @Override
    public Brand deleteBrand(int id) {
        if (storage.existsById(id)) {
            Brand b = storage.findById(id).orElse(null);
            if (b != null) {
                storage.delete(b);
                return b;
            } else {
                throw new EntityNotFoundException("Brand with ID " + id + " not found.");
            }
        } else {
            throw new EntityNotFoundException("Brand with ID " + id + " not found.");
        }
    }

    @Override
    public void createModel(VehicleModel model) {
        if(storage2.existsById(model.getId())){
            throw new NotImplementedException();
        }
        storage2.save(model);//ToDo: isto é posisvel que nao funque
    }

    @Override
    public List<VehicleModel> listModels(int page) {
        int[] a = new int []{0,0};
        if(page==1){
            a[1]=99;
        }else{
            a[0]=page*100-100;
            a[1]=page*100-1;
        }

        return storage2.findAll().subList(a[0],Math.min(a[1] + 1, storage2.findAll().size())) ;
    }

    @Override
    public VehicleModel listModel(int id) {
        if (storage2.existsById(id)) {
            return storage2.findById(id).get();
        }else {
            throw new NotImplementedException();
        }
    }

    @Override
    public VehicleModel updateModel(VehicleModel model) {
        if (storage2.existsById(model.getId())){
            VehicleModel mod = storage2.findById(model.getId()).orElse(null);
            if( mod != null){
                mod.setId(model.getId());
                mod.setBrand(model.getBrand());
                mod.setName(model.getName());
            }
            storage2.save(mod);
            return mod;
        }
        throw new EntityNotFoundException("Model with ID " + model.getId() + " not found.");
    }

    @Override
    public VehicleModel deleteModel(int id) {
        if (storage2.existsById(id)) {
            VehicleModel mod = storage2.findById(id).orElse(null);
            if (mod != null) {
                storage2.delete(mod);
                return mod;
            } else {
                throw new EntityNotFoundException("Model with ID " + id + " not found.");
            }
        } else {
            throw new EntityNotFoundException("Model with ID " + id + " not found.");
        }
    }
}
