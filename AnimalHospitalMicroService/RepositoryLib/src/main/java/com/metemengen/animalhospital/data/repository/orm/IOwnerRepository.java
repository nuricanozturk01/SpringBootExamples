package com.metemengen.animalhospital.data.repository.orm;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.orm.Owner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository(BeanName.OWNER_REPOSITORY)
@Lazy
public interface IOwnerRepository extends CrudRepository<Owner, Integer>
{
        // DTO projection method. Must have constructor. DTO nun kendisini veritabanından çektik
    Iterable<Owner> findByPhone(@Param("phone") String phone);
}

