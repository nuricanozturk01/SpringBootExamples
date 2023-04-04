package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.entity.Animal;
import com.metemengen.animalhospital.data.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.metemengen.animalhospital.data.BeanName.ANIMAL_REPOSITORY;
import static com.metemengen.animalhospital.data.BeanName.ANIMAL_SERVICE_HELPER;

@Component(ANIMAL_SERVICE_HELPER)
@Lazy
public class AnimalServiceHelper
{
    private final IAnimalRepository m_animalRepository;

    public AnimalServiceHelper(IAnimalRepository animalRepository)
    {
        m_animalRepository = animalRepository;
    }
    public Optional<Animal> findAnimalById(int id)
    {
        return m_animalRepository.findById(id);
    }
    public Iterable<Animal> findAnimalsByNameContainsAndSterile(String name, boolean sterile)
    {
        return m_animalRepository.findByNameContainsAndSterile(name, sterile);
    }
    public Iterable<Animal> findAnimalsByMonthAndYear(int mon, int year)
    {
        return m_animalRepository.findByMonthAndYear(mon, year);
    }

    public Iterable<Animal> findAnimalsByType(String type)
    {
        return m_animalRepository.findByType(type);
    }
}
