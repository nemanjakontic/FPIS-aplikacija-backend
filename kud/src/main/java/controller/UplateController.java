package controller;

import dto.ResponseDto;
import lombok.AllArgsConstructor;
import modeli.Uplatnica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UplataService;

import java.util.List;

@RestController
@RequestMapping("/api/uplate")
@AllArgsConstructor
public class UplateController {

    private final UplataService uplataService;

    @PostMapping
    public ResponseEntity<ResponseDto> dodajUplatu(@RequestBody Uplatnica uplatnica) {
        ResponseDto response = ResponseDto.builder()
                .uplatnica(uplataService.dodajUplatu(uplatnica)).poruka("Dodata uplata").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return new ResponseEntity<>(uplataService.dodajUplatu(uplatnica), HttpStatus.OK);
    }

    // ovo nam u sustini ne treba jer uvek vracamo samo uplate za odredjenog clana
    @GetMapping
    public ResponseEntity<ResponseDto> vratiSveUplate() {
        ResponseDto response = ResponseDto.builder()
                .uplatnice(uplataService.vratiSve()).poruka("Uspesno vracene sve uplatnice").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/jedna/{uplatnicaId}")
    public ResponseEntity<ResponseDto> vratiJednuUplatu(@PathVariable Long uplatnicaId) {
        ResponseDto response = ResponseDto.builder()
                .uplatnica(uplataService.vratiJednuUplatu(uplatnicaId)).poruka("Uspesno vracena jedna uplatnica").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{clanId}")
    public ResponseEntity<ResponseDto> vratiUplateZaClana(@PathVariable Long clanId) {
        ResponseDto response = ResponseDto.builder()
                .uplatnice(uplataService.vratiUplateZaClana(clanId)).poruka("Vracene uplate za clana").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> obrisiUplatu(@PathVariable Long id) {
        ResponseDto response = ResponseDto.builder().poruka(uplataService.izbrisiUplatu(id)).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDto> izmeniUplatu(@RequestBody Uplatnica uplatnica) {
        ResponseDto response = ResponseDto.builder()
                .uplatnica(uplataService.izmeniUplatu(uplatnica)).poruka("Izmenjena uplata").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
