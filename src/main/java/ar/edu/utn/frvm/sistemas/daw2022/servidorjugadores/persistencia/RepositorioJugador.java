package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface RepositorioJugador extends PagingAndSortingRepository<Jugador, Integer> {

    @Query("SELECT j FROM Jugador j LEFT OUTER JOIN Nacionalidad n ON j.nacionalidad = n LEFT OUTER JOIN Facultad f ON j.facultad = f WHERE (:nacionalidadId is null OR n.id = :nacionalidadId) AND (:facultadId is null OR f.id = :facultadId) AND (j.nombre LIKE %:filtro% OR j.apellido LIKE %:filtro% OR j.dni LIKE %:filtro% )")
    Page<Jugador> findByFilter(Integer nacionalidadId, String filtro, Integer facultadId, Pageable pagina);

}
