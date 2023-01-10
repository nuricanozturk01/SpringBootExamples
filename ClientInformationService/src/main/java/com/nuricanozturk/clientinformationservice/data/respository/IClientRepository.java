package com.nuricanozturk.clientinformationservice.data.respository;

import com.nuricanozturk.clientinformationservice.data.entity.Client;
import org.example.util.data.repository.ICrudRepository;

public interface IClientRepository extends ICrudRepository<Client, Long>
{
    Iterable<Client> findByHost(String host);
    Iterable<Client> findByDateTimeMonthBetween(int first, int last);
}
