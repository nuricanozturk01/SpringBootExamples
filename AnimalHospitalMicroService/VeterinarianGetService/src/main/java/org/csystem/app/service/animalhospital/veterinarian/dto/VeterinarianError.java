package org.csystem.app.service.animalhospital.veterinarian.dto;

import org.springframework.http.HttpStatus;

public class VeterinarianError
{
    public String message;
    public int status;

    public VeterinarianError(String msg, int status) {
        message = msg;
        this.status = status;
    }
}
