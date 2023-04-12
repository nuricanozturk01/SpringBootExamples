package org.csystem.app.service.animalhospital.animal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metemengen.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;

import java.util.List;


public class AnimalsWithoutOwnerDTO
{
    @JsonProperty("animals without owner")
    public List<IAnimalWithoutOwner> animals;

}
