package com.rentalFilm.project.Entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    private String firstname;

    private String lastname;

    private LocalDateTime date;
}
