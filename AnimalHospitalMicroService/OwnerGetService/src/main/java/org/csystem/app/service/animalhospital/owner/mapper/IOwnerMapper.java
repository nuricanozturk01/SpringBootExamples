package org.csystem.app.service.animalhospital.owner.mapper;

import com.metemengen.animalhospital.data.entity.Animal;
import com.metemengen.animalhospital.data.entity.Owner;
import org.csystem.app.service.animalhospital.owner.data.AnimalDTO;
import org.csystem.app.service.animalhospital.owner.data.OwnerDTO;
import org.csystem.app.service.animalhospital.owner.data.OwnersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "OwnerMapperImpl", componentModel = "spring")
public interface IOwnerMapper
{
    OwnerDTO toOwnerDTO(Owner owner);
    AnimalDTO toAnimalDTO(Animal animal);

    default OwnersDTO toOwnersDTO(List<OwnerDTO> owners)
    {
        var dto = new OwnersDTO();

        dto.owners = owners;


        return dto;
    }
}
