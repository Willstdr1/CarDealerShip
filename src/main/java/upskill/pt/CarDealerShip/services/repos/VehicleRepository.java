package upskill.pt.CarDealerShip.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.pt.CarDealerShip.models.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

/*    @Query("SELECT v FROM Vehicle v WHERE v.BusinessStatus = :businessStatus")
    List<Vehicle> findByStatus(BusinessStatus businessStatus);

    @Query("SELECT v FROM Vehicle v WHERE v.buyerID = :buyerId")
    List<Vehicle> findByBuyerId(int buyerId);*/

}
