package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import modeli.Uplatnica;
import org.springframework.stereotype.Service;
import repozitorijumi.ClanRepository;
import repozitorijumi.UplatnicaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UplataService {
    private final UplatnicaRepository uplatnicaRepository;
    private final ClanRepository clanRepository;
    private final AuthService authService;

    public Uplatnica dodajUplatu(Uplatnica uplatnica) {
//        uplatnica.setUser(authService.getCurrentUser());
        return uplatnicaRepository.save(uplatnica);
    }

    public List<Uplatnica> vratiSve() {
        return uplatnicaRepository.findAll();
    }

    public Uplatnica vratiJednuUplatu(Long uplatnicaId) {
        Optional<Uplatnica> uplatnica = uplatnicaRepository.findById(uplatnicaId);
        if(uplatnica.isPresent()) {
            return uplatnica.get();
        } else {
            throw new RuntimeException("nema uplatnice sa tim id-em");
        }
    }

    public String izbrisiUplatu(Long id) {
        uplatnicaRepository.deleteById(id);
        return "Uspesno obrisana uplata";
        // uraditi refaktor
    }

    public List<Uplatnica> vratiUplateZaClana(Long clanId) {
        Optional<Clan> clan = clanRepository.findById(clanId);
        System.out.println(clan.get());
        if(clan.isPresent()){
            Optional<List<Uplatnica>> lista = uplatnicaRepository.findByClan(clan.get());
//            System.out.println(lista.get());
            if(lista.isPresent()) {
                return lista.get();
            } else {
//                throw new RuntimeException("Neka greska");
                return new ArrayList<Uplatnica>();
            }
        } else {
            throw new RuntimeException("Ne postoji clan sa tim id-em");
        }

    }

    public Uplatnica izmeniUplatu(Uplatnica uplatnica) {
//        Optional<Uplatnica> uplatnica = uplatnicaRepository.findById(uplatnica.get().getUplatnicaId());
        return uplatnicaRepository.save(uplatnica);
    }
}
