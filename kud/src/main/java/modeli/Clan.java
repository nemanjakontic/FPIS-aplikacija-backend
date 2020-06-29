package modeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
//    private String datumRodjenja;
    private Date datumRodjenja;
    private String slika;
    // vrv ce ovde trebati cascade all
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Clanarina> clanarine;
}
