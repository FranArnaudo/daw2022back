package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioNacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/nacionalidades")
@RestController
public class ControladorNacionalidad {
    private ServicioNacionalidad servicio;

    public ControladorNacionalidad(ServicioNacionalidad servicio) {
        this.servicio=servicio;
    }

    //GET todos
    @RequestMapping
    public Iterable<Nacionalidad> getNacionalidades() {
        return this.servicio.getNacionalidades();
    }

    @RequestMapping(params = {"filtro"})
    public Iterable<Nacionalidad> getNacionalidades(@RequestParam(name = "filtro") String filtro){
        log.info(filtro);
        return this.servicio.getNacionalidades(filtro);
    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Nacionalidad getNacionalidades(@PathVariable("id") Integer id){
        return this.servicio.getNacionalidades(id);
    }

    @RequestMapping(params = {"page"})
    public Iterable<Nacionalidad> getNacionalidades(Pageable pagina) {
        return this.servicio.getNacionalidades(pagina);
    }

    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Nacionalidad guardar(@RequestBody Nacionalidad n){
        return this.servicio.guardar(n);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Nacionalidad actualizar(@RequestBody Nacionalidad n){
        return this.servicio.actualizar(n);
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("id") Integer id){
        this.servicio.eliminar(id);
    }
}
