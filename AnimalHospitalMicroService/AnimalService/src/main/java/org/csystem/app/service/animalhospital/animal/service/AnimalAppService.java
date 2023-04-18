package org.csystem.app.service.animalhospital.animal.service;

import com.karandev.util.data.error.DataUtil;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.AnimalServiceHelper;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsWithoutOwnerDTO;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalMapper;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalOwnerDetailsMapper;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalWithoutOwnerMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.StreamSupport;

import static com.karandev.util.data.error.DataUtil.doForDataService;
import static org.csystem.util.collection.CollectionUtil.toList;
@Service
public class AnimalAppService {
    private final AnimalServiceHelper m_animalServiceHelper;
    private final IAnimalMapper m_animalMapper;
    private final IAnimalOwnerDetailsMapper m_animalOwnerDetailsMapper;
    private final IAnimalWithoutOwnerMapper m_animalWithoutOwnerMapper;

    public AnimalAppService(@Qualifier(BeanName.ANIMAL_SERVICE_HELPER) AnimalServiceHelper animalServiceHelper,
                            IAnimalOwnerDetailsMapper animalOwnerDetailsMapper,
                            IAnimalWithoutOwnerMapper animalWithoutOwnerMapper,
                            IAnimalMapper animalMapper )
    {
        m_animalWithoutOwnerMapper = animalWithoutOwnerMapper;
        m_animalOwnerDetailsMapper = animalOwnerDetailsMapper;
        m_animalServiceHelper = animalServiceHelper;
        m_animalMapper = animalMapper;
    }

    public AnimalsDTO findByNameContainsAndSterile(String name, boolean sterile)
    {
        return doForDataService(() -> m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByNameContainsAndSterile(name, sterile),
                        m_animalMapper::toAnimalDTO)),
                "AnimalService.findByNameContainsAndSterile");
    }

    public AnimalsWithoutOwnerDTO findByType(String type)
    {
        return doForDataService(() -> m_animalWithoutOwnerMapper.toAnimalsWithoutOwnerDTO(StreamSupport.stream(m_animalServiceHelper.findAnimalsByType(type).spliterator(), false).toList()),
                "AnimalService.findByType");
    }

    public AnimalsDTO findByMonthAndYear(int mon, int year)
    {
        return doForDataService(() -> m_animalMapper.toAnimalsDTO(toList(m_animalServiceHelper.findAnimalsByMonthAndYear(mon, year), m_animalMapper::toAnimalDTO)),
                "AnimalService.findByMonthAndYear");
    }

    public AnimalsOwnerDetailsDTO findByName(String name)
    {
        return doForDataService(() -> m_animalOwnerDetailsMapper.toAnimalsOwnerDetailsDTO(StreamSupport.stream(m_animalServiceHelper.findByName(name).spliterator(), false).toList()),
                "AnimalService.findByName");
    }
    public AnimalsOwnerDetailsDTO findByVeterinarianDiplomaNo(long no)
    {
        return doForDataService(() -> m_animalOwnerDetailsMapper.toAnimalsOwnerDetailsDTO(StreamSupport.stream(m_animalServiceHelper.findByVeterinarianDiplomaNo(no).spliterator(), false).toList()),
               "AnimalService.findByVeterinarianDiplomaNo");
    }
}
