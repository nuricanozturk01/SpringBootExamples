package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Owner;
import com.metemengen.animalhospital.data.repository.IAnimalOwnerRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(BeanName.OWNER_SERVICE_HELPER)
@Lazy
public class AnimalOwnerServiceHelper
{
    private final IAnimalOwnerRepository m_animalOwnerRepository;

    public AnimalOwnerServiceHelper (@Qualifier(BeanName.OWNER_REPOSITORY)
                                     IAnimalOwnerRepository animalOwnerRepository)
    {
        m_animalOwnerRepository = animalOwnerRepository;
    }

    public Iterable<Owner> findByPhone(String phone)
    {
        return m_animalOwnerRepository.findByPhone(phone);
    }
}
