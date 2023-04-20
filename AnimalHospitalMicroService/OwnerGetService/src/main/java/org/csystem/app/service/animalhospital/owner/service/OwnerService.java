package org.csystem.app.service.animalhospital.owner.service;

import com.karandev.util.data.error.DataUtil;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.AnimalOwnerServiceHelper;

import org.csystem.app.service.animalhospital.owner.dto.OwnerDTO;
import org.csystem.app.service.animalhospital.owner.dto.OwnersDTO;
import org.csystem.app.service.animalhospital.owner.mapper.IOwnerMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

import static com.karandev.util.data.error.DataUtil.doForDataService;

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

    public OwnerDTO findOwnersByPhone(String phone)
    {
        return doForDataService(() -> m_ownerMapper.toOwnerDTO(m_animalOwnerServiceHelper.findByPhone(phone)),
                "OwnerService.findOwnersByPhone");
    }
}
