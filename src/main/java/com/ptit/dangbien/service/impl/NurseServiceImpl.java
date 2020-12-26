package com.ptit.dangbien.service.impl;

import com.ptit.dangbien.service.NurseService;
import com.ptit.dangbien.domain.Nurse;
import com.ptit.dangbien.repository.NurseRepository;
import com.ptit.dangbien.service.dto.NurseDTO;
import com.ptit.dangbien.service.mapper.NurseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Nurse}.
 */
@Service
@Transactional
public class NurseServiceImpl implements NurseService {

    private final Logger log = LoggerFactory.getLogger(NurseServiceImpl.class);

    private final NurseRepository nurseRepository;

    private final NurseMapper nurseMapper;

    public NurseServiceImpl(NurseRepository nurseRepository, NurseMapper nurseMapper) {
        this.nurseRepository = nurseRepository;
        this.nurseMapper = nurseMapper;
    }

    @Override
    public NurseDTO save(NurseDTO nurseDTO) {
        log.debug("Request to save Nurse : {}", nurseDTO);
        Nurse nurse = nurseMapper.toEntity(nurseDTO);
        nurse = nurseRepository.save(nurse);
        return nurseMapper.toDto(nurse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NurseDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Nurses");
        return nurseRepository.findAll(pageable)
            .map(nurseMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<NurseDTO> findOne(Long id) {
        log.debug("Request to get Nurse : {}", id);
        return nurseRepository.findById(id)
            .map(nurseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Nurse : {}", id);
        nurseRepository.deleteById(id);
    }
}
