package upskill.pt.CarDealerShip.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.pt.CarDealerShip.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
