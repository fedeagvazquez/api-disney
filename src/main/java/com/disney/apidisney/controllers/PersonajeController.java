package com.disney.apidisney.controllers;


import com.disney.apidisney.entities.dtos.requests.PersonajeRequest;
import com.disney.apidisney.entities.dtos.responses.PersonajeResponse;
import com.disney.apidisney.entities.dtos.responses.PersonajesResponse;
import com.disney.apidisney.entities.model.Personaje;
import com.disney.apidisney.services.PersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/characters")
public class PersonajeController {

  private final PersonajeService personajeService;

  @PostMapping
  @Operation(
      summary = "Crear un Personaje",
      description = "Este servicio permite la creacion de un Personaje.")
  public ResponseEntity<PersonajeResponse> createPersonaje(
      @RequestBody
          PersonajeRequest personajeRequest) {

    return new ResponseEntity<>(
        personajeService.createPersonaje(
                personajeRequest.construct())
            .completePersonajeResponse(),
        HttpStatus.OK);
  }

  @DeleteMapping("/{personajeId")
  @Operation(
      summary = "Eliminar un Personaje",
      description = "Este servicio permite la eliminacion de un Personaje, seleccionandolo por su Id")

  public ResponseEntity<HttpStatus> eliminarPersonaje(
      @PathVariable
          long personajeId) {

    personajeService.detelePersonaje(personajeId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PatchMapping("/{personajeId}")
  @Operation(
      summary = "Modificar un personaje",
      description = "Este Servicio permite modificar un Personaje")
  public ResponseEntity<HttpStatus> actualizarPersonaje(
      @PathVariable
          long personajeId,
      @RequestBody
          PersonajeRequest personajeRequest) throws Exception {

    personajeService.actualizarPersonaje(
        personajeRequest, personajeId);
    return new ResponseEntity<>(HttpStatus.OK);

  }

  @GetMapping
  @Operation(
      summary = "Obtener todas los Personajes.",
      description = "Este servicio permite obtener todos los Personajes, mostrando unicamente su imagen y nombre de manera paginada.")
  public ResponseEntity<List<PersonajesResponse>> getAllPersonajes() {

    return new ResponseEntity<>(
        personajeService.getAllPersonajes()
            .stream()
            .map(Personaje::shortedPersonajeResponse)
            .collect(Collectors.toList()),
        HttpStatus.OK);

  }

  @GetMapping("/{personajeId}")
  @Operation(
      summary = "Obtener un Personaje con todas sus caracterizticas.",
      description =
          "Este servicio permite obtener un Personaje por su ID, mostrando todas sus caracterizticas"
              + " por su ID.")
  public ResponseEntity<PersonajeResponse> getPersonajeById(
      @PathVariable
          long personajeId) throws Exception {

    return new ResponseEntity<>(
        personajeService.getPersonajeById(personajeId)
            .completePersonajeResponse(),
        HttpStatus.OK);
  }


//  @GetMapping
//  @Operation(
//      summary = "Obtener todos los Lotes con filtros por un StateEnum.",
//      description = "Este servicio permite obtener todos los Lotes filtrandolos"
//          + " por StateEnum, de manera paginada.")
//  public ResponseEntity<PersonajeResponse> getPersonajesConFiltro(
//      @RequestParam(required = false)
//          String nombre,
//      @RequestParam(defaultValue = "0")
//          int edad,
//      @RequestParam(defaultValue = "10")
//          double peso) {
//
//    Specification<Personaje> specification =
//        Objects.requireNonNull(
//            where(new LoteWithState(state))
//                .and(new OwnLotes(
//                    loggedUserManager,
//                    authentication)));
//
//    Page<Lote> pagedLotes = loteService.findAllLotes(
//        specification,
//        filterManager.getPageable(
//            SortEnum.DESC,
//            pageNumber,
//            pageSize));
//
//    return new ResponseEntity<>(
//        new PagedResponse(
//            pagedLotes.getNumber(),
//            pagedLotes.getNumberOfElements(),
//            pagedLotes.getTotalPages(),
//            pagedLotes.getTotalElements(),
//            pagedLotes.stream()
//                .map(
//                    Lote::response)
//                .collect(Collectors.toList())),
//        HttpStatus.OK);
//
//  }

}
