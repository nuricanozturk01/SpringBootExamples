package org.example.data.service;

public class RepositoryException extends RuntimeException
{
    public RepositoryException(String message)
    {
        super(message, null);
    }

    public RepositoryException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        var cause = getCause();
        return String.format
                ("Message: %s %s", super.getMessage(), cause != null ? ", Cause Message: " + cause.getMessage() : "");
    }
}
