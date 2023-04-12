package com.metemengen.animalhospital.data.entity.orm.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

// Interface Projection
public interface IAnimalWithoutOwner
{
    int getId();
    String getType();

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate getBirthDate();
    String getName();
    boolean getSterile();
}
