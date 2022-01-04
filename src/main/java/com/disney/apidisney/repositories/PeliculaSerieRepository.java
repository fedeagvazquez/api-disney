package com.disney.apidisney.repositories;

import com.disney.apidisney.entities.model.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {

}
