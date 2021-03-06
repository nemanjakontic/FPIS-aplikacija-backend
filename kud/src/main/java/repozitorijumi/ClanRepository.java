package repozitorijumi;

import modeli.Clan;
import modeli.Clanarina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {

}
