package org.csystem.app.service.animalhospital.animal.controller;

import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsWithoutOwnerDTO;
import org.csystem.app.service.animalhospital.animal.service.AnimalAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/animals")
public class AnimalController
{
    private final AnimalAppService m_animalAppService;
    public AnimalController(AnimalAppService animalAppService)
    {
        m_animalAppService = animalAppService;
    }
    @GetMapping("contains/sterile/name")
    public AnimalsDTO findByAnimalsOwnersByDiplomaNo(@RequestParam("name") String name)
    {
        return m_animalAppService.findByNameContainsAndSterile(name, true);
    }
    @GetMapping("find/mon/year")
    public AnimalsDTO findByMonthAndYear(@RequestParam("mon") int mon, @RequestParam("year") int year)
    {
        return m_animalAppService.findByMonthAndYear(mon, year);
    }
    @GetMapping("find/type")
    public AnimalsWithoutOwnerDTO findByType(@RequestParam("type") String type)
    {
        return m_animalAppService.findByType(type);
    }

    @GetMapping("/find/name")
    public AnimalsOwnerDetailsDTO findByName(@RequestParam("name") String name)
    {
        return m_animalAppService.findByName(name);
    }

    @GetMapping("/find/diploma")
    public AnimalsOwnerDetailsDTO findByDiplomaNo(@RequestParam("n") long n)
    {
        return m_animalAppService.findByVeterinarianDiplomaNo(n);
    }
}