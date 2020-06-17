package controller;

import dto.ResponseDto;
import lombok.AllArgsConstructor;
import modeli.PotvrdaOUplati;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import service.PotvrdeService;

@RestController
@RequestMapping("/api/potvrde")
@AllArgsConstructor
public class PotvrdeController {

    private final PotvrdeService potvrdeService;

    @GetMapping("/{clanId}")
    public ResponseEntity<ResponseDto> vratiPotvrdeZaClana(@PathVariable Long clanId) {
        ResponseDto response = ResponseDto.builder()
                .potvrde(potvrdeService.vratiPotvrdeZaClana(clanId)).poruka("Vracene potvrde za clana").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ResponseDto> dodajPotvrdu(@RequestBody PotvrdaOUplati potvrda) {
        ResponseDto response = ResponseDto.builder()
                .potvrda(potvrdeService.dodajPotvrdu(potvrda))
                .poruka("Potvrda dodata").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
