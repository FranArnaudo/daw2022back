package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.Optional;

@Slf4j
@Repository
public class ServicioJugador {
    private RepositorioJugador repositorio;

    public ServicioJugador(RepositorioJugador repositorio){
        this.repositorio=repositorio;
    }

    public Jugador getJugadores(Integer id){
        Optional<Jugador> rta = this.repositorio.findById(id);
        if(rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Jugador> getJugadores(){
        return this.repositorio.findAll();
    }


    public Page<Jugador> getJugadoresQ(String filtro, Integer nacionalidadId, Integer facultadId, Pageable pagina){
        return this.repositorio.findByFilter(nacionalidadId, filtro, facultadId, pagina);
    }

    public Jugador guardar(Jugador j) {
        return this.repositorio.save(j);
    }

    public Jugador actualizar(Jugador j) {
        return this.repositorio.save(j);
    }

    public void eliminar(Integer id){
        this.repositorio.deleteById(id);
    }
}
