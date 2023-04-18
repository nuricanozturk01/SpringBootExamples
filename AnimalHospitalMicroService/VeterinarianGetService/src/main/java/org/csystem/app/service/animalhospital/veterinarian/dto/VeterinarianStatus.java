package org.csystem.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VeterinarianStatus
{

    @JsonProperty("status")
    public VeterinarianStatusInfo status;

    public VeterinarianStatus(String msg, long diplomaNo)
    {
        status = new VeterinarianStatusInfo();
        status.diplomaNo = diplomaNo;
        status.message = msg;
    }
}
