package controller;

import dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
