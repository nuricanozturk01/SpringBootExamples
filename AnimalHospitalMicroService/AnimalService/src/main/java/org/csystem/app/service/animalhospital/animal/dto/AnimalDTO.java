package org.csystem.app.service.animalhospital.animal.dto;

import com.metemengen.animalhospital.data.entity.Owner;
import com.metemengen.animalhospital.data.entity.Veterinarian;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


public class AnimalDTO
{

    public int id;


    public String name;

    public String type;


    public LocalDate birthDate;


    public boolean sterile;



}
