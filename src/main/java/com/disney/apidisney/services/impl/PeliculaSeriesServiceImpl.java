package com.disney.apidisney.services.impl;

import com.disney.apidisney.entities.model.PeliculaSerie;
import com.disney.apidisney.repositories.PeliculaSerieRepository;
import com.disney.apidisney.services.PeliculaSeriesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PeliculaSeriesServiceImpl implements PeliculaSeriesService {

  private final PeliculaSerieRepository peliculaSerieRepository;

  @Override
  public List<PeliculaSerie> getAllPeliculaSeries() {
    return peliculaSerieRepository.findAll();
  }
}
