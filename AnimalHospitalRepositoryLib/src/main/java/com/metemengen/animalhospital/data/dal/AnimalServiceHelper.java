package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.repository.IAnimalRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.metemengen.animalhospital.data.BeanName.ANIMAL_REPOSITORY;
import static com.metemengen.animalhospital.data.BeanName.ANIMAL_SERVICE_HELPER;

@Component(ANIMAL_SERVICE_HELPER)
public class AnimalServiceHelper
{
    private final IAnimalRepository m_animalRepository;

    public AnimalServiceHelper(@Qualifier(ANIMAL_REPOSITORY) IAnimalRepository animalRepository)
    {
        m_animalRepository = animalRepository;
    }
}
