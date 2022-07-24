package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

public class Facultad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String nombre;
    @NonNull
    private String codigo;
    private String descripcion;
    private int codigoNumerico;

    //@OneToMany(mappedBy = "facultad")
    //private List<Jugador> jugador= new ArrayList<Jugador>();
}
