package com.metemengen.animalhospital.data.entity.orm.dto;

import java.time.LocalDate;

public class AnimalDTO
{
    public int id;
    public String name;
    public String type;
    //@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;

    public boolean sterile;

}
