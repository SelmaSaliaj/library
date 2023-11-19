package com.project.domain.mapper;

import com.project.domain.dto.ReaderDTO;
import com.project.domain.dto.ReservationDTO;
import com.project.domain.entity.ReaderEntity;
import com.project.domain.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper
public interface ReservationMapper {

    @Mapping(source = "readerEntity",target = "readerDTO",qualifiedByName = "toReaderDTO")
    ReservationDTO toReservationDTO(ReservationEntity reservation);

    @Mapping(source = "readerDTO",target = "reader",qualifiedByName = "toReaderEntity")
    ReservationEntity toReservationEntity(ReservationDTO reservation);

    @Mapping(source = "readerDTO",target = "reader",qualifiedByName = "toReaderEntity")
    ReservationEntity toReservationEntity(ReservationDTO dto, @MappingTarget ReservationEntity reservation);

    @Named("toReaderDTO")
    default ReaderDTO toReaderDTO(ReaderEntity reader){
        return ReaderMapper.toDTO(reader);
    }

    @Named("toReaderEntity")
    default ReaderEntity toReaderEntity(ReaderDTO reader){
        return ReaderMapper.toEntity(reader);
    }

}
