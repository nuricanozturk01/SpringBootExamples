package org.nuricanozturk.app.service.animalhospital.veterinarian.mapper;

import com.metemengen.animalhospital.data.dto.VeterinarianSave;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianWithoutCitizenIdDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinariansWithoutCitizenIdDTO;

import java.util.List;

public interface IVeterinarianSaveMapper
{
    VeterinarianSave toVeterinarianSave(VeterinarianSaveDTO veterinarian);
}
