package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.Owner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository(BeanName.OWNER_REPOSITORY)
@Lazy
public interface IAnimalOwnerRepository extends CrudRepository<Owner, Integer>
{
    Iterable<Owner> findByPhone(@Param("phone") String phone);
}

