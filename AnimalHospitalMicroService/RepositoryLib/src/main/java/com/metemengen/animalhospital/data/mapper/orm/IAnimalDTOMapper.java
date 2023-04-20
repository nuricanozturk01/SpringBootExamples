package com.metemengen.animalhospital.data.mapper.orm;

import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AnimalDTOMapperImpl", componentModel = "spring")
public interface IAnimalDTOMapper
{
    Animal toAnimalDTO(AnimalDTO animalDTO);
}
