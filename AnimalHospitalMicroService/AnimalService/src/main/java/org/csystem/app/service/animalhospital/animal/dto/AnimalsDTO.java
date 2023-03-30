package org.csystem.app.service.animalhospital.animal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;


public class AnimalsDTO
{
    @JsonProperty("sterile animals")
    public List<AnimalDTO> animals;

}
