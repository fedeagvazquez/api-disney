package com.disney.apidisney.services;

import com.disney.apidisney.entities.dtos.requests.PersonajeRequest;
import com.disney.apidisney.entities.model.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajeService {

  Personaje createPersonaje(
      Personaje personaje);

  void detelePersonaje(
      long personajeId);

  Personaje getPersonajeById(
      long personajeId) throws Exception;

  void actualizarPersonaje(
      PersonajeRequest personajeRequest,
      long personajeId) throws Exception;

  List<Personaje> getAllPersonajes();



}
