package com.disney.apidisney.entities.dtos.requests;

import com.disney.apidisney.entities.model.PeliculaSerie;
import com.disney.apidisney.entities.model.Personaje;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class PeliculaSerieRequest {

  private String imagen;
  private String titulo;
  private Date date;
  // private EnumClasificacion clasificacion;
  private List<PersonajeRequest> personajesRequest;

  public PeliculaSerie construct () {
    return new PeliculaSerie(this);
  }
}

