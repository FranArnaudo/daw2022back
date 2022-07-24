package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia.RepositorioDisciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ServicioDisciplina {
    private RepositorioDisciplina repositorio;

    public ServicioDisciplina(RepositorioDisciplina repositorio) {this.repositorio=repositorio;}

    public Disciplina getDisciplina(Integer id){
        Optional<Disciplina> rta = this.repositorio.findById(id);
        if(rta.isPresent()) {
            return rta.get();
        }
        return null;
    }

    public Iterable<Disciplina> getDisciplinas(){
        return this.repositorio.findAll();
    }

    public Iterable<Disciplina> getDisciplinas(String filtro){
        return this.repositorio.findByNombreContainingIgnoreCase(filtro);
    }

    public Disciplina guadar(Disciplina d){
        return this.repositorio.save(d);
    }

    public Disciplina actualizar(Disciplina d){
        return this.repositorio.save(d);
    }

    public void eliminar(Integer id){
        this.repositorio.deleteById(id);
    }

    public Page<Disciplina> getDisciplinas(Pageable pagina) { return this.repositorio.findAll(pagina);}
}
