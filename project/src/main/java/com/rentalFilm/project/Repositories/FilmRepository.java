package com.rentalFilm.project.Repositories;

import com.rentalFilm.project.Entities.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository <Film, Long> {

}
