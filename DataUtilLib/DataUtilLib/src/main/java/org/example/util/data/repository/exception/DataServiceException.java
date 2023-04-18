package org.example.util.data.repository.exception;

import org.example.data.service.RepositoryException;

public class DataServiceException extends RuntimeException {
    public DataServiceException(String msg, RepositoryException ex) {
    }
    public DataServiceException(String msg)
    {
    }

    @Override
    public String getMessage() {
        var cause = getCause();
        return String.format
                ("Message: %s %s", super.getMessage(), cause != null ? ", Cause Message: " + cause.getMessage() : "");
    }
}
