package service;

import lombok.AllArgsConstructor;
import modeli.Uplatnica;
import org.springframework.stereotype.Service;
import repozitorijumi.UplatnicaRepository;

@Service
@AllArgsConstructor
public class UplataService {
    private final UplatnicaRepository uplatnicaRepository;
    private final AuthService authService;

    public Uplatnica dodajUplatu(Uplatnica uplatnica) {
        uplatnica.setUser(authService.getCurrentUser());
        return uplatnicaRepository.save(uplatnica);
    }
}
