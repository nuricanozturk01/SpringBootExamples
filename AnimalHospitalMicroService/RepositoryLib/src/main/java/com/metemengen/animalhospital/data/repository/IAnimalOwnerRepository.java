package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.Owner;
import com.metemengen.animalhospital.data.entity.OwnerAnimalDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository(BeanName.OWNER_REPOSITORY)
@Lazy
public interface IAnimalOwnerRepository extends CrudRepository<Owner, Integer>
{
    @Query("""
        select new com.metemengen.animalhospital.data.entity.OwnerAnimalDetails(o.name, o.phone, o.address)\
        from Owner o where o.phone=:phone
        """)
        // DTO projection method. Must have constructor. DTO nun kendisini veritabanından çektik
    Iterable<OwnerAnimalDetails> findByPhone(@Param("phone") String phone);
}

