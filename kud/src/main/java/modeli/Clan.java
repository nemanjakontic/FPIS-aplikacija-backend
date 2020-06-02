package modeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clanId;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String slika;
}
