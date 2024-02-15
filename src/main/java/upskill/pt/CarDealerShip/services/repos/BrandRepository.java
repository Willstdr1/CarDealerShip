package upskill.pt.CarDealerShip.services.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import upskill.pt.CarDealerShip.models.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
