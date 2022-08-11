package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    private String dni;

    private Integer legajo;
    private String email;
    private String telefono;
    private Date fechaNacimiento;

    @ManyToOne()
    private Facultad facultad;
    @ManyToOne()
    private Rol rol;
    @ManyToOne()
    private Disciplina disciplina;
    @ManyToOne()
    private Nacionalidad nacionalidad;
}
