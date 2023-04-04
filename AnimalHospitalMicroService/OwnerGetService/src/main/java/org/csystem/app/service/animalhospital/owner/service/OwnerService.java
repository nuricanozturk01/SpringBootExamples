package org.csystem.app.service.animalhospital.owner.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.AnimalOwnerServiceHelper;

import org.csystem.app.service.animalhospital.owner.data.OwnersDTO;
import org.csystem.app.service.animalhospital.owner.mapper.IOwnerMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class OwnerService
{
    private final AnimalOwnerServiceHelper m_animalOwnerServiceHelper;
    private final IOwnerMapper m_ownerMapper;

    public OwnerService(@Qualifier(BeanName.OWNER_SERVICE_HELPER)
                        AnimalOwnerServiceHelper animalOwnerServiceHelper,
                        IOwnerMapper ownerMapper)
    {
        m_ownerMapper = ownerMapper;
        m_animalOwnerServiceHelper = animalOwnerServiceHelper;
    }

    public OwnersDTO findOwnersByPhone(String phone)
    {
        return m_ownerMapper.toOwnersDTO(StreamSupport.stream(m_animalOwnerServiceHelper.findByPhone(phone).spliterator(), false).toList());
    }
}
