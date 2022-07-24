package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioJugador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

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

    public Iterable<Jugador> getJugadores(String filtro){
        return this.repositorio.findByDniContainingIgnoreCase(filtro);
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

    public Page<Jugador> getJugadores(Pageable pagina) {return this.repositorio.findAll(pagina);}
}
