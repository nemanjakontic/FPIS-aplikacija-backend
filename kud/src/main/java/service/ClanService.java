package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repozitorijumi.ClanRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClanService {

    private final ClanRepository clanRepository;

    @Transactional(readOnly = true)
    public List<Clan> vratiSveClanove() {
        return clanRepository.findAll();
    }

    public Clan vratiClana(Long clanId) {
        Optional<Clan> clan = clanRepository.findById(clanId);
        Clan cl = null;
        if(clan.isPresent()) {
            cl = clan.get();
        }
        return cl;
    }
}
