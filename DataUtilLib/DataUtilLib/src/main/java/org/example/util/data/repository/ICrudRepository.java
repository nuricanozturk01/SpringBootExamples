package org.example.util.data.repository;

import java.util.Optional;
import java.util.function.Predicate;

public interface ICrudRepository <T, Id>
{
    long count();
    void delete(T entity);
    void deleteAll();
    void deleteAll(Iterable<? extends  T> entities);
    void deleteById(Iterable<? extends Id> ids);
    void deleteById(Id id);
    boolean existById(Id id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<Id> id);
    Iterable<T> findBy(Predicate<? extends  T> pred);
    Optional<T> finById(Id id);
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
}
