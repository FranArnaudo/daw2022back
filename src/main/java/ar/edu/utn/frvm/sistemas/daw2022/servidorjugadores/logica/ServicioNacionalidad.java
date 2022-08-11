package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioNacionalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioNacionalidad {
    private RepositorioNacionalidad repositorio;

    public ServicioNacionalidad(RepositorioNacionalidad repositorio) { this.repositorio = repositorio;}

    public Nacionalidad getNacionalidades(Integer id){
        Optional<Nacionalidad> rta = this.repositorio.findById(id);
        if(rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Nacionalidad> getNacionalidades() {
        return this.repositorio.findAll();
    }

    public Iterable<Nacionalidad> getNacionalidades(String filtro){
        return this.repositorio.findByNombreContainingIgnoreCase(filtro);
    }
    public Page<Nacionalidad> getNacionalidades(Pageable pagina){
        return this.repositorio.findAll(pagina);
    }
    public Nacionalidad guardar(Nacionalidad n) {
        return this.repositorio.save(n);
    }

    public Nacionalidad actualizar(Nacionalidad n) {
        return this.repositorio.save(n);
    }

    public void eliminar(Integer id){
        this.repositorio.deleteById(id);
    }
}

