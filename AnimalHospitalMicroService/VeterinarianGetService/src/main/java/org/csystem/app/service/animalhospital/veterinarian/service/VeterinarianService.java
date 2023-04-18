package org.csystem.app.service.animalhospital.veterinarian.service;

import com.karandev.util.data.error.DataUtil;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithFullNameDTO;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithFullNameMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static com.karandev.util.data.error.DataUtil.doForDataService;
import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class VeterinarianService
{
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianMapper m_veterinarianMapper;

    private final IVeterinarianWithFullNameMapper m_veterinarianWithFullNameMapper;

    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper veterinarianServiceHelper,
                               IVeterinarianMapper veterinarianMapper,
                               IVeterinarianWithFullNameMapper veterinarianWithFullNameMapper)
    {
        m_veterinarianWithFullNameMapper = veterinarianWithFullNameMapper;
        m_veterinarianServiceHelper = veterinarianServiceHelper;
        m_veterinarianMapper = veterinarianMapper;
    }

    public CountDTO countVeterinarians()
    {
        return doForDataService(() -> m_veterinarianMapper.toCountDTO(m_veterinarianServiceHelper.countVeterinarians()),
                "VeterinarianService.countVeterinarians");

    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return doForDataService(() -> m_veterinarianServiceHelper.findVeterinarianById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO),
                "VeterinarianService.findVeterinarianByDiplomaNo");
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return doForDataService(() -> m_veterinarianMapper.toVeterinariansDTO(toList(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO)),
                "VeterinarianService.findVeterinariansByLastName");
        //return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName).spliterator(), false)
          //      .map(m_veterinarianMapper::toVeterinarianDTO).collect(Collectors.toList()));
    }
    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        return doForDataService(() -> m_veterinarianMapper.toVeterinariansDTO(toList(m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year), m_veterinarianMapper::toVeterinarianDTO)),
                "VeterinarianService.findVeterinariansByMonthAndYear");
    }

    public VeterinariansWithFullNameDTO findVeterinariansByYearBetween(int begin, int end)
    {
        return doForDataService(() -> m_veterinarianWithFullNameMapper.toVeterinariansWithFullName(toList(m_veterinarianServiceHelper.findVeterinariansByYearBetween(begin,end), m_veterinarianWithFullNameMapper::toVeterinarianWithFullName)),
                "VeterinarianService.findVeterinariansByYearBetween");
    }

    public VeterinariansDTO findVeterinarianByYear(int year)
    {
        return doForDataService(() -> m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByYear(year).spliterator(), false).map(m_veterinarianMapper::toVeterinarianDTO).toList()),
                "VeterinarianService.findVeterinarianByYear");
    }

    public VeterinariansDTO findVeterinarianByMonth(int month)
    {
        return doForDataService(() -> m_veterinarianMapper.toVeterinariansDTO(toList(m_veterinarianServiceHelper.findVeterinariansByMonth(month), m_veterinarianMapper::toVeterinarianDTO)),
                "VeterinarianService.findVeterinarianByMonth");
       /* return m_veterinarianMapper.toVeterinariansDTO(StreamSupport.stream(m_veterinarianServiceHelper.findVeterinariansByMonth(month).spliterator(), false)
                .map(m_veterinarianMapper::toVeterinarianDTO).toList());*/
    }

    //...
}
