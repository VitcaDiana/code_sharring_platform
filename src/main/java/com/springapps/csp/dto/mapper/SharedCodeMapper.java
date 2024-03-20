package com.springapps.csp.dto.mapper;

import com.springapps.csp.dto.SharedCodeRequestDTO;
import com.springapps.csp.model.SharedCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",imports = LocalDateTime.class)
public abstract class SharedCodeMapper {
        @Mapping(target = "id", ignore=true)
        @Mapping(target = "createdDate", source = "sharedCodeRequestDTO", qualifiedByName = "setCreatedDate")
        public abstract SharedCode mapSharedCodeDTOtoSharedCode(SharedCodeRequestDTO sharedCodeRequestDTO);

        @Named("setCreatedDate")
        LocalDateTime setCreatedDate(SharedCodeRequestDTO sharedCodeRequestDTO) {
                return LocalDateTime.now();
        }
}
