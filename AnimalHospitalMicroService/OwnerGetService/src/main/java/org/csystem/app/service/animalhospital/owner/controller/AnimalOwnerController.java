package org.csystem.app.service.animalhospital.owner.controller;

import org.csystem.app.service.animalhospital.owner.dto.OwnerDTO;
import org.csystem.app.service.animalhospital.owner.dto.OwnersDTO;
import org.csystem.app.service.animalhospital.owner.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/animalowners")
public class AnimalOwnerController
{
    private final OwnerService m_ownerService;

    public AnimalOwnerController(OwnerService ownerService)
    {
        m_ownerService = ownerService;
    }


    @GetMapping("find/owner/phone")
    public OwnerDTO findOwnersByPhone(@RequestParam("phone") String phone)
    {
        return m_ownerService.findOwnersByPhone(phone);
    }
}
