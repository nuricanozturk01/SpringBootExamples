package org.csystem.app.service.animalhospital.animal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AnimalsOwnerDetailsDTO {

    @JsonProperty("animalowners")
    public List<AnimalOwnerDetailsDTO> animals;
}
