package org.nuricanozturk.app.service.animalhospital.veterinarian.service;

import org.nuricanozturk.app.service.animalhospital.veterinarian.data.repository.IVeterinarianRepository;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.nuricanozturk.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class VeterinarianService
{
    private final IVeterinarianRepository m_veterinarianRepository;
    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianService(IVeterinarianRepository m_veterinarianRepository, IVeterinarianMapper m_veterinarianMapper)
    {
        this.m_veterinarianRepository = m_veterinarianRepository;
        this.m_veterinarianMapper = m_veterinarianMapper;
    }

    public long getVeterinarianCount()
    {
        return m_veterinarianRepository.count();
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return m_veterinarianRepository.finById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO);
    }

    // changed from Iterable<VeterinarianDTO> for display like array
    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return m_veterinarianMapper.toVeterinariansDTO(StreamSupport
                .stream(m_veterinarianRepository.findByLastName(lastName).spliterator(), false)
                .map(m_veterinarianMapper::toVeterinarianDTO)
                .toList());
    }


}
