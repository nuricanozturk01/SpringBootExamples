package org.csystem.app.service.animalhospital.veterinarian.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithFullName;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianWithFullNameDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianWithoutCitizenIdDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithFullNameDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithoutCitizenIdDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "VeterinarianWithFullNameMapperImpl", componentModel = "spring")
public interface IVeterinarianWithFullNameMapper
{
    VeterinarianWithFullNameDTO toVeterinarianWithFullName(VeterinarianWithFullName veterinarian);

    default VeterinariansWithFullNameDTO toVeterinariansWithFullName(List<VeterinarianWithFullNameDTO> veterinarians)
    {
        var dto = new VeterinariansWithFullNameDTO();

        dto.vets = veterinarians;

        return dto;
    }
}
