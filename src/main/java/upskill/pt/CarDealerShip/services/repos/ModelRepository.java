package upskill.pt.CarDealerShip.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.pt.CarDealerShip.models.VehicleModel;

public interface ModelRepository extends JpaRepository<VehicleModel,Integer> {
}
