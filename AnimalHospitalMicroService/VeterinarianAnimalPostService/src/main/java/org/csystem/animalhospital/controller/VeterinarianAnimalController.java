package org.csystem.animalhospital.controller;


import org.csystem.animalhospital.dto.VeterinarianAnimalSaveDTO;
import org.csystem.animalhospital.service.VeterinarianAnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vetan")
public class VeterinarianAnimalController
{
    private final VeterinarianAnimalService m_service;

    public VeterinarianAnimalController(VeterinarianAnimalService service)
    {
        m_service = service;
    }

    @GetMapping("idx")
    public String hello()
    {
        return "HELLO!";
    }
    @PostMapping("save")
    public ResponseEntity<Boolean> saveVeterinarianAnimal(@RequestBody VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO)
    {
        return ResponseEntity.accepted().body(m_service.saveVeterinarianAnimal(veterinarianAnimalSaveDTO));
    }
}
