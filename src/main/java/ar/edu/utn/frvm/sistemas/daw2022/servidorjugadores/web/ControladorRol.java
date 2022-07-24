package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioRol;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RequestMapping(value = "/roles")
@RestController
public class ControladorRol {
    private ServicioRol servicio;

    public ControladorRol(ServicioRol servicio) {
        this.servicio=servicio;
    }

    //GET todos
    @RequestMapping
    public Iterable<Rol> getRoles() {
        return this.servicio.getRoles();
    }

    @RequestMapping(params = {"page"})
    public Page<Rol> getRoles(Pageable pagina) {return this.servicio.getRoles(pagina);}

    @RequestMapping(params = {"filtro"})
    public Iterable<Rol> getRoles(@RequestParam(name = "filtro") String filtro){
        log.info(filtro);
        return this.servicio.getRoles(filtro);
    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Rol getRoles(@PathVariable("id") Integer id){
        return this.servicio.getRoles(id);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Rol guardar(@RequestBody Rol r){
        return this.servicio.guardar(r);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Rol actualizar(@RequestBody Rol r){
        return this.servicio.actualizar(r);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void eliminar(@RequestBody Integer id){
        this.servicio.eliminar(id);
    }
}
