package upskill.pt.CarDealerShip.services;

import upskill.pt.CarDealerShip.models.Brand;
import upskill.pt.CarDealerShip.models.Vehicle;
import upskill.pt.CarDealerShip.models.VehicleModel;

import java.util.List;

public interface BrandModelApi {

    public void createBrand(Brand brand); //create
    public List<Brand> listBrands(int page);
    public Brand listBrand(int id);
    public Brand updateBrand(Brand brand);
    public Brand deleteBrand(int id);


    public void createModel(VehicleModel model); //create
    public List<VehicleModel> listModels(int page);
    public VehicleModel listModel(int id);
    public VehicleModel updateModel(VehicleModel model);
    public VehicleModel deleteModel(int id);

}
