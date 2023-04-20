package com.metemengen.animalhospital.data.dal;

import com.karandev.util.data.repository.exception.RepositoryException;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import com.metemengen.animalhospital.data.mapper.orm.IAnimalDTOMapper;
import com.metemengen.animalhospital.data.repository.orm.IAnimalRepository;
import com.metemengen.animalhospital.data.repository.orm.IOwnerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(BeanName.ANIMAL_POST_SERVICE_HELPER)
@Lazy
public class AnimalPostServiceHelper
{
    private final IAnimalRepository m_animalRepository;
    private final IOwnerRepository m_ownerRepository;
    private final IAnimalDTOMapper m_animalDTOMapper;

    public AnimalPostServiceHelper(IAnimalRepository animalRepository, IOwnerRepository ownerRepository, IAnimalDTOMapper animalDTOMapper)
    {
        m_animalRepository = animalRepository;
        m_ownerRepository = ownerRepository;
        m_animalDTOMapper = animalDTOMapper;
    }

    private void saveAnimalCallback(AnimalDTO animalWithOwnerSaveDTO, Owner owner)
    {
        var animal = m_animalDTOMapper.toAnimalDTO(animalWithOwnerSaveDTO);

        animal.owner = owner;

        m_animalRepository.save(animal);
        animal.id = animalWithOwnerSaveDTO.id;
    }

    private void saveAnimalEmptyCallback(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        var owner = new Owner();
        owner.phone = animalWithOwnerSaveDTO.phone;
        owner.name = animalWithOwnerSaveDTO.ownerName;
        owner.address = animalWithOwnerSaveDTO.address;

        owner = m_ownerRepository.save(owner);
        saveAnimalCallback(animalWithOwnerSaveDTO, owner);
    }


    @Transactional
    public AnimalWithOwnerSaveDTO saveAnimalWithOwner(AnimalWithOwnerSaveDTO animal)
    {
        var opt = m_ownerRepository.findByPhone(animal.phone);
        opt.ifPresentOrElse(owner -> saveAnimalCallback(animal, owner), () -> saveAnimalEmptyCallback(animal));
        return animal;
    }

    @Transactional
    public AnimalSaveDTO saveAnimal(AnimalSaveDTO animalSaveDTO)
    {
        var opt = m_ownerRepository.findByPhone(animalSaveDTO.phone);

        if (opt.isEmpty())
            throw new RepositoryException("No such phone for owner");

        saveAnimalCallback(animalSaveDTO, opt.get());

        return animalSaveDTO;
    }


}
