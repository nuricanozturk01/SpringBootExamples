package org.nuricanozturk.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.dto.VeterinarianSave;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class VeterinarianSaveMapper implements IVeterinarianSaveMapper
{
    @Override
    public VeterinarianSave toVeterinarianSave(VeterinarianSaveDTO veterinarian)
    {
        var dto = new VeterinarianSave();

        dto.diplomaNo = veterinarian.diplomaNo;
        dto.citizenId = veterinarian.citizenId;
        dto.firstName = veterinarian.firstName;
        dto.middleName = veterinarian.middleName;
        dto.lastName = veterinarian.lastName;
        dto.birthDate = veterinarian.birthDate;
        dto.registerDate = veterinarian.registerDate;

        return dto;
    }
}
