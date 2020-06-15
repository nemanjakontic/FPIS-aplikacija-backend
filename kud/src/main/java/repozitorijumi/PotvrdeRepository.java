package repozitorijumi;

import modeli.Clan;
import modeli.PotvrdaOUplati;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PotvrdeRepository extends JpaRepository<PotvrdaOUplati, Long> {
    Optional<List<PotvrdaOUplati>> findByClan(Clan clan);
}
