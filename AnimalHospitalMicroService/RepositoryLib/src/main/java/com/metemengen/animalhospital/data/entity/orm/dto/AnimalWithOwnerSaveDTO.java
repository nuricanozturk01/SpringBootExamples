package com.metemengen.animalhospital.data.entity.orm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AnimalWithOwnerSaveDTO extends AnimalDTO
{
    public String ownerName;
    public String phone;
    public String address;

}


