package com.disney.apidisney.controllers;

import com.disney.apidisney.entities.dtos.requests.PeliculaSerieRequest;
import com.disney.apidisney.entities.dtos.responses.PeliculaSerieResponse;
import com.disney.apidisney.entities.dtos.responses.PeliculasSeriesResponse;
import com.disney.apidisney.entities.model.PeliculaSerie;
import com.disney.apidisney.services.PeliculaSeriesService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class PeliculaSeriesController {

  private final PeliculaSeriesService peliculaSeriesService;

  @GetMapping
  @Operation(
      summary = "Obtener todas las Peliculas y series.",
      description = "Este servicio permite obtener todas las peliculas y series, mostrando  su imagen "
          + "y titulo y fecha de creacion de manera paginada.")
  public ResponseEntity<List<PeliculasSeriesResponse>> getAllPeliculaSeries() {

    return new ResponseEntity<>(
        peliculaSeriesService.getAllPeliculaSeries()
            .stream()
            .map(PeliculaSerie::shortedPeliculaSerieResponse)
            .collect(Collectors.toList()),
        HttpStatus.OK);

  }

  @PostMapping
  @Operation(
          summary = "Crear una Pelicula o Serie",
          description = "Este servicio permite la creacion de una Pelicula o Serie.")
  public ResponseEntity<PeliculaSerieResponse> createPeliculaSerie(
          @RequestBody
                  PeliculaSerieRequest peliculaSerieRequest) {

    return new ResponseEntity<>(
            peliculaSeriesService.createPeliculaSerie(
                            peliculaSerieRequest.construct())
                    .completePeliculaSerieResponse(),
            HttpStatus.OK);
  }



}
