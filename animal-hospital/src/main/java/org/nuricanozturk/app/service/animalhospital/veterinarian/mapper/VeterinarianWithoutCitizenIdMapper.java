package org.nuricanozturk.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianWithoutCitizenIdDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinariansWithoutCitizenIdDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class VeterinarianWithoutCitizenIdMapper implements IVeterinarianWithoutCitizenIdMapper
{

    @Override
    public VeterinarianWithoutCitizenIdDTO toVeterinarianWithoutCitizenIdDTO(VeterinarianWithoutCitizenId veterinarian)
    {
        var dto = new VeterinarianWithoutCitizenIdDTO();

        dto.diplomaNo = veterinarian.diplomaNo;
        dto.firstName = veterinarian.firstName;
        dto.middleName = veterinarian.middleName.orElse(null);
        dto.lastName = veterinarian.lastName;
        dto.birthDate = veterinarian.birthDate;
        dto.registerDate = veterinarian.registerDate;

        return dto;
    }

}
