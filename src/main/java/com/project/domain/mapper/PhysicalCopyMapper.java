package com.project.domain.mapper;

import com.project.domain.dto.PhysicalCopyDTO;
import com.project.domain.dto.PhysicalCopyRequest;
import com.project.domain.entity.LocationEntity;
import com.project.domain.entity.PhysicalCopyEntity;

public class PhysicalCopyMapper {

    public static PhysicalCopyEntity toEntity(PhysicalCopyRequest copyRequest){
        PhysicalCopyEntity toReturn = new PhysicalCopyEntity();
        toReturn.setTitle(copyRequest.getTitle());
        toReturn.setAuthor(copyRequest.getAuthor());
        toReturn.setGenre(copyRequest.getGenre());
        return toReturn;
    }

    public static PhysicalCopyEntity toEntity(PhysicalCopyRequest copyRequest , LocationEntity location){
        PhysicalCopyEntity toReturn = new PhysicalCopyEntity();
        toReturn.setTitle(copyRequest.getTitle());
        toReturn.setAuthor(copyRequest.getAuthor());
        toReturn.setGenre(copyRequest.getGenre());
        toReturn.setLocation(location);
        return toReturn;
    }

    public static PhysicalCopyDTO toDTO(PhysicalCopyEntity physicalCopy){
        PhysicalCopyDTO toReturn = new PhysicalCopyDTO();
        toReturn.setId(physicalCopy.getId());
        toReturn.setTitle(physicalCopy.getTitle());
        toReturn.setAuthor(physicalCopy.getAuthor());
        toReturn.setGenre(physicalCopy.getGenre());
        toReturn.setLocation(LocationMapper.toDTO(physicalCopy.getLocation()));
        return toReturn;
    }

    public static PhysicalCopyEntity toEntity(PhysicalCopyDTO copy){
        PhysicalCopyEntity toReturn = new PhysicalCopyEntity();
        toReturn.setId(copy.getId());
        toReturn.setTitle(copy.getTitle());
        toReturn.setAuthor(copy.getAuthor());
        toReturn.setGenre(copy.getGenre());
        toReturn.setLocation(LocationMapper.toEntity(copy.getLocation()));
        return toReturn;
    }

}
