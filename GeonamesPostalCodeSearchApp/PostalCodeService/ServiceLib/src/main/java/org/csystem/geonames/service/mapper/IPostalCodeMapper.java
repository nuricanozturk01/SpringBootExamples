package org.csystem.geonames.service.mapper;

import org.csystem.geonames.service.api.entity.PostalCode;
import org.csystem.geonames.service.api.entity.PostalCodes;
import org.csystem.geonames.service.dto.PostalCodeDTO;
import org.csystem.geonames.service.dto.PostalCodesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(implementationName = "PostalCodeMapperImpl", componentModel = "spring")
public interface IPostalCodeMapper
{
    @Mappings(
            {
                @Mapping(source = "iSO31662", target = "plate"),
                @Mapping(source = "lng", target = "longitude"),
                @Mapping(source = "lat", target = "latitude"),
            }
    )
    PostalCodeDTO toPostalCodeDTO(PostalCode postalCode);
    PostalCodesDTO toPostalCodesDTO(PostalCodes postalCodes);

    PostalCodeDTO toPostalCodeDTO(org.csystem.app.entity.PostalCode postalCode);
    default PostalCodesDTO toPostalCodesDTO(List<PostalCodeDTO> postalCodes)
    {
        var dto = new PostalCodesDTO();

        dto.postalCodes = postalCodes;

        return dto;
    }

    org.csystem.app.entity.PostalCode toPostalCode(PostalCodeDTO postalCodeDTO);




}
