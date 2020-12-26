package com.ptit.dangbien.service.mapper;


import com.ptit.dangbien.domain.*;
import com.ptit.dangbien.service.dto.DiseaseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Disease} and its DTO {@link DiseaseDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DiseaseMapper extends EntityMapper<DiseaseDTO, Disease> {


    @Mapping(target = "doctors", ignore = true)
    @Mapping(target = "removeDoctor", ignore = true)
    Disease toEntity(DiseaseDTO diseaseDTO);

    default Disease fromId(Long id) {
        if (id == null) {
            return null;
        }
        Disease disease = new Disease();
        disease.setId(id);
        return disease;
    }
}
