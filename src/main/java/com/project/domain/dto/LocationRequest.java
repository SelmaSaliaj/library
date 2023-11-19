package com.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {

    private String nameOfTheShelf;

    private Integer row;

    private Integer position;

}
