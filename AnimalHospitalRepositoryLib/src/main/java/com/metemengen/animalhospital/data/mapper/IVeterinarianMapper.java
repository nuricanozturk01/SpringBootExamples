package com.metemengen.animalhospital.data.mapper;

import com.metemengen.animalhospital.data.dto.VeterinarianSave;
import com.metemengen.animalhospital.data.entity.Veterinarian;


public interface IVeterinarianMapper
{
    VeterinarianSave toVeterinarianSave(Veterinarian veterinarian);
    Veterinarian toVeterinarian(VeterinarianSave veterinarianSave);
}
