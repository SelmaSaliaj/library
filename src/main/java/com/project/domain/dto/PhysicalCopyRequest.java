package com.project.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalCopyRequest {

    private String title;

    private String author;

    private String genre;

    private Integer numberOfCopies;

    private Integer locationId;

}
