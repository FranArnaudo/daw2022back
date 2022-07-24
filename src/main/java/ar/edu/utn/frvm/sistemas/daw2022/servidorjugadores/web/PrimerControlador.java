package ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.web;

import ar.edu.utn.frvm.sistemas.daw2022.servidorjugadores.modelo.Facultad;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/jugadores-anterior")
@RestController
public class PrimerControlador {

    @RequestMapping
    public String getJugadores(){
        return "TODOS";
    }

    @RequestMapping(value = "/jugador")
    public String getJugador(){
        return "Uno solo";
    }

    @RequestMapping(value = "/facultad")
    public Facultad getFacutlad(){
        //Facultad f = new Facultad();
        return new Facultad ( "Villa María", "UTN");
    }

}
