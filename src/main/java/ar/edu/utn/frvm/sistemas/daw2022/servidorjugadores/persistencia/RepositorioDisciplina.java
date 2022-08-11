package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.persistencia;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface RepositorioDisciplina extends PagingAndSortingRepository<Disciplina, Integer>{
    Iterable<Disciplina> findByNombreContainingIgnoreCase(String nombre);
}
