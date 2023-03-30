package org.csystem.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VeterinariansWithFullNameDTO
{
    @JsonProperty("veterinariansFullName")
    public List<VeterinarianWithFullNameDTO> vets;
}
