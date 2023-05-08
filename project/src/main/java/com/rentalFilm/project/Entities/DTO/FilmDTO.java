package com.rentalFilm.project.Entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private Long ID;
    private String title;
    private String description;
    private int releaseYear;


}
