package org.csystem.animalhospital.mapper;

import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import org.csystem.animalhospital.dto.VeterinarianAnimalSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "VeterinarianAnimalMapperImpl", componentModel = "spring")
public interface IVeterinarianAnimalMapper
{
    VeterinarianAnimalSave toVeterinarianAnimalSave(VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO);
}
