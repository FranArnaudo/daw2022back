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
    @OrderColumn(name = "nombre")
    private Facultad facultad;
    @ManyToOne()
    @OrderColumn(name = "nombre")
    private Rol rol;
    @ManyToOne()
    @OrderColumn(name = "nombre")
    private Disciplina disciplina;
    @ManyToOne()
    @OrderColumn(name = "nombre")
    private Nacionalidad nacionalidad;
}
