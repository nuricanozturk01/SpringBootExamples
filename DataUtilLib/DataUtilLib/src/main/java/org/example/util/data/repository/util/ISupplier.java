package org.example.util.data.repository.util;

@FunctionalInterface
public interface ISupplier <R>
{
    R get();
}
