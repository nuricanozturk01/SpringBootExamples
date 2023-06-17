package nuricanozturk.dev.app.web.veterinarian.service;

import nuricanozturk.dev.app.web.veterinarian.model.VeterinarianModel;
import nuricanozturk.dev.app.web.veterinarian.model.VeterinarianSaveModel;
import nuricanozturk.dev.app.web.veterinarian.model.VeterinariansModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VeterinarianService {

    private final RestTemplate m_restTemplate;

    @Value("${service.veterinarian.get.url}")
    private String m_getServiceUrl;
    @Value("${service.veterinarian.get.all.url}")
    private String m_getAllServiceUrl;


    @Value("${service.veterinarian.post.url}")
    private String m_postServiceUrl;


    public VeterinarianService(RestTemplate m_restTemplate) {
        this.m_restTemplate = m_restTemplate;
    }

    public VeterinariansModel findAllVeterinariansWithFullName()
    {
        var obj =  m_restTemplate.getForObject(m_getServiceUrl, VeterinariansModel.class);

        return obj;
    }

    public VeterinarianSaveModel saveVeterinarian(VeterinarianSaveModel veterinarianSaveModel)
    {
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        return m_restTemplate.postForObject(m_postServiceUrl, new HttpEntity<>(veterinarianSaveModel, headers), VeterinarianSaveModel.class);
    }

    public VeterinariansModel findAll() {
        return m_restTemplate.getForObject(m_getAllServiceUrl, VeterinariansModel.class);
    }
}

