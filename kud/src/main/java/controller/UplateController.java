package controller;

import lombok.AllArgsConstructor;
import modeli.Uplatnica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UplataService;

@RestController
@RequestMapping("/api/uplate")
@AllArgsConstructor
public class UplateController {

    private final UplataService uplataService;

    @PostMapping
    public ResponseEntity<Uplatnica> dodajUplatu(@RequestBody Uplatnica uplatnica) {
        return new ResponseEntity<>(uplataService.dodajUplatu(uplatnica), HttpStatus.OK);
    }

}
