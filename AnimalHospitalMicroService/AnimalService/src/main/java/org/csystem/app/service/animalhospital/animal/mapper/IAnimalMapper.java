package org.csystem.app.service.animalhospital.animal.mapper;

import com.metemengen.animalhospital.data.entity.Animal;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.csystem.app.service.animalhospital.animal.dto.AnimalDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AnimalMapperImpl", componentModel = "spring")
public interface IAnimalMapper
{
    AnimalDTO toAnimalDTO(Animal animal);

    default AnimalsDTO toAnimalsDTO(List<AnimalDTO> animalDTOS)
    {
        var dto = new AnimalsDTO();

        dto.animals = animalDTOS;

        return dto;
    }
}
