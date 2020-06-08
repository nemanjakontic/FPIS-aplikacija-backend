package service;

import lombok.AllArgsConstructor;
import modeli.Clan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repozitorijumi.ClanRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClanService {

    private final ClanRepository clanRepository;

    @Transactional(readOnly = true)
    public List<Clan> vratiSveClanove() {
        return clanRepository.findAll();
    }

}
