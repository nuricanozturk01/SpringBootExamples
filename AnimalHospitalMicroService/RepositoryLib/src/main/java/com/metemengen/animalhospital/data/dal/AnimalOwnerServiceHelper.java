package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import com.metemengen.animalhospital.data.repository.orm.IOwnerRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.karandev.util.data.error.DataUtil.doForRepository;

@Component(BeanName.OWNER_SERVICE_HELPER)
@Lazy
public class AnimalOwnerServiceHelper
{
    private final IOwnerRepository m_animalOwnerRepository;

    public AnimalOwnerServiceHelper (@Qualifier(BeanName.OWNER_REPOSITORY)
                                     IOwnerRepository animalOwnerRepository)
    {
        m_animalOwnerRepository = animalOwnerRepository;
    }

    public Owner findByPhone(String phone)
    {
        return doForRepository(() ->  m_animalOwnerRepository.findByPhone(phone).get(), "AnimalOwnerServiceHelper.findByPhone");
    }
}
