package com.ptit.dangbien.service.mapper;


import com.ptit.dangbien.domain.*;
import com.ptit.dangbien.service.dto.MedicineDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Medicine} and its DTO {@link MedicineDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MedicineMapper extends EntityMapper<MedicineDTO, Medicine> {



    default Medicine fromId(Long id) {
        if (id == null) {
            return null;
        }
        Medicine medicine = new Medicine();
        medicine.setId(id);
        return medicine;
    }
}
