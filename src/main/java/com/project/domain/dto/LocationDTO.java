package com.project.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO extends BaseDTO{

    @NotBlank(message = "The name of the shelf is required")
    private String nameOfTheShelf;

    @NotNull
    @Positive(message = "The value needs to be a positive number")
    private Integer row;

    @NotNull
    @Positive(message = "The value needs to be a positive number")
    private Integer position;

}
