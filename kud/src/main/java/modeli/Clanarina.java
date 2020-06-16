package modeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clanarina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clanarinaId;
    private int mesec;
    private int godina;
    private int iznos;
    private boolean placena;
}
