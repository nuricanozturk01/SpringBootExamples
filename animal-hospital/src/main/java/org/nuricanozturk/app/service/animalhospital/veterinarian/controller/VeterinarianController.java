package org.nuricanozturk.app.service.animalhospital.veterinarian.controller;

import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vet")
public class VeterinarianController
{
    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService m_veterinarianService)
    {
        this.m_veterinarianService = m_veterinarianService;
    }

    @GetMapping("count")
    public long getVeterinarianCount()
    {
        return m_veterinarianService.getVeterinarianCount();
    }

    @GetMapping("diploma") // ResponseEntity'in optional parametreli of metodu. Bulamazsa notFound döner
    public ResponseEntity<VeterinarianDTO> getVeterinarians(@RequestParam("dno") long diplomaNo)
    {
        return ResponseEntity.of(m_veterinarianService.findVeterinarianByDiplomaNo(diplomaNo));
    }
}
