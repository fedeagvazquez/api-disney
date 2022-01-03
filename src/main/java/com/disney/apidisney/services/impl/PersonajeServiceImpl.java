package com.disney.apidisney.services.impl;

import com.disney.apidisney.entities.dtos.requests.PersonajeRequest;
import com.disney.apidisney.entities.model.Personaje;
import com.disney.apidisney.repositories.PersonajeRepository;
import com.disney.apidisney.services.PersonajeService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements PersonajeService {

  private final PersonajeRepository personajeRepository;

  @Override
  public Personaje createPersonaje(
      Personaje personaje) {
    return personajeRepository.save(personaje);
  }

  @Override
  public void detelePersonaje(
      long personajeId) {

    personajeRepository.deleteById(personajeId);

  }

  @Override
  public Personaje getPersonajeById(
      long personajeId) throws Exception {

    return personajeRepository
        .findById(personajeId)
        .orElseThrow(Exception::new);

  }


  @Override
  public void actualizarPersonaje(
      PersonajeRequest personajeRequest, long personajeId) throws Exception {

    Personaje personaje = this.getPersonajeById(personajeId);

    String newImagen = personajeRequest.getImagen();
    if (Objects.nonNull(newImagen)) {
      personaje.setImagen(newImagen);
    }

    String newNombre = personajeRequest.getNombre();
    if (Objects.nonNull(newNombre)) {
      personaje.setNombre(newNombre);
    }

    int newEdad = personajeRequest.getEdad();
    personaje.setEdad(newEdad);

    double newPeso = personajeRequest.getPeso();
    personaje.setPeso(newPeso);

    String newHistoria = personajeRequest.getHistoria();
    if (Objects.nonNull(newHistoria)) {
      personaje.setHistoria(newHistoria);
    }

    personajeRepository.save(personaje);

  }

  @Override
  public List<Personaje> getAllPersonajes() {
    return personajeRepository.findAll();
  }

}
