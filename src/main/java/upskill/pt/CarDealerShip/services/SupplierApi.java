package upskill.pt.CarDealerShip.services;

import upskill.pt.CarDealerShip.models.Supplier;

import java.util.List;

public interface SupplierApi {

    public void createSupplier(Supplier supplier);
    public List<Supplier> listSupliers(int page);
    public Supplier listSupplier(int id);
    public Supplier updateSupplier(Supplier supplier);
    public Supplier deleteSupplier(int id);
}
