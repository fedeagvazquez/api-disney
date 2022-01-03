package com.disney.apidisney.entities.model;

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
public class Genero {

  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY)
  private long id;
  private String nombre;
  private String imagen;
  @ManyToOne
  private PeliculaSerie peliculaSerie;

}
