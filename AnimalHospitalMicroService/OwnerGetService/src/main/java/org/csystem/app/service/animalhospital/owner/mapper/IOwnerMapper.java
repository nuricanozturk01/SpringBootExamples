package org.csystem.app.service.animalhospital.owner.mapper;

import com.metemengen.animalhospital.data.entity.Animal;
import com.metemengen.animalhospital.data.entity.Owner;
import com.metemengen.animalhospital.data.entity.OwnerAnimalDetails;
import org.csystem.app.service.animalhospital.owner.data.OwnersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "OwnerMapperImpl", componentModel = "spring")
public interface IOwnerMapper
{

    default OwnersDTO toOwnersDTO(List<OwnerAnimalDetails> owners)
    {
        var dto = new OwnersDTO();

        dto.owners = owners;


        return dto;
    }
}
