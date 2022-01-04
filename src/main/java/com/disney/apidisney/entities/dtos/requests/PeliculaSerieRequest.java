package com.disney.apidisney.entities.dtos.requests;

import com.disney.apidisney.entities.model.PeliculaSerie;
import java.util.Date;
import java.util.List;
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

