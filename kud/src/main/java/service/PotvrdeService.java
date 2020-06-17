package service;

import lombok.AllArgsConstructor;
import modeli.*;
import org.springframework.stereotype.Service;
import repozitorijumi.ClanRepository;
import repozitorijumi.ClanarinaRepository;
import repozitorijumi.PotvrdeRepository;
import repozitorijumi.UplatnicaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PotvrdeService {

    private final PotvrdeRepository potvrdeRepository;
    private final ClanRepository clanRepository;
    private final UplatnicaRepository uplatnicaRepository;
    private final ClanarinaRepository clanarinaRepository;

    public List<PotvrdaOUplati> vratiPotvrdeZaClana(Long clanId) {
        Optional<Clan> clan = clanRepository.findById(clanId);
//        Optional<List<Uplatnica>> uplatnica = uplatnicaRepository.findByClan(clan.get());
        System.out.println(clan.get());
        if(clan.isPresent()){
            Optional<List<PotvrdaOUplati>> lista = potvrdeRepository.findByClan(clan.get());
            System.out.println(lista.get());
            if(lista.isPresent()) {
                return lista.get();
            } else {
                throw new RuntimeException("Neka greska");
            }
        } else {
            throw new RuntimeException("Ne postoji clan sa tim id-em");
        }
    }

    public PotvrdaOUplati dodajPotvrdu(PotvrdaOUplati potvrda) {
        // uraditi refactor cele, nisu obradjene greske
        List<Clanarina> clanarine = new ArrayList<>();
//        Clan clanZaIzmenu = potvrda.getClan();
        for (StavkaPotvrdeOUplati stavka : potvrda.getStavke()) {
            stavka.getClanarina().setPlacena(true);
            clanarine.add(stavka.getClanarina());
        }
//        clanZaIzmenu.setClanarine(clanarine);
        PotvrdaOUplati potvrdaOUplati = potvrdeRepository.save(potvrda);
        if(potvrdaOUplati != null) {
            for (Clanarina c : clanarine) {
                clanarinaRepository.save(c);
            }
        }
        return potvrdaOUplati;
    }
}
