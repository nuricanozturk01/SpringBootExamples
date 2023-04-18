package org.example.util.data.repository.util;

import org.example.data.service.RepositoryException;
import org.example.util.data.repository.exception.DataServiceException;

import java.util.function.Consumer;

public final class DataUtil
{
    private DataUtil(){}

    public static <R> R doForRepository(ISupplier<R> supplier, String msg)
    {
        try
        {
            return supplier.get();
        }
        catch (Throwable ex)
        {
            throw new RepositoryException(msg, ex);
        }
    }


    public static <R> R doForRepository(ISupplier<R> supplier, Consumer<Throwable> consumer, String msg)
    {
        try
        {
            return supplier.get();
        }
        catch (Throwable ex)
        {
            consumer.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }

    public static void doForRepository(IRunnable runnable, String msg)
    {
        try
        {
            runnable.run();
        }
        catch (Throwable ex)
        {
            throw new RepositoryException(msg, ex);
        }
    }

    public static void doForRepository(IRunnable runnable, Consumer<Throwable> consumer, String msg)
    {
        try
        {
            runnable.run();
        }
        catch (Throwable ex)
        {
            consumer.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }

    public static <R> R doForDataService(ISupplier<R> supplier, String msg)
    {
        try
        {
            return supplier.get();
        }
        catch (RepositoryException ex)
        {
            throw new DataServiceException(msg, ex);
        }
        catch (Throwable ex)
        {
            throw new RepositoryException(msg, ex);
        }
    }

    public static <R> R doForDataService(ISupplier<R> supplier,Consumer<Throwable> consumer, String msg)
    {
        try
        {
            return supplier.get();
        }
        catch (RepositoryException ex)
        {
            consumer.accept(ex);
            throw new DataServiceException(msg, ex);
        }
        catch (Throwable ex)
        {
            consumer.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }

    public static <R> R doForDataService(ISupplier<R> supplier,Consumer<Throwable> consumerRepository, Consumer<Throwable> consumerService, String msg)
    {
        try
        {
            return supplier.get();
        }
        catch (RepositoryException ex)
        {
            consumerRepository.accept(ex);
            throw new DataServiceException(msg, ex);
        }
        catch (Throwable ex)
        {
            consumerService.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }

    public static void doForDataService(IRunnable runnable,Consumer<Throwable> consumerRepository, Consumer<Throwable> consumerService, String msg)
    {
        try
        {
            runnable.run();
        }
        catch (RepositoryException ex)
        {
            consumerRepository.accept(ex);
            throw new DataServiceException(msg, ex);
        }
        catch (Throwable ex)
        {
            consumerService.accept(ex);
            throw new RepositoryException(msg, ex);
        }
    }
}
