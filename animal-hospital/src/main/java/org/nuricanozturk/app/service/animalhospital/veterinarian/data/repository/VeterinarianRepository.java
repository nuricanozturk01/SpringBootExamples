package org.nuricanozturk.app.service.animalhospital.veterinarian.data.repository;

import org.nuricanozturk.app.service.animalhospital.veterinarian.data.entity.Veterinarian;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;

@Repository // aynı zamanda bir component
public class VeterinarianRepository implements IVeterinarianRepository
{
    private static final String COUNT_SQL = "select count(*) from veterinarians";
    private static final String FIND_BY_DIPLOMA_NO_SQL = "select * from veterinarians where diploma_no=:diplomaNo";
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplatee; // Spring'in jdbc dependency
    // Birtakım sınıfları otomatik enjekte edebiliriz
    public VeterinarianRepository(NamedParameterJdbcTemplate m_namedParameterJdbcTemplatee)
    {
        this.m_namedParameterJdbcTemplatee = m_namedParameterJdbcTemplatee;
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
        var dip = rs.getLong(1);
        var citId = rs.getString(2);
        var firstName = rs.getString(3);
        var middleNameOpt = Optional.ofNullable(rs.getString(4));
        var lastName = rs.getString(5);
        var birthDate = rs.getDate(6).toLocalDate();
        var regDate = rs.getDate(7).toLocalDate();
        return new Veterinarian(dip, citId, firstName, middleNameOpt, lastName, birthDate, regDate);
    }
    private static void fillVeterinarian(ResultSet rs, List<Veterinarian> vets) throws SQLException
    {
        do
            vets.add(getVeterinarian(rs));
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
    public <S extends Veterinarian> S save(S s)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }

    @Override
    public <S extends Veterinarian> Iterable<S> saveAll(Iterable<S> iterable)
    {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
}
