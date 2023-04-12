package org.csystem.app.service.animalhospital.animal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;

import java.util.List;

public class AnimalsOwnerDetailsDTO {

    @JsonProperty("animalowners")
    //AnimaşOwnerDetails meteden geliyor
    public List<AnimalOwnerDetails> animals;
}
