package com.metemengen.animalhospital.data.repository.jdbc;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.jdbc.Veterinarian;
import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import com.metemengen.animalhospital.data.entity.jdbc.dto.VeterinarianWithFullName;
import com.metemengen.animalhospital.data.entity.jdbc.dto.VeterinarianWithoutCitizenId;
import com.metemengen.animalhospital.data.mapper.jdbc.IVeterinarianMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

@Repository(BeanName.VETERINARIAN_REPOSITORY)
@Lazy
public class VeterinarianRepository implements IVeterinarianRepository {
    private static final String COUNT_SQL = "select count(*) from veterinarians";
    private static final String FIND_BY_DIPLOMA_NO_SQL = "select * from veterinarians where diploma_no=:diplomaNo";
    private static final String FIND_BY_LAST_NAME_SQL = "select * from veterinarians where last_name=lower(:lastName)";
    private static final String FIND_BY_MONTH_AND_YEAR_SQL = """
            select * from veterinarians where date_part('month', register_date) = :month\s
            and date_part('year', register_date) = :year""";

    private static final String FIND_ALL_VETERINARIANS = "select * from veterinarians order by diploma_no";

    private static final String FIND_BY_YEAR_BETWEEN_SQL = """
           select * from find_veterinarian_by_year_between(:begin, :end)
            """;
    private static final String FIND_BY_MONTH_SQL = """
                select diploma_no, first_name, middle_name, last_name, birth_date, register_date\s
                from veterinarians where date_part('month', register_date) = :month
                """;

    private static final String FIND_BY_MONTH_SQL_2 = """
                select * from veterinarians where date_part('month', register_date) = :month
                """;
    private static final String FIND_BY_YEAR_SQL = "select * from veterinarians where date_part('year', register_date) = :year";


    private static final String SAVE_SQL = """
            insert into veterinarians (diploma_no, citizen_id, first_name, middle_name, last_name, birth_date, register_date)
            values (:diplomaNo, :citizenId, :firstName, :middleName, :lastName, :birthDate, :registerDate)""";

    private static final String SAVE_VETERINARIAN_ANIMAL_SQL = "call sp_insert_veterinarian_animal(:animalId, :diplomaNo, :price)";
    private static final String FIND_ALL_WITH_FULL_NAME = "select * from find_all_veterinarians_with_full_name()";
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    private final IVeterinarianMapper m_veterinarianMapper;

    private static Veterinarian getVeterinarian(ResultSet rs) throws SQLException
    {
        var diplomaNo = rs.getLong(1);
        var citizenId = rs.getString(2);
        var firstName = rs.getString(3);
        var middleNameOpt = Optional.ofNullable(rs.getString(4));
        var lastName = rs.getString(5);
        var birthDate = rs.getDate(6).toLocalDate();
        var registerDate = rs.getDate(7).toLocalDate();

        return new Veterinarian(diplomaNo, citizenId, firstName, middleNameOpt, lastName, birthDate, registerDate);
    }

    private static VeterinarianWithFullName getVeterinarianWithFullName(ResultSet rs) throws SQLException
    {
        var diplomaNo = rs.getLong(1);
        var fullName = rs.getString(2);
        var birthDate = rs.getDate(3).toLocalDate();
        var registerDate = rs.getDate(4).toLocalDate();

        return new VeterinarianWithFullName(diplomaNo, fullName, birthDate, registerDate);
    }

    private static VeterinarianWithoutCitizenId getVeterinarianWithoutCitizenId(ResultSet rs) throws SQLException
    {
        var diplomaNo = rs.getLong("diploma_no");
        var firstName = rs.getString("first_name");
        var middleNameOpt = Optional.ofNullable(rs.getString("middle_name"));
        var lastName = rs.getString("last_name");
        var birthDate = rs.getDate("birth_date").toLocalDate();
        var registerDate = rs.getDate("register_date").toLocalDate();

        return new VeterinarianWithoutCitizenId(diplomaNo, firstName, middleNameOpt, lastName, birthDate, registerDate);
    }

    private static void fillVeterinarians(ResultSet rs, List<Veterinarian> veterinarians) throws SQLException
    {
        do
            veterinarians.add(getVeterinarian(rs));
        while (rs.next());
    }

    private static void fillVeterinariansWithoutCitizenId(ResultSet rs, List<VeterinarianWithoutCitizenId> veterinarians) throws SQLException
    {
        do
            veterinarians.add(getVeterinarianWithoutCitizenId(rs));
        while (rs.next());
    }

    private static void fillVeterinariansWithFullName(ResultSet rs, List<VeterinarianWithFullName> veterinarians) throws SQLException
    {
        do
            veterinarians.add(getVeterinarianWithFullName(rs));
        while (rs.next());
    }

    public VeterinarianRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                                  @Qualifier(BeanName.VETERINARIAN_MAPPER) IVeterinarianMapper veterinarianMapper)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_veterinarianMapper = veterinarianMapper;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Optional<Veterinarian> findById(Long diplomaNo)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("diplomaNo", diplomaNo);

        m_namedParameterJdbcTemplate.query(FIND_BY_DIPLOMA_NO_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians.isEmpty() ? Optional.empty() : Optional.of(veterinarians.get(0));
    }

    @Override
    public Iterable<Veterinarian> findByLastName(String lastName)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplate.query(FIND_BY_LAST_NAME_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByMonthAndYear(int month, int year)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("month", month);
        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH_AND_YEAR_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<VeterinarianWithFullName> findByYearBetween(int begin, int end)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<VeterinarianWithFullName>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);

        m_namedParameterJdbcTemplate.query(FIND_BY_YEAR_BETWEEN_SQL, paramMap, (ResultSet rs) -> fillVeterinariansWithFullName(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("month", month);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH_SQL_2, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByYear(int year)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_YEAR_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public boolean saveVeterinarianAnimal(VeterinarianAnimalSave veterinarianAnimalSave)
    {
        boolean result = false;

        try {
            var paramSource = new BeanPropertySqlParameterSource(veterinarianAnimalSave);

            //paramSource.registerSqlType("dateTime", Types.DATE);

            m_namedParameterJdbcTemplate.update(SAVE_VETERINARIAN_ANIMAL_SQL, paramSource);

            result = true;
        }
        catch (DataAccessException ignore) {
            ignore.printStackTrace();
        }

        return result;
    }

    @Override
    public Iterable<VeterinarianWithFullName> findAllWithFullName() {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<VeterinarianWithFullName>();

        m_namedParameterJdbcTemplate.query(FIND_ALL_WITH_FULL_NAME, paramMap, (ResultSet rs) -> fillVeterinariansWithFullName(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public <S extends Veterinarian> S save(S veterinarian)
    {
        var paramSource = new BeanPropertySqlParameterSource(veterinarian);

        paramSource.registerSqlType("birthDate", Types.DATE);
        paramSource.registerSqlType("registerDate", Types.DATE);
        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource);

        return veterinarian;
    }

    @Override
    public Iterable<Veterinarian> findAll()
    {
        var veterinarians = new ArrayList<Veterinarian>();

        m_namedParameterJdbcTemplate.query(FIND_ALL_VETERINARIANS, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    ////////////////////////////////////////////////////////////////////


    @Override
    public void delete(Veterinarian entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Veterinarian> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public Iterable<Veterinarian> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Veterinarian> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
