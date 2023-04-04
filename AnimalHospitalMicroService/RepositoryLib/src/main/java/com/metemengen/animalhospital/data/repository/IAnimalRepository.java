package com.metemengen.animalhospital.data.repository;

import com.karandev.util.data.repository.ICrudRepository;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Animal;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@Lazy
public interface IAnimalRepository extends CrudRepository<Animal, Integer>
{
    Iterable<Animal> findByNameContainsAndSterile(@Param("name") String name,@Param("sterile")  boolean sterile);

    Iterable<Animal> findByType(@Param("type") String type);

    @Query(nativeQuery = true, value = "select * from animals where date_part('month', birth_date) = :mon and date_part('year', birth_date) = :year")
    Iterable<Animal> findByMonthAndYear(@Param("mon") int mon, @Param("year") int year);
}
