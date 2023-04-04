package com.metemengen.animalhospital.data.entity;

import java.util.Set;

public class OwnerAnimalDetails
{
    public String name;
    public String phone;
    public String address;
    //public Set<AnimalOwner> animals;

    public OwnerAnimalDetails(String name, String phone, String address)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
        //this.animals = animals;
    }


}
