package org.csystem.animal.post.controller;

import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import org.csystem.animal.post.service.AnimalPostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post/animals")
public class AnimalPostServiceController
{
    private final AnimalPostService m_animalPostService;

    public AnimalPostServiceController(AnimalPostService animalPostService)
    {
        m_animalPostService = animalPostService;
    }

    @PostMapping("save")
    public AnimalWithOwnerSaveDTO saveAnimalWithOwner(@RequestBody AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        return m_animalPostService.saveAnimalWithOwner(animalWithOwnerSaveDTO);
    }
}
