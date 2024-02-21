package upskill.pt.CarDealerShip.services.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import upskill.pt.CarDealerShip.enums.StatusEnum;
import upskill.pt.CarDealerShip.models.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    @Query("SELECT v FROM Vehicle v WHERE v.status = :status")
    Page<Vehicle> findByStatus(StatusEnum status, Pageable page);

    @Query("SELECT v FROM Vehicle v WHERE v.transaction = :transaction")
    Page<Vehicle> findByTransaction(int transaction, Pageable page);

    @Query("SELECT v FROM Vehicle v WHERE v.model.brand.id = :brandID")
    Page<Vehicle> findByBrandId(int brandID, Pageable page);


    }
