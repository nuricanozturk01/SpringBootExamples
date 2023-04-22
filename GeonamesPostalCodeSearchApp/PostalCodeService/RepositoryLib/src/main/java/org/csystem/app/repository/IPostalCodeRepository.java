package org.csystem.app.repository;


import org.csystem.app.entity.PostalCode;
import org.csystem.app.entity.PostalCodeInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostalCodeRepository extends CrudRepository<PostalCode, Long>
{
    @Query("select pc from PostalCode pc join pc.postalCodeInfo where pc.postalCodeInfo.code = :code")
    Iterable<PostalCode> findByCode(@Param("code") String code);
}
