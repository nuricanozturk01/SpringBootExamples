package com.metemengen.animalhospital.data.dal;

import com.karandev.util.data.error.DataUtil;
import com.karandev.util.data.repository.exception.RepositoryException;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.jdbc.Veterinarian;
import com.metemengen.animalhospital.data.entity.jdbc.dto.VeterinarianSave;
import com.metemengen.animalhospital.data.entity.jdbc.dto.VeterinarianWithFullName;
import com.metemengen.animalhospital.data.mapper.jdbc.IVeterinarianMapper;
import com.metemengen.animalhospital.data.repository.jdbc.IVeterinarianRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.karandev.util.data.error.DataUtil.doForRepository;

@Component(BeanName.VETERINARIAN_SERVICE_HELPER)
@Lazy
public class VeterinarianServiceHelper {
    private final IVeterinarianRepository m_veterinarianRepository;

    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianServiceHelper(@Qualifier(BeanName.VETERINARIAN_REPOSITORY) IVeterinarianRepository veterinarianRepository,
                                     @Qualifier(BeanName.VETERINARIAN_MAPPER) IVeterinarianMapper veterinarianMapper)
    {
        m_veterinarianRepository = veterinarianRepository;
        m_veterinarianMapper = veterinarianMapper;
    }

    public long countVeterinarians()
    {
        return doForRepository(m_veterinarianRepository::count,"VeterinarianServiceHelper.countVeterinarians");
    }

    public Optional<Veterinarian> findVeterinarianById(Long diplomaNo)
    {
        return doForRepository(() -> m_veterinarianRepository.findById(diplomaNo), "VeterinarianServiceHelper.findVeterinarianById");
    }

    public Iterable<Veterinarian> findVeterinariansByLastName(String lastName)
    {
        return doForRepository(() -> m_veterinarianRepository.findByLastName(lastName), "VeterinarianServiceHelper.findVeterinariansByLastName");
    }

    public Iterable<Veterinarian> findVeterinariansByMonthAndYear(int month, int year)
    {
        return doForRepository(() -> m_veterinarianRepository.findByMonthAndYear(month, year), "VeterinarianServiceHelper.findVeterinariansByMonthAndYear");
    }

    public Iterable<VeterinarianWithFullName> findVeterinariansByYearBetween(int begin, int end)
    {
        return doForRepository(() -> m_veterinarianRepository.findByYearBetween(begin, end), "VeterinarianServiceHelper.countVeterinarians");
    }

    public VeterinarianSave save(VeterinarianSave veterinarianDTO)
    {
        doForRepository(() ->  m_veterinarianRepository.save(m_veterinarianMapper.toVeterinarian(veterinarianDTO)), "VeterinarianServiceHelper.countVeterinarians");
        return veterinarianDTO;
    }

    public Iterable<Veterinarian> findVeterinariansByYear(int year)
    {
        return doForRepository(() -> m_veterinarianRepository.findByYear(year), "VeterinarianServiceHelper.countVeterinarians");
    }
    public Iterable<Veterinarian> findVeterinariansByMonth(int month)
    {
        return doForRepository(() -> m_veterinarianRepository.findByMonth(month),"VeterinarianServiceHelper.countVeterinarians" );
    }

    public Iterable<Veterinarian> findAllVeterinarians()
    {
        return doForRepository(m_veterinarianRepository::findAll,"VeterinarianServiceHelper.findAllVeterinarians" );
    }

    public Iterable<VeterinarianWithFullName> findAllVeterinariansWithFullName() {
        return doForRepository(m_veterinarianRepository::findAllWithFullName, "VeterinarianServiceHelper.findAllVeterinariansWithFullName");
    }

}
