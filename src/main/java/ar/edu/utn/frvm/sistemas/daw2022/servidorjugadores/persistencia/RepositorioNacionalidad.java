package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNacionalidad extends PagingAndSortingRepository<Nacionalidad, Integer> {
    Iterable<Nacionalidad> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT DISTINCT n FROM Nacionalidad n WHERE (n.nombre LIKE %:filtro% OR n.codigo LIKE %:filtro%)")
    Page<Nacionalidad> findByFilter(String filtro, Pageable pagina);

}