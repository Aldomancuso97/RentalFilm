package com.rentalFilm.project.Repositories;

import com.rentalFilm.project.Entities.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository <Language, Long> {
}
