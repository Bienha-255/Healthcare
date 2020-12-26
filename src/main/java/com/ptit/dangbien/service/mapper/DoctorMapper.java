package com.ptit.dangbien.service.mapper;


import com.ptit.dangbien.domain.*;
import com.ptit.dangbien.service.dto.DoctorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Doctor} and its DTO {@link DoctorDTO}.
 */
@Mapper(componentModel = "spring", uses = {DiseaseMapper.class})
public interface DoctorMapper extends EntityMapper<DoctorDTO, Doctor> {


    @Mapping(target = "removeDisease", ignore = true)

    default Doctor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(id);
        return doctor;
    }
}
