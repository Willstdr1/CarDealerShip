package upskill.pt.CarDealerShip.services;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upskill.pt.CarDealerShip.models.Supplier;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.services.repos.SupplierRepository;
import upskill.pt.CarDealerShip.services.repos.VehicleRepository;

import java.util.List;

@Service
public class SupplierImpl implements SupplierApi{

    @Autowired
    SupplierRepository storage;

    public SupplierImpl(SupplierRepository storage){
        this.storage = storage;
    }



    @Override
    public void createSupplier(Supplier supplier) {
        if(storage.existsById(supplier.getId())){
            throw new NotImplementedException();
        }

        storage.save(supplier);
    }

    @Override
    public List<Supplier> listSupliers(int page) {
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
    public Supplier listSupplier(int id) {
        if (storage.existsById(id)) {
            return storage.findById(id).get();
        }else {
            throw new NotImplementedException();
        }
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        if (storage.existsById(supplier.getId())){
            Supplier supp = storage.findById(supplier.getId()).orElse(null);
            if( supp != null){
                supp.setName(supplier.getName());
                supp.setEmail(supplier.getEmail());
                supp.setPhoneNumber(supplier.getPhoneNumber());
            }
            storage.save(supp);
            return supp;
        }
        throw new EntityNotFoundException("Vehicle with ID " + supplier.getId() + " not found.");
    }

    @Override
    public Supplier deleteSupplier(int id) {
        if (storage.existsById(id)) {
            Supplier supp = storage.findById(id).orElse(null);
            if (supp != null) {
                storage.delete(supp);
                return supp;
            } else {
                throw new EntityNotFoundException("Vehicle with ID " + id + " not found.");
            }
        } else {
            throw new EntityNotFoundException("Vehicle with ID " + id + " not found.");
        }
    }
}
