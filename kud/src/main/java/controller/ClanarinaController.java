package controller;

import dto.ResponseDto;
import lombok.AllArgsConstructor;
import modeli.Clan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClanarinaService;

@RestController
@RequestMapping("/api/clanarine")
@AllArgsConstructor
public class ClanarinaController {

    private final ClanarinaService clanarinaService;

//    @PostMapping
//    public ResponseEntity<ResponseDto> vratiClanarineZaClana(@RequestBody Clan clan) {
//        ResponseDto responseDto = ResponseDto.builder()
//                .clanarine(clanarinaService.vratiClanarineZaClana(clan))
//                .poruka("Vracene clanarine za clana").build();
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }

}
