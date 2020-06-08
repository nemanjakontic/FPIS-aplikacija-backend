package controller;

import dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}