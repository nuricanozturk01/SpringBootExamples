package com.nuricanozturk.clientinformationservice.data.respository;

import com.nuricanozturk.clientinformationservice.data.entity.Client;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Predicate;

@Component
public class ClientRepository implements IClientRepository
{
    @Override
    public Iterable<Client> findByHost(String host) {
        return null;
    }

    @Override
    public Iterable<Client> findByDateTimeMonthBetween(int first, int last) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(Iterable<? extends Client> iterable) {

    }

    @Override
    public void deleteById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Iterable<Client> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public Iterable<Client> findBy(Predicate<? extends Client> predicate) {
        return null;
    }

    @Override
    public Optional<Client> finById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> S save(S s) {
        return null;
    }

    @Override
    public <S extends Client> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }
}
