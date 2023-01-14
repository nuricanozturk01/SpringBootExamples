package org.nuricanozturk.app.service.animalhospital.veterinarian.service;

import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import com.metemengen.animalhospital.data.dto.VeterinarianSave;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.*;
import org.nuricanozturk.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.nuricanozturk.app.service.animalhospital.veterinarian.mapper.IVeterinarianSaveMapper;
import org.nuricanozturk.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithoutCitizenIdMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static com.metemengen.animalhospital.data.BeanName.VETERINARIAN_SERVICE_HELPER;

@Service
public class VeterinarianService
{
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianMapper m_veterinarianMapper;
    private final IVeterinarianWithoutCitizenIdMapper m_veterinarianWithoutCitizenIdMapper;
    private final IVeterinarianSaveMapper m_veterinarianSaveMapper;


    public VeterinarianService(@Qualifier(VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper m_veterinarianServiceHelper,
                               IVeterinarianMapper m_veterinarianMapper,
                               IVeterinarianWithoutCitizenIdMapper m_veterinarianWithoutCitizenIdMapper,
                               IVeterinarianSaveMapper veterinarianSaveMapper)
    {
        this.m_veterinarianServiceHelper = m_veterinarianServiceHelper;
        this.m_veterinarianMapper = m_veterinarianMapper;
        this.m_veterinarianWithoutCitizenIdMapper = m_veterinarianWithoutCitizenIdMapper;
        m_veterinarianSaveMapper = veterinarianSaveMapper;
    }

    public long getVeterinarianCount()
    {
        return m_veterinarianServiceHelper.countVeterinarians();
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return m_veterinarianServiceHelper.findVeterinariansById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO);
    }

    // changed from Iterable<VeterinarianDTO> for display like array
    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return m_veterinarianMapper.toVeterinariansDTO(StreamSupport
                .stream(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName).spliterator(), false)
                .map(m_veterinarianMapper::toVeterinarianDTO)
                .toList());
    }

    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        return m_veterinarianMapper.toVeterinariansDTO(StreamSupport
                .stream(m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year).spliterator(), false)
                .map(m_veterinarianMapper::toVeterinarianDTO)
                .toList());
    }

    public VeterinariansDTO findVeterinariansByMonth(int month)
    {
        return m_veterinarianMapper.toVeterinariansDTO(
                StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByMonth(month).spliterator(), false)
                        .map(m_veterinarianMapper::toVeterinarianDTO).toList());
    }

    public VeterinariansDTO findVeterinariansByYear(int year)
    {
        return m_veterinarianMapper.toVeterinariansDTO(
                StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByYear(year).spliterator(), false)
                        .map(m_veterinarianMapper::toVeterinarianDTO).toList());
    }

    public VeterinariansWithoutCitizenIdDTO findVeterinariansByYearBetween(int before, int after)
    {
        return m_veterinarianWithoutCitizenIdMapper.toVeterinariansWithoutCitizenIdDTO(
                StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByYearBetween(before, after).spliterator(), false)
                        .map(m_veterinarianWithoutCitizenIdMapper::toVeterinarianWithoutCitizenIdDTO).toList());
    }


    public VeterinarianSaveDTO saveVeterinarian(VeterinarianSaveDTO veterinarianSaveDTO)
    {

        m_veterinarianSaveMapper.toVeterinarianSave(m_veterinarianServiceHelper.save(m_veterinarianSaveMapper.toVeterinarianSave(veterinarianSaveDTO)));
    }


}
