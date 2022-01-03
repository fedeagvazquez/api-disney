package com.disney.apidisney.entities.model;

import com.disney.apidisney.entities.dtos.requests.PersonajeRequest;
import com.disney.apidisney.entities.dtos.responses.PersonajeResponse;
import com.disney.apidisney.entities.dtos.responses.PersonajesResponse;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Personaje {

  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY)
  private long id;

  private String imagen;
  private String nombre;
  private int edad;
  private double peso;
  private String historia;
  @ManyToOne
  private PeliculaSerie peliculaSerie;


  public Personaje(
      PersonajeRequest personajeRequest) {

    this.imagen = personajeRequest.getImagen();
    this.nombre = personajeRequest.getNombre();
    this.edad = personajeRequest.getEdad();
    this.peso = personajeRequest.getPeso();
    this.historia = personajeRequest.getHistoria();
//    this.peliculaSerie = personajeRequest.getPeliculaSerieRequest();
  }

  public PersonajeResponse completePersonajeResponse() {
    return new PersonajeResponse(this);
  }

  public PersonajesResponse shortedPersonajeResponse() {
    return new PersonajesResponse(this);
  }


}
