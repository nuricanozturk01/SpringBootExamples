package org.csystem.app.repository;

import org.csystem.app.entity.PostalCodeQueryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostalCodeQueryInfoRepository extends CrudRepository<PostalCodeQueryInfo, Long>
{
}
