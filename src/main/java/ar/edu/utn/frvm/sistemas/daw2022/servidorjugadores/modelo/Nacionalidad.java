package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Nacionalidad {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    @NonNull
    private String nombre;
    @NonNull
    private String codigo;
    private String descripcion;
}
