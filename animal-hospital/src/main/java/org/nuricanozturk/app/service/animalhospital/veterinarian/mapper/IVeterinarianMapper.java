package org.nuricanozturk.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.entity.Veterinarian;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;

import java.util.List;
public interface IVeterinarianMapper
{
    VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian);
    default VeterinariansDTO toVeterinariansDTO(List<VeterinarianDTO> vets)
    {
        var dto = new VeterinariansDTO();
        dto.veterinarians = vets;
        return dto;
    }
}
