package org.csystem.app.service.animalhospital.veterinarian.controller;

import com.metemengen.animalhospital.data.BeanName;
import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.csystem.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vets/post")
public class VeterinarianController {
    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService)
    {
        m_veterinarianService = veterinarianService;
    }


    @PostMapping("vet/save")
    public VeterinarianSaveDTO save(@RequestBody VeterinarianSaveDTO veterinarianSave)
    {
        return m_veterinarianService.saveVeterinarian(veterinarianSave);
    }

}
