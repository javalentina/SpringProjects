package de.ait.city.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CityRequestDTO {
    private String name;

    private String country;

    private int population;

    private int area;
}
