package com.metemengen.animalhospital.data.repository;



import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import com.metemengen.animalhospital.data.mapper.IVeterinarianMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.metemengen.animalhospital.data.BeanName.VETERINARIAN_REPOSITORY;

@SuppressWarnings("all")
@Repository(VETERINARIAN_REPOSITORY) // aynı zamanda bir component
public class VeterinarianRepository implements IVeterinarianRepository
{
    /*
        Sorgu sonucunda tıpkı ResultSet(iterator gibi çalışır fakat değil) isimli aynı iterator gibi çalışan sınıf elde ediyoruz
        Queryler callbak alıyor ve data oldukça çağırıyor fakat boş gelirse herhangi bir veri gelmez fakat next yapmış olur
        bu yüzden ilk datayı atlamış olur.
        do-while ile bu yüzden çalışıyoruz.(en az bir kez çalışması garanti altında)

     */
    private static final String COUNT_SQL = "select count(*) from veterinarians";
    private static final String FIND_BY_DIPLOMA_NO_SQL = "select * from veterinarians where diploma_no=:diplomaNo";
    private static final String FIND_BY_LAST_NAME_SQL =
            "select * from veterinarians where last_name=:lastName";
    private static final String FIND_BY_MONTH_AND_YEAR_SQL =
            """
               select * from veterinarians where date_part('month',register_date) = :month\s 
               and\s 
               date_part('year', register_date)= :year
            """;
    private final String SAVE_SQL = """
            insert into veterinarians(diploma_no, citizen_id, first_name, middle_name, last_name, birth_date, register_date)
            values(:diplomaNo, :citizenId, :firstName, :middleName, :lastName, :birthDate,:registerDate)
            """;
    // ParameterSource iface

    private final String FIND_BY_MONTH = "select * from veterinarians where date_part('month',register_date) = :month";
    private final String FIND_BY_YEAR = "select * from veterinarians where date_part('year',register_date) = :year";
    private final String FIND_BY_YEAR_BETWEEN = """
            
            select * from veterinarians where date_part('year', register_date) between :before and :after
            """;
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplatee; // Spring'in jdbc dependency
    // Birtakım sınıfları otomatik enjekte edebiliriz

    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplatee,
                                  @Qualifier(BeanName.VETERINARIAN_MAPPER) IVeterinarianMapper veterinarianMapper)
    {
        m_namedParameterJdbcTemplatee = namedParameterJdbcTemplatee;
        m_veterinarianMapper = veterinarianMapper;
    }

    // RowMapper, ResultSetExtractor, RowCallBack functional interface
    // resultset container sınıf.
    @Override
    public long count()
    {
        var count = new ArrayList<Long>();

        // rsnin türü RowCallback tir.

        m_namedParameterJdbcTemplatee.query(COUNT_SQL, rs -> {count.add(rs.getLong(1));});

        return count.get(0);
    }

    private static Veterinarian getVeterinarian(ResultSet rs) throws SQLException
    {
        // NUllable ve null ise default değere geri döner getXXX metodları

        var dip = rs.getLong(1);
        var citId = rs.getString(2);
        var firstName = rs.getString(3);
        var middleNameOpt = Optional.ofNullable(rs.getString(4));
        var lastName = rs.getString(5);
        var birthDate = rs.getDate(6).toLocalDate(); // Date'i LocalDate'i çevirir
        var regDate = rs.getDate(7).toLocalDate();
        return new Veterinarian(dip, citId, firstName, middleNameOpt, lastName, birthDate, regDate);
    }
    private static void fillVeterinarian(ResultSet rs, List<Veterinarian> vets) throws SQLException
    {
        do
            vets.add(getVeterinarian(rs));
        while (rs.next());
    }



    private static VeterinarianWithoutCitizenId getVeterinarianWithouCitizenId(ResultSet rs) throws SQLException
    {
        // NUllable ve null ise default değere geri döner getXXX metodları

        var dip = rs.getLong(1);
        var firstName = rs.getString(3);
        var middleNameOpt = Optional.ofNullable(rs.getString(4));
        var lastName = rs.getString(5);
        var birthDate = rs.getDate(6).toLocalDate(); // Date'i LocalDate'i çevirir
        var regDate = rs.getDate(7).toLocalDate();
        return new VeterinarianWithoutCitizenId(dip, firstName, middleNameOpt, lastName, birthDate, regDate);
    }
    private static void fillVeterinarianWithoutCitizenId(ResultSet rs, List<VeterinarianWithoutCitizenId> vets) throws SQLException
    {
        do
            vets.add(getVeterinarianWithouCitizenId(rs));
        while (rs.next());
    }


    @Override
    public Optional<Veterinarian> finById(Long diplomaNo)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("diplomaNo", diplomaNo);

        m_namedParameterJdbcTemplatee.query(FIND_BY_DIPLOMA_NO_SQL, paramMap, (ResultSet rs) -> fillVeterinarian(rs, veterinarians));

        return veterinarians.isEmpty() ? Optional.empty() : Optional.of(veterinarians.get(0));
    }

    @Override
    public Iterable<Veterinarian> findByLastName(String lastName)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplatee.query(FIND_BY_LAST_NAME_SQL, paramMap, (ResultSet rs) -> fillVeterinarian(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByMonthAndYear(int month, int year)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("month", month);
        paramMap.put("year", year);

        m_namedParameterJdbcTemplatee.query(FIND_BY_MONTH_AND_YEAR_SQL, paramMap,
                (ResultSet rs) -> fillVeterinarian(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("month", month);

        m_namedParameterJdbcTemplatee.query(FIND_BY_MONTH, paramMap,
                (ResultSet rs) -> fillVeterinarian(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByYear(int year)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("year", year);

        m_namedParameterJdbcTemplatee.query(FIND_BY_YEAR, paramMap,
                (ResultSet rs) -> fillVeterinarian(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<VeterinarianWithoutCitizenId> findByYearBetween(int beforeYear, int afterYear)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<VeterinarianWithoutCitizenId>();

        paramMap.put("before", beforeYear);
        paramMap.put("after", afterYear);

        m_namedParameterJdbcTemplatee.query(FIND_BY_YEAR_BETWEEN, paramMap,
                (ResultSet rs) -> fillVeterinarianWithoutCitizenId(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public <S extends Veterinarian> S save(S vet)
    {
        var paramSource = new BeanPropertySqlParameterSource(vet);

        //isimler veterinarianEntityDTO ile aynı olacak
        paramSource.registerSqlType("birthDate", Types.DATE);
        paramSource.registerSqlType("registerDate", Types.DATE);

        m_namedParameterJdbcTemplatee.update(SAVE_SQL, paramSource);

        return vet;
    }

    // Not Implemented


    @Override
    public void delete(Veterinarian veterinarian)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public void deleteAll(Iterable<? extends Veterinarian> iterable)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public void deleteById(Iterable<? extends Long> iterable)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public boolean existById(Long aLong)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public Iterable<Veterinarian> findAll()
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public Iterable<Veterinarian> findAllById(Iterable<Long> iterable)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public Iterable<Veterinarian> findBy(Predicate<? extends Veterinarian> predicate)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
    @Override
    public <S extends Veterinarian> Iterable<S> saveAll(Iterable<S> iterable)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
}
