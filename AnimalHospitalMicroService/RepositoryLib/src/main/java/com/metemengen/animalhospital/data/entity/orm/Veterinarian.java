package com.metemengen.animalhospital.data.entity.orm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "veterinarians")
public class Veterinarian
{
    @Id
    @Column(name = "diploma_no")
    public long diplomaNo;
    @Column(name = "citizen_id", unique = true, nullable = false)
    public String citizenId;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "middle_name", nullable = false)
    public String middleName;
    @Column(name = "last_name", nullable = false)
    public String lastName;
    @Column(name = "birth_date", nullable = false)
    public LocalDate birthDate;
    @Column(name = "register_date", nullable = false)
    public LocalDate registerDate;

    // reference column name: Birleştiren tabloda olan ismi
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "veterinarians_to_animals", joinColumns =
        @JoinColumn(name = "diploma_no", referencedColumnName = "diploma_no", nullable = false), // ilki bu taraftaki name, diğeri diğer taraftaki eşleştiği col
        inverseJoinColumns = @JoinColumn(name = "animal_id", referencedColumnName = "animal_id")) // animal tarafında ne ile bağlanıyor?
    // name = hangi tablo ile birleştirdik
    // Join column ile de hangi columnlar ile birleşeceğimizi söylüyoruz
    public Set<Animal> animals;
}
