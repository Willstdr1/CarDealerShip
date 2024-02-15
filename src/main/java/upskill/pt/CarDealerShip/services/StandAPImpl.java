package upskill.pt.CarDealerShip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandAPImpl implements StandAPI{

    @Autowired
    StandAPI stand;
}
