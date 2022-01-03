package com.disney.apidisney.entities.dtos.requests;

import com.disney.apidisney.entities.model.Personaje;
import lombok.Data;

@Data
public class PersonajeRequest {

  private String imagen;
  private String nombre;
  private int edad;
  private double peso;
  private String historia;
  private PeliculaSerieRequest peliculaSerieRequest;

  public Personaje construct () {
    return new Personaje(this);
  }
}
