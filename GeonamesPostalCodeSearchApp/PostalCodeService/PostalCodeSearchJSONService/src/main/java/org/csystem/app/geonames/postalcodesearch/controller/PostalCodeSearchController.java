package org.csystem.app.geonames.postalcodesearch.controller;



import org.csystem.geonames.service.dto.PostalCodesDTO;
import org.csystem.geonames.service.service.PostalCodeAppService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("api/postalCodeJSON")
public class PostalCodeSearchController
{
    private final PostalCodeAppService m_postalCodeAppService;

    public PostalCodeSearchController(PostalCodeAppService postalCodeAppService)
    {
        m_postalCodeAppService = postalCodeAppService;
    }

    @GetMapping("codes")
    public PostalCodesDTO findPostalCodes(@RequestParam("c") String code)
    {
        return m_postalCodeAppService.findPostalCodes(code);
    }


}
