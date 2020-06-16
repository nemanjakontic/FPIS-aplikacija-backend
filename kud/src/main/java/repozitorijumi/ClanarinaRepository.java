package repozitorijumi;

import modeli.Clan;
import modeli.Clanarina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClanarinaRepository extends JpaRepository<Clanarina, Long> {
//    List<Clanarina> findClanarinaByClanAndPlacenaFalse(Clan clan);
}
