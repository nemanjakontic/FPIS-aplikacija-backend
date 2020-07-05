package controller;

import dto.ResponseDto;
import lombok.AllArgsConstructor;
import modeli.Clan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClanService;

@RestController
@RequestMapping("/api/clanovi")
@AllArgsConstructor
public class ClanController {

    private final ClanService clanService;

    @GetMapping
    public ResponseEntity<ResponseDto> vratiSveClanove() {
        ResponseDto response = ResponseDto.builder()
                .clanovi(clanService.vratiSveClanove()).poruka("Uspesno vraceni clanovi").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{clanId}")
    public ResponseEntity<ResponseDto> vratiClana(@PathVariable Long clanId) {
        ResponseDto response = ResponseDto.builder()
                .clan(clanService.vratiClana(clanId)).poruka("Uspesno vracen clan").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> dodajClana(@RequestBody Clan clan) {
        ResponseDto response = ResponseDto.builder()
                .clan(clanService.dodajClana(clan)).poruka("Uspesno dodat clan").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<ResponseDto> izmeniClana(@RequestBody Clan clan) {
        System.out.println(clan);
        ResponseDto response = ResponseDto.builder()
                .clan(clanService.izmeniClana(clan)).poruka("Uspesno izmenjen clan").build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
