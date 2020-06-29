package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import modeli.Clanarina;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import repozitorijumi.ClanRepository;
import repozitorijumi.ClanarinaRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Configuration
@EnableScheduling
public class ClanarinaService {

    private final ClanarinaRepository clanarinaRepository;
    private final ClanRepository clanRepository;

//    @Scheduled(cron = "0 15 10 1 * ?")
//    public void dodajClanarinu() {
//        Date danasnjiDatum = new Date();
//    }

    @Scheduled(cron = "0 15 10 1 * ?")
//    @Scheduled(fixedDelay = 60000)
    public void scheduleFixedDelayTask() {
        Calendar c = Calendar.getInstance();
        int mesec = c.get(Calendar.MONTH) + 1;
        int godina = c.get(Calendar.YEAR);
        System.out.println(mesec);
        System.out.println(godina);
        Clanarina clanarina = new Clanarina();
        clanarina.setGodina(godina);
        clanarina.setIznos(300);
        clanarina.setMesec(mesec);
        clanarina.setPlacena(false);

        List<Clan> clanovi = clanRepository.findAll();
        clanovi.forEach(clan -> {
            System.out.println("usao u clana");
            List<Clanarina> clanarine = clan.getClanarine();
            clanarine.add(clanarina);
            clan.setClanarine(clanarine);
            clanRepository.save(clan);
            System.out.println("sacuvao clanarine");
        });


    }

//    public List<Clanarina> vratiClanarineZaClana(Clan clan) {
//        List<Clanarina> clanarine = clanarinaRepository.findClanarinaByClanAndPlacenaFalse(clan);
//        return clanarine;
//    }
}
