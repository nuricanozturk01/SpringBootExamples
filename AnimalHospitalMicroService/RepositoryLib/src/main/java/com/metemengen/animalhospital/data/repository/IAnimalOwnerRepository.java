package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.springframework.data.repository.CrudRepository;

public interface IAnimalOwnerRepository extends CrudRepository<AnimalOwnerDetails, Long>
{

}

