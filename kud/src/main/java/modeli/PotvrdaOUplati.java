package modeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PotvrdaOUplati {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datumIzdavanja;
    @OneToOne
    private Uplatnica uplatnica;
    @ManyToOne
    private Clan clan;
    @OneToMany
    private List<StavkaPotvrdeOUplati> stavke;
}
