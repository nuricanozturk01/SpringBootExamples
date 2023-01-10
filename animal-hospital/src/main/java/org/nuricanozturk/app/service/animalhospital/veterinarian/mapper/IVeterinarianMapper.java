package org.nuricanozturk.app.service.animalhospital.veterinarian.mapper;

import org.nuricanozturk.app.service.animalhospital.veterinarian.data.entity.Veterinarian;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;

public interface IVeterinarianMapper
{
    VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian);
}
