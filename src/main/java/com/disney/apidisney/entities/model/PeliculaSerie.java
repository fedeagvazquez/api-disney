package com.disney.apidisney.entities.model;

import com.disney.apidisney.entities.dtos.requests.PeliculaSerieRequest;
import com.disney.apidisney.entities.dtos.requests.PersonajeRequest;
import com.disney.apidisney.entities.dtos.responses.PeliculaSerieResponse;
import com.disney.apidisney.entities.dtos.responses.PeliculasSeriesResponse;
import com.disney.apidisney.entities.dtos.responses.PersonajeResponse;
import com.disney.apidisney.entities.dtos.responses.PersonajesResponse;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PeliculaSerie {

  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY)
  private long id;
  private String imagen;
  private String titulo;
  private Date date;
  // private EnumClasificacion clasificacion;
  @OneToMany
  private List<PersonajeRequest> personajes;

  public PeliculaSerie(
      PeliculaSerieRequest peliculaSerieRequest) {
    this.imagen = peliculaSerieRequest.getImagen();
    this.titulo = peliculaSerieRequest.getTitulo();
    this.date = peliculaSerieRequest.getDate();
    this.personajes = peliculaSerieRequest.getPersonajesRequest();
  }

  public PeliculaSerieResponse completePeliculaSerieResponse() {
    return new PeliculaSerieResponse(this);
  }

  public PeliculasSeriesResponse shortedPeliculaSerieResponse() {
    return new PeliculasSeriesResponse(this);
  }


}
