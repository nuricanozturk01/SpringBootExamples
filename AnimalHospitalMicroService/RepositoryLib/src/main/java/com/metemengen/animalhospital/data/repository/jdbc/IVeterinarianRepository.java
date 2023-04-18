package com.metemengen.animalhospital.data.repository.jdbc;

import com.karandev.util.data.repository.ICrudRepository;
import com.metemengen.animalhospital.data.entity.jdbc.Veterinarian;
import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import com.metemengen.animalhospital.data.entity.jdbc.dto.VeterinarianWithFullName;


public interface IVeterinarianRepository extends ICrudRepository<Veterinarian, Long>
{
    Iterable<Veterinarian> findByLastName(String lastName);
    Iterable<Veterinarian> findByMonthAndYear(int month, int year);
    Iterable<VeterinarianWithFullName> findByYearBetween(int begin, int end);
    Iterable<Veterinarian> findByMonth(int month);
    Iterable<Veterinarian> findByYear(int year);
    boolean saveVeterinarianAnimal(VeterinarianAnimalSave veterinarianAnimalSave);
}
