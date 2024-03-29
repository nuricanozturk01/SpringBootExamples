package org.csystem.app.service.animalhospital.veterinarian.service;

import com.karandev.util.data.error.DataUtil;
import com.karandev.util.data.repository.exception.RepositoryException;
import com.karandev.util.data.service.DataServiceException;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;

import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianSaveMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class VeterinarianService
{
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianSaveMapper m_veterinarianSaveMapper;


    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper veterinarianServiceHelper,
                               IVeterinarianSaveMapper veterinarianSaveMapper
                               )
    {
        m_veterinarianServiceHelper = veterinarianServiceHelper;
        m_veterinarianSaveMapper = veterinarianSaveMapper;
    }

    public VeterinarianSaveDTO saveVeterinarian(VeterinarianSaveDTO veterinarianSaveDTO)
    {
        DataUtil.doForDataService(() -> m_veterinarianServiceHelper.save(m_veterinarianSaveMapper.toVeterinarianSave(veterinarianSaveDTO)),"VeterinarianService.saveVeterinarian");
        return veterinarianSaveDTO;
    }


}
