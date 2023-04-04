package com.metemengen.animalhospital.data.repository;

import com.karandev.util.data.repository.ICrudRepository;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithFullName;
import org.springframework.context.annotation.Lazy;



public interface IVeterinarianRepository extends ICrudRepository<Veterinarian, Long>
{
    Iterable<Veterinarian> findByLastName(String lastName);
    Iterable<Veterinarian> findByMonthAndYear(int month, int year);
    Iterable<VeterinarianWithFullName> findByYearBetween(int begin, int end);
    Iterable<Veterinarian> findByMonth(int month);
    Iterable<Veterinarian> findByYear(int year);
}
