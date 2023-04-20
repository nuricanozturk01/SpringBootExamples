package org.csystem.app.geonames.postalcodesearch.mapper;

import org.csystem.app.geonames.postalcodesearch.api.geonames.PostalCode;
import org.csystem.app.geonames.postalcodesearch.api.geonames.PostalCodes;
import org.csystem.app.geonames.postalcodesearch.dto.PostalCodeDTO;
import org.csystem.app.geonames.postalcodesearch.dto.PostalCodesDTO;
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

    default PostalCodesDTO toPostalCodesDTO(List<PostalCodeDTO> postalCodes)
    {
        var dto = new PostalCodesDTO();

        dto.postalCodes = postalCodes;

        return dto;
    }


}
