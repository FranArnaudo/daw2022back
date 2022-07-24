package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositorioNacionalidad extends PagingAndSortingRepository<Nacionalidad, Integer> {
    Iterable<Nacionalidad> findByNombreContainingIgnoreCase(String nombre);
}
