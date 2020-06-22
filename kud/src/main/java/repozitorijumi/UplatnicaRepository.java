package repozitorijumi;

import modeli.Clan;
import modeli.Uplatnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UplatnicaRepository extends JpaRepository<Uplatnica, Long> {
    Optional<List<Uplatnica>> findByClan(Clan clan);
    Optional<List<Uplatnica>> findByPotvrdjenaFalse();
}
