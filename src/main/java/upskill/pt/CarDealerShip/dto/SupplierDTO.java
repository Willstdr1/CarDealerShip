package upskill.pt.CarDealerShip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import upskill.pt.CarDealerShip.models.Supplier;
import upskill.pt.CarDealerShip.models.Vehicle;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO extends RepresentationModel<SupplierDTO> {

    int id;
    String Name;
    String Email;
    int PhoneNumber;

    public static SupplierDTO toSupplierDTO(Supplier s){
        return new SupplierDTO(s.getId(), s.getName(), s.getEmail(), s.getPhoneNumber());
    }
}
