package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioRol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioRol {
    private RepositorioRol repositorio;

    public ServicioRol(RepositorioRol repositorio) { this.repositorio = repositorio;}

    public Rol getRoles(Integer id){
        Optional<Rol> rta = this.repositorio.findById(id);
        if(rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Rol> getRoles() {
        return this.repositorio.findAll();
    }

    public Iterable<Rol> getRoles(String filtro){
        return this.repositorio.findByNombreContainingIgnoreCase(filtro);
    }

    public Rol guardar(Rol r) {
        return this.repositorio.save(r);
    }

    public Rol actualizar(Rol r) {
        return this.repositorio.save(r);
    }

    public void eliminar(Integer id){
        this.repositorio.deleteById(id);
    }

    public Page<Rol> getRoles(Pageable pagina) {return this.repositorio.findAll(pagina);}
}

