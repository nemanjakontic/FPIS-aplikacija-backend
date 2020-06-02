package repozitorijumi;

import modeli.Uplatnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UplatnicaRepository extends JpaRepository<Uplatnica, Long> {
}
