package org.csystem.app.service.animalhospital.animal.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.AnimalServiceHelper;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalMapper;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalOwnerDetailsMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import static org.csystem.util.collection.CollectionUtil.toList;
@Service
public class AnimalAppService {
    private final AnimalServiceHelper m_animalServiceHelper;
    private final IAnimalMapper m_animalMapper;

    public AnimalAppService(@Qualifier(BeanName.ANIMAL_SERVICE_HELPER) AnimalServiceHelper animalServiceHelper,
                            IAnimalMapper animalMapper )
    {
        m_animalServiceHelper = animalServiceHelper;
        m_animalMapper = animalMapper;
    }

    public AnimalsDTO findByNameContainsAndSterile(String name, boolean sterile)
    {
        return m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByNameContainsAndSterile(name, sterile),
                m_animalMapper::toAnimalDTO));
    }

    public AnimalsDTO findByType(String type)
    {
        return m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByType(type), m_animalMapper::toAnimalDTO));
    }

    public AnimalsDTO findByMonthAndYear(int mon, int year)
    {
        return m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByMonthAndYear(mon, year), m_animalMapper::toAnimalDTO));
    }
}
