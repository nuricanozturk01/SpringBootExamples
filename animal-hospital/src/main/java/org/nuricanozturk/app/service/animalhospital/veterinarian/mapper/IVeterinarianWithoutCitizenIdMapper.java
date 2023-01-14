package org.nuricanozturk.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianWithoutCitizenIdDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinariansWithoutCitizenIdDTO;

import java.util.List;

public interface IVeterinarianWithoutCitizenIdMapper
{
    VeterinarianWithoutCitizenIdDTO toVeterinarianWithoutCitizenIdDTO(VeterinarianWithoutCitizenId veterinarian);
    default VeterinariansWithoutCitizenIdDTO toVeterinariansWithoutCitizenIdDTO(List<VeterinarianWithoutCitizenIdDTO> vets)
    {
        var dto = new VeterinariansWithoutCitizenIdDTO();
        dto.veterinariansWithoutCitizenId = vets;
        return dto;
    }
}
