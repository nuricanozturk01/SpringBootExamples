package org.csystem.animalhospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public class VeterinarianAnimalSaveDTO
{
    public int animalId;
    public long diplomaNo;
    public double price;
}
