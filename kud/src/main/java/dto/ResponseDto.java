package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import modeli.Clan;
import modeli.PotvrdaOUplati;
import modeli.Uplatnica;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private List<Clan> clanovi;
    private List<Uplatnica> uplatnice;
    private String poruka;
    private Uplatnica uplatnica;
    private List<PotvrdaOUplati> potvrde;
    private PotvrdaOUplati potvrda;
}
