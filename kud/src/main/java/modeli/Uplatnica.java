package modeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Uplatnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uplatnicaId;
    private Date datumUplate;
    private double iznos;
    @ManyToOne
    @JoinColumn(name = "clanId", referencedColumnName = "clanId")
    private Clan clan;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
