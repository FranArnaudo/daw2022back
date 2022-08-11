package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioDisciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Disciplina;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/disciplinas")
@RestController
public class ControladorDisciplina {
    private ServicioDisciplina servicio;

    public ControladorDisciplina(ServicioDisciplina servicio){
        this.servicio=servicio;
    }

    //GET todos
    @RequestMapping
    public Iterable<Disciplina> getDisciplinas() {
        return this.servicio.getDisciplinas();
    }

    @RequestMapping(params = {"filtro"})
    public Iterable<Disciplina> getDisciplinas(@RequestParam(name = "filtro") String filtro){
        log.info(filtro);
        return this.servicio.getDisciplinas(filtro);
    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Disciplina getDisciplina(@PathVariable("id") Integer id){
        return this.servicio.getDisciplina(id);
    }

    @RequestMapping(params = {"page"})
    public Iterable<Disciplina> getDisciplina(Pageable pagina) {
        return this.servicio.getDisciplinas(pagina);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Disciplina guardar(@RequestBody Disciplina d){
        return this.servicio.guadar(d);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Disciplina actualizar(@RequestBody Disciplina d){
        return this.servicio.actualizar(d);
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }
}
