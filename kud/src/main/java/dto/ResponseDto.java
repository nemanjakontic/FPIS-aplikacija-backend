package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import modeli.Clan;
import modeli.Clanarina;
import modeli.PotvrdaOUplati;
import modeli.Uplatnica;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private List<Clan> clanovi;
    private Clan clan;
    private List<Uplatnica> uplatnice;
    private String poruka;
    private Uplatnica uplatnica;
    private List<PotvrdaOUplati> potvrde;
    private PotvrdaOUplati potvrda;
    private List<Clanarina> clanarine;
    private Clanarina clanarina;
}
