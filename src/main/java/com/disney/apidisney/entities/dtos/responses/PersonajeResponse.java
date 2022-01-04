package com.disney.apidisney.entities.dtos.responses;

import com.disney.apidisney.entities.model.PeliculaSerie;
import com.disney.apidisney.entities.model.Personaje;
import lombok.Data;

@Data
public class PersonajeResponse {

  private String imagen;
  private String nombre;
  private int edad;
  private double peso;
  private String historia;
  private PeliculaSerie peliculaSerie;

  public PersonajeResponse (
      Personaje personaje){
    this.imagen = personaje.getImagen();
    this.nombre = personaje.getNombre();
    this.edad = personaje.getEdad();
    this.peso = personaje.getPeso();
    this.historia = personaje.getHistoria();
    this.peliculaSerie = personaje.getPeliculaSerie();
  }

}
