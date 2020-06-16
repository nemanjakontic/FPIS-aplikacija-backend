package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import modeli.Clanarina;
import org.springframework.stereotype.Service;
import repozitorijumi.ClanarinaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClanarinaService {

    private final ClanarinaRepository clanarinaRepository;


//    public List<Clanarina> vratiClanarineZaClana(Clan clan) {
//        List<Clanarina> clanarine = clanarinaRepository.findClanarinaByClanAndPlacenaFalse(clan);
//        return clanarine;
//    }
}
