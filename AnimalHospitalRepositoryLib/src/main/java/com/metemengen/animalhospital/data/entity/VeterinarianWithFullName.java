package com.metemengen.animalhospital.data.entity;



import java.time.LocalDate;

public class VeterinarianWithFullName
{
    public long diplomaNo;
    public String fullName;
    public LocalDate birthDate;
    public LocalDate registerDate;


    public VeterinarianWithFullName(long diplomaNo, String fullName, LocalDate birthDate, LocalDate registerDate)
    {
        this.diplomaNo = diplomaNo;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }
}
