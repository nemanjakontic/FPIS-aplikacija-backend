package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import modeli.Clanarina;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repozitorijumi.ClanRepository;

import java.util.ArrayList;
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

    public Clan dodajClana(Clan clan) {
        List<Clanarina> clanarine = new ArrayList<>();
        clan.setClanarine(clanarine);
        return clanRepository.save(clan);
    }

    public Clan izmeniClana(Clan clan1) {
        Optional<Clan> clan = clanRepository.findById(clan1.getClanId());
        if(clan.isPresent()){
            Clan clanic = clan.get();
            List<Clanarina> clanarine = clanic.getClanarine();
            clan1.setClanarine(clanarine);
            return clanRepository.save(clan1);
        }
        return null;
    }
}
