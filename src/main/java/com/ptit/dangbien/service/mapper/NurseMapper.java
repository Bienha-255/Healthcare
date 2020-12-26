package com.ptit.dangbien.service.mapper;


import com.ptit.dangbien.domain.*;
import com.ptit.dangbien.service.dto.NurseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Nurse} and its DTO {@link NurseDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NurseMapper extends EntityMapper<NurseDTO, Nurse> {



    default Nurse fromId(Long id) {
        if (id == null) {
            return null;
        }
        Nurse nurse = new Nurse();
        nurse.setId(id);
        return nurse;
    }
}
