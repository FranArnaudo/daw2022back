package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.logica.ServicioJugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Jugador;
import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Nacionalidad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/jugadores")
@RestController
public class ControladorJugador {
    private ServicioJugador servicio;

    public ControladorJugador(ServicioJugador servicio) {
        this.servicio=servicio;
    }


//    @RequestMapping(params = {"filtro"})
//    public Iterable<Jugador> getJugadores(@RequestParam(name = "filtro") String filtro){
//        log.info(filtro);
//        return this.servicio.getJugadores(filtro);
//    }

    //GET 1
    @RequestMapping(value = "/{id}")
    public Jugador getJugadores(@PathVariable("id") Integer id){
        return this.servicio.getJugadores(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Jugador> getJugadoresQ(@RequestParam(name = "filtro", defaultValue = "") String filtro,
                                           @RequestParam(name = "nacionalidad", required = false) Integer nacionalidadId,
                                           @RequestParam(name = "facultad", required = false) Integer facultadId,
                                           @RequestParam(name = "page",defaultValue = "0", required = false) int page,
                                           @RequestParam(name = "size",defaultValue = "4", required = false) int size,
                                           @RequestParam(name = "sort", defaultValue = "id", required = false) String sort,
                                           @RequestParam(name = "order", defaultValue = "DESC", required = false) String order){

        Pageable pagina = PageRequest.of(page,size, Sort.by(sort));
        if (order.equals("ASC")){
            pagina = PageRequest.of(page,size, Sort.by(Sort.Direction.ASC, sort));
        } else if (order.equals("DESC")) {
            pagina = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sort));
        }
        return this.servicio.getJugadoresQ(filtro,nacionalidadId,facultadId,pagina);
    }



    //POST
    @RequestMapping(method = RequestMethod.POST)
    public Jugador guardar(@RequestBody Jugador j){
        return this.servicio.guardar(j);
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Jugador actualizar(@RequestBody Jugador j){
        return this.servicio.actualizar(j);
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable("id") Integer id){
        log.info("Eliminar");
        this.servicio.eliminar(id);
    }
}
