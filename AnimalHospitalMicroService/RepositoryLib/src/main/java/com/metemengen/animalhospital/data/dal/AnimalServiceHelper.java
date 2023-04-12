package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public Iterable<AnimalOwnerDetails> findByName (String name)
    {
        return m_animalRepository.findByName(name);
    }
    public Iterable<IAnimalWithoutOwner> findAnimalsByType(String type)
    {
        return m_animalRepository.findByType(type);
    }
}
