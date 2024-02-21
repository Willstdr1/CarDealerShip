package upskill.pt.CarDealerShip.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import upskill.pt.CarDealerShip.models.Brand;
import upskill.pt.CarDealerShip.models.VehicleModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModelDTO extends RepresentationModel<BrandDTO> {
    int id;
    Brand brand;
    String name;


    public static VehicleModelDTO toVehicleModelDTO(VehicleModel vm){
        return new VehicleModelDTO(vm.getId(), vm.getBrand(), vm.getName());
    }
}
