package org.csystem.app.service.animalhospital.veterinarian.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;

import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianSaveMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithFullNameMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithoutCitizenIdMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class VeterinarianService
{
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianMapper m_veterinarianMapper;
    private final IVeterinarianSaveMapper m_veterinarianSaveMapper;
    private final IVeterinarianWithFullNameMapper m_veterinarianWithFullNameMapper;

    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper veterinarianServiceHelper,
                               IVeterinarianMapper veterinarianMapper,
                               IVeterinarianSaveMapper veterinarianSaveMapper,
                               IVeterinarianWithFullNameMapper veterinarianWithFullNameMapper)
    {
        m_veterinarianWithFullNameMapper = veterinarianWithFullNameMapper;
        m_veterinarianServiceHelper = veterinarianServiceHelper;
        m_veterinarianMapper = veterinarianMapper;
        m_veterinarianSaveMapper = veterinarianSaveMapper;
    }

    public CountDTO countVeterinarians()
    {
        return m_veterinarianMapper.toCountDTO(m_veterinarianServiceHelper.countVeterinarians());
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return m_veterinarianServiceHelper.findVeterinarianById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO);
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO));
        //return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName).spliterator(), false)
          //      .map(m_veterinarianMapper::toVeterinarianDTO).collect(Collectors.toList()));
    }
    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year), m_veterinarianMapper::toVeterinarianDTO));
    }

    public VeterinariansWithFullNameDTO findVeterinariansByYearBetween(int begin, int end)
    {
        return m_veterinarianWithFullNameMapper.toVeterinariansWithFullName(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByYearBetween(begin,end),
                m_veterinarianWithFullNameMapper::toVeterinarianWithFullName));
    }

    public VeterinarianSaveDTO saveVeterinarian(VeterinarianSaveDTO veterinarianSaveDTO)
    {
        m_veterinarianServiceHelper.save(m_veterinarianSaveMapper.toVeterinarianSave(veterinarianSaveDTO));

        return veterinarianSaveDTO;
    }

    public VeterinariansDTO findVeterinarianByYear(int year)
    {
        return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByYear(year).spliterator(), false)
                .map(m_veterinarianMapper::toVeterinarianDTO).toList());
    }

    public VeterinariansDTO findVeterinarianByMonth(int month)
    {
        return m_veterinarianMapper.toVeterinariansDTO
                (CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByMonth(month),
                        m_veterinarianMapper::toVeterinarianDTO));
       /* return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByMonth(month).spliterator(), false)
                .map(m_veterinarianMapper::toVeterinarianDTO).toList());*/
    }

    //...
}
