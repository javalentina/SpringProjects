package de.ait.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserResponseDTO {
    private Long id;
    private String name;
    private int age;

}