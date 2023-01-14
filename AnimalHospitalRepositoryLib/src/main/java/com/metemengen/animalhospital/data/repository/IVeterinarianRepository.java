package com.metemengen.animalhospital.data.repository;


import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import org.example.util.data.repository.ICrudRepository;


public interface IVeterinarianRepository extends ICrudRepository<Veterinarian, Long>
{
    Iterable<Veterinarian> findByLastName(String lastName);
    Iterable<Veterinarian> findByMonthAndYear(int month, int year);
    Iterable<Veterinarian> findByMonth(int month);
    Iterable<Veterinarian> findByYear(int year);
    Iterable<VeterinarianWithoutCitizenId> findByYearBetween(int beforeYear, int afterYear);

}
