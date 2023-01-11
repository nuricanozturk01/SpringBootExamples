package com.metemengen.animalhospital.data.mapper;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dto.VeterinarianSave;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.VETERINARIAN_MAPPER)
public class VeterinarianMapper implements IVeterinarianMapper
{

    @Override
    public VeterinarianSave toVeterinarianSave(Veterinarian veterinarian)
    {
        var save = new VeterinarianSave();

        save.birthDate = veterinarian.birthDate;
        save.registerDate = veterinarian.registerDate;
        save.citizenId = veterinarian.citizenId;
        save.diplomaNo = veterinarian.diplomaNo;
        save.firstName = veterinarian.firstName;
        save.middleName = veterinarian.middleName.orElse(null);
        save.lastName = veterinarian.lastName;

        return save;
    }

    @Override
    public Veterinarian toVeterinarian(VeterinarianSave vsave)
    {
        return new Veterinarian(vsave.diplomaNo, vsave.citizenId, vsave.firstName, Optional.of(vsave.middleName), vsave.lastName,
                vsave.birthDate, vsave.registerDate);
    }
}
