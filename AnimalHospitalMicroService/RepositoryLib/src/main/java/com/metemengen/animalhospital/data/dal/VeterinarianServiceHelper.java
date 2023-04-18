package com.metemengen.animalhospital.data.dal;

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
        try {
            return m_veterinarianRepository.count();
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.countVeterinarians", ignored);
        }

    }

    public Optional<Veterinarian> findVeterinarianById(Long diplomaNo)
    {
        try {
            return m_veterinarianRepository.findById(diplomaNo);
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.findVeterinarianById", ignored);
        }

    }

    public Iterable<Veterinarian> findVeterinariansByLastName(String lastName)
    {
        try {
            return m_veterinarianRepository.findByLastName(lastName);
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.findVeterinariansByLastName", ignored);
        }
    }

    public Iterable<Veterinarian> findVeterinariansByMonthAndYear(int month, int year)
    {
        try {
            return m_veterinarianRepository.findByMonthAndYear(month, year);
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.findVeterinariansByMonthAndYear", ignored);
        }

    }

    public Iterable<VeterinarianWithFullName> findVeterinariansByYearBetween(int begin, int end)
    {
        try {
            return m_veterinarianRepository.findByYearBetween(begin, end);
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.countVeterinarians", ignored);
        }

    }

    public VeterinarianSave save(VeterinarianSave veterinarianDTO)
    {
        try {
            m_veterinarianRepository.save(m_veterinarianMapper.toVeterinarian(veterinarianDTO));
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.countVeterinarians", ignored);
        }


        return veterinarianDTO;
    }


    public Iterable<Veterinarian> findVeterinariansByYear(int year)
    {
        try {
            return m_veterinarianRepository.findByYear(year);
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.countVeterinarians", ignored);
        }
    }

    public Iterable<Veterinarian> findVeterinariansByMonth(int month)
    {
        try {
            return m_veterinarianRepository.findByMonth(month);
        }
        catch (Throwable ignored)
        {
            throw new RepositoryException("VeterinarianServiceHelper.countVeterinarians", ignored);
        }
    }
}
