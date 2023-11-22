package com.project.domain.mapper;

import com.project.domain.dto.LocationDTO;
import com.project.domain.dto.LocationRequest;
import com.project.domain.entity.LocationEntity;

public class LocationMapper {
    public static LocationEntity toEntity(LocationRequest locationRequest){
        LocationEntity toReturn = new LocationEntity();
        toReturn.setPlacement(locationRequest.getPlacement());
        toReturn.setPosition(locationRequest.getPosition());
        toReturn.setNameOfTheShelf(locationRequest.getNameOfTheShelf());
        return toReturn;
    }

    public static LocationDTO toDTO(LocationEntity location){
        LocationDTO toReturn = new LocationDTO();
        toReturn.setId(location.getId());
        toReturn.setPosition(location.getPosition());
        toReturn.setPlacement(location.getPlacement());
        toReturn.setNameOfTheShelf(location.getNameOfTheShelf());
        return toReturn;
    }

    public static LocationEntity toEntity(LocationDTO location){
        LocationEntity toReturn = new LocationEntity();
        toReturn.setId(location.getId());
        toReturn.setPlacement(location.getPlacement());
        toReturn.setPosition(location.getPosition());
        toReturn.setNameOfTheShelf(location.getNameOfTheShelf());
        return toReturn;
    }

}
