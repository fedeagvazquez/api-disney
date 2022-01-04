package com.disney.apidisney.services;

import com.disney.apidisney.entities.model.PeliculaSerie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PeliculaSeriesService {

  List<PeliculaSerie> getAllPeliculaSeries();

  PeliculaSerie createPeliculaSerie(
          PeliculaSerie peliculaSerie);

}
