package upskill.pt.CarDealerShip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import upskill.pt.CarDealerShip.models.Brand;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO extends RepresentationModel<BrandDTO> {

    int id;
    String Name;

    public static BrandDTO toBrandDTO(Brand b){
        return new BrandDTO(b.getId(), b.getName());
    }
}
