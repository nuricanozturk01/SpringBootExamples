package org.csystem.app.dal;

import org.csystem.app.entity.PostalCode;
import org.csystem.app.entity.PostalCodeInfo;
import org.csystem.app.entity.PostalCodeQueryInfo;
import org.csystem.app.repository.IPostalCodeInfoRepository;
import org.csystem.app.repository.IPostalCodeQueryInfoRepository;
import org.csystem.app.repository.IPostalCodeRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostalCodeAppServiceHelper
{
    private final IPostalCodeRepository m_postalCodeRepository;
    private final IPostalCodeInfoRepository m_postalCodeInfoRepository;
    private final IPostalCodeQueryInfoRepository m_postalCodeQueryInfoRepository;

    public PostalCodeAppServiceHelper(IPostalCodeRepository postalCodeRepository, IPostalCodeInfoRepository postalCodeInfoRepository, IPostalCodeQueryInfoRepository postalCodeQueryInfoRepository)
    {
        m_postalCodeRepository = postalCodeRepository;
        m_postalCodeInfoRepository = postalCodeInfoRepository;
        m_postalCodeQueryInfoRepository = postalCodeQueryInfoRepository;
    }

    public boolean existPostalCodeInfoByCode(String code)
    {
        return m_postalCodeInfoRepository.existsById(code);
    }

    public Iterable<PostalCode> findPostalCodesByCode(String code)
    {
        return m_postalCodeRepository.findByCode(code);
    }

    public Optional<PostalCodeInfo> findPostalCodeInfoByCode(String code)
    {
        return m_postalCodeInfoRepository.findById(code);
    }
    public int updatePostalCodeInfoQueryCount(String code)
    {
        return m_postalCodeInfoRepository.updateQueryCount(code);
    }

    public PostalCodeInfo savePostalCodeInfo(PostalCodeInfo postalCodeInfo)
    {
        return m_postalCodeInfoRepository.save(postalCodeInfo);
    }

    public PostalCodeQueryInfo savePostalCodeQueryInfo(PostalCodeQueryInfo postalCodeQueryInfo)
    {
        return m_postalCodeQueryInfoRepository.save(postalCodeQueryInfo);
    }
}
