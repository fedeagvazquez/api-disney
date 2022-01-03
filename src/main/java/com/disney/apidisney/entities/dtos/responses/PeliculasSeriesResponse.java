package com.disney.apidisney.entities.dtos.responses;

import com.disney.apidisney.entities.model.PeliculaSerie;
import java.util.Date;
import lombok.Data;

@Data
public class PeliculasSeriesResponse {

  private String imagen;
  private String titulo;
  private Date date;

  public PeliculasSeriesResponse(
      PeliculaSerie peliculaSerie) {
    this.imagen = peliculaSerie.getImagen();
    this.titulo = peliculaSerie.getTitulo();
    this.date = peliculaSerie.getDate();
  }

}
