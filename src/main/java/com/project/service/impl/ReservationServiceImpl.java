package com.project.service.impl;

import com.project.domain.dto.ReservationDTO;
import com.project.domain.mapper.ReservationMapper;
import com.project.repository.ReservationDao;
import com.project.service.ReservationService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationDao repository;

    private static final ReservationMapper RESERVATION_MAPPER = Mappers.getMapper(ReservationMapper.class);

    public ReservationServiceImpl(ReservationDao repository) {
        this.repository = repository;
    }

    @Override
    public ReservationDTO findById(Integer id) {
        return RESERVATION_MAPPER.toReservationDTO(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public Page<ReservationDTO> getEntities(Pageable pageable) {
        return null;
    }

    @Override
    public void save(ReservationDTO request) {
        repository.save(RESERVATION_MAPPER.toReservationEntity(request));
    }

    @Override
    public void update(ReservationDTO request) {
        repository.save(RESERVATION_MAPPER.toReservationEntity(request,
                repository.findById(request.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public void softDelete(Integer id) {
        repository.softDelete(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void restore(Integer id) {
        repository.restore(repository.findById(id).orElseThrow(() -> new RuntimeException()));
    }
}
