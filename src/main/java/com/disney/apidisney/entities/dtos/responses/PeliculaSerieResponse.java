package com.disney.apidisney.entities.dtos.responses;

import com.disney.apidisney.entities.dtos.requests.PersonajeRequest;
import com.disney.apidisney.entities.model.PeliculaSerie;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
public class PeliculaSerieResponse {

    private String imagen;
    private String titulo;
    private Date date;
    // private EnumClasificacion clasificacion;
    @OneToMany
    private List<PersonajeRequest> personajes;

    public PeliculaSerieResponse(
            PeliculaSerie peliculaSerie) {
        this.imagen = peliculaSerie.getImagen();
        this.titulo = peliculaSerie.getTitulo();
        this.date = peliculaSerie.getDate();
        this.personajes = peliculaSerie.getPersonajes();
    }

}
