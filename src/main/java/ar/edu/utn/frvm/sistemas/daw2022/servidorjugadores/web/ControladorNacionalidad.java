package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioNacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
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

    @RequestMapping(method = RequestMethod.GET, params = {"page"})
    public Iterable<Nacionalidad> getNacionalidadesQ(@RequestParam(name = "filtro", defaultValue = "") String filtro,
                                                    @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                    @RequestParam(name = "size", defaultValue = "4", required = false) int size){
        Pageable pagina = PageRequest.of(page,size);
        return this.servicio.getNacionalidadesQ(filtro, pagina);
    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Nacionalidad getNacionalidades(@PathVariable("id") Integer id){
        return this.servicio.getNacionalidades(id);
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
