package com.metemengen.animalhospital.data.dal;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dto.VeterinarianSave;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import com.metemengen.animalhospital.data.repository.IVeterinarianRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Component(BeanName.VETERINARIAN_SERVICE_HELPER)
public class VeterinarianServiceHelper
{
    private final IVeterinarianRepository m_veterinarianRepository;

    public VeterinarianServiceHelper(
            @Qualifier(BeanName.VETERINARIAN_REPOSITORY) IVeterinarianRepository m_veterinarianRepository)
    {
        this.m_veterinarianRepository = m_veterinarianRepository;
    }


    public long countVeterinarians()
    {
        return m_veterinarianRepository.count();
    }

    public Optional<Veterinarian> findVeterinariansById(Long diplomaNo)
    {
        return m_veterinarianRepository.finById(diplomaNo);
    }


    public Iterable<Veterinarian> findVeterinariansByLastName(String lastName)
    {
       return m_veterinarianRepository.findByLastName(lastName);
    }

    public Iterable<Veterinarian> findVeterinariansByMonthAndYear(int month, int year)
    {
        return m_veterinarianRepository.findByMonthAndYear(month, year);
    }

    public Iterable<Veterinarian> findVeterinariansByMonth(int month)
    {
        return m_veterinarianRepository.findByMonth(month);
    }

    public Iterable<Veterinarian> findVeterinariansByYear(int year)
    {
        return m_veterinarianRepository.findByYear(year);
    }

    public Iterable<VeterinarianWithoutCitizenId> findVeterinariansByYearBetween(int before, int after)
    {
        return m_veterinarianRepository.findByYearBetween(before, after);
    }
    public Veterinarian save(VeterinarianSave veterinarian)
    {
        return m_veterinarianRepository.save(veterinarian);
    }
}
