package com.disney.apidisney.entities.dtos.responses;

import com.disney.apidisney.entities.model.Personaje;
import lombok.Data;

@Data
public class PersonajesResponse {

  private String imagen;
  private String nombre;


  public PersonajesResponse(
      Personaje personaje) {
    this.imagen = personaje.getImagen();
    this.nombre = personaje.getNombre();
  }

}
