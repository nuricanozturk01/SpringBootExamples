package com.metemengen.animalhospital.data.repository;


import com.metemengen.animalhospital.data.entity.Veterinarian;
import org.example.util.data.repository.ICrudRepository;


public interface IVeterinarianRepository extends ICrudRepository<Veterinarian, Long>
{
    Iterable<Veterinarian> findByLastName(String lastName);
    Iterable<Veterinarian> findByMonthAndYear(int month, int year);
}
