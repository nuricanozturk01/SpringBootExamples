package com.metemengen.animalhospital.data.dal;

import com.karandev.util.data.error.DataUtil;
import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.karandev.util.data.error.DataUtil.doForRepository;
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
        return doForRepository(() -> m_animalRepository.findById(id), "AnimalServiceHelper.findAnimalsByMonthAndYear");
    }
    public Iterable<Animal> findAnimalsByNameContainsAndSterile(String name, boolean sterile)
    {
        return doForRepository(() -> m_animalRepository.findByNameContainsAndSterile(name, sterile), "AnimalServiceHelper.findAnimalsByMonthAndYear");
    }
    public Iterable<Animal> findAnimalsByMonthAndYear(int mon, int year)
    {
        return doForRepository(() -> m_animalRepository.findByMonthAndYear(mon, year), "AnimalServiceHelper.findAnimalsByMonthAndYear");
    }
    public Iterable<AnimalOwnerDetails> findByName (String name)
    {
        return doForRepository(() -> m_animalRepository.findByName(name), "AnimalServiceHelper.findByName");
    }
    public Iterable<IAnimalWithoutOwner> findAnimalsByType(String type)
    {
        return doForRepository(() -> m_animalRepository.findByType(type), "AnimalServiceHelper.findAnimalsByType");
    }

    public Iterable<AnimalOwnerDetails> findByVeterinarianDiplomaNo(long no)
    {
        return doForRepository(() -> m_animalRepository.findByVeterinarianDiplomaNo(no), "AnimalServiceHelper.findByVeterinarianDiplomaNo");
    }
}
