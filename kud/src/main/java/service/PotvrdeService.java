package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import modeli.PotvrdaOUplati;
import modeli.Uplatnica;
import org.springframework.stereotype.Service;
import repozitorijumi.ClanRepository;
import repozitorijumi.PotvrdeRepository;
import repozitorijumi.UplatnicaRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PotvrdeService {

    private final PotvrdeRepository potvrdeRepository;
    private final ClanRepository clanRepository;
    private final UplatnicaRepository uplatnicaRepository;

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
}
