package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioNacionalidad;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RequestMapping(value = "/nacionalidades")
@RestController
public class ControladorNacionalidad {

    private ServicioNacionalidad servicio;

    public ControladorNacionalidad(ServicioNacionalidad servicio) {
        this.servicio=servicio;
    }

    @RequestMapping
    public Iterable<Nacionalidad> getNacionalidades() {
        return this.servicio.getNacionalidades();
    }

    @RequestMapping(params = {"page"})
    public Page<Nacionalidad> getNacionalidades(Pageable pagina) { return this.servicio.getNacionalidades(pagina);}

    @RequestMapping(method = RequestMethod.POST)
    public Nacionalidad guardar(@RequestBody Nacionalidad n){
        return this.servicio.guardar(n);
    }

}
