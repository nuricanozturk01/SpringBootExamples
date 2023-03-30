package com.metemengen.animalhospital.data.repository;

import com.karandev.util.data.repository.ICrudRepository;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;


public interface IAnimalRepository extends ICrudRepository<AnimalOwnerDetails, Long>
{
    Iterable<AnimalOwnerDetails> findByDiplomaNo(long diplomaNo);
}
