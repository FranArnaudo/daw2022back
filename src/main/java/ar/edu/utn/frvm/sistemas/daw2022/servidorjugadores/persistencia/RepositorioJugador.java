package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioJugador extends PagingAndSortingRepository<Jugador, Integer> {
    Iterable<Jugador> findByDniContainingIgnoreCase(String dni);
}
