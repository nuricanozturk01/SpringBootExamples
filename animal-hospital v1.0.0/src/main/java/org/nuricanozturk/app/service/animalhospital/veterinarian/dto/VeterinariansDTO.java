package org.nuricanozturk.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;
import java.util.List;

public class VeterinariansDTO
{
    //@JsonProperty("vets")
    public List<VeterinarianDTO> veterinarians;
}
