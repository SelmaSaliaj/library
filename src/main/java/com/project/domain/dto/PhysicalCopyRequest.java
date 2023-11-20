package com.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalCopyRequest extends BaseRequest {

    private String title;

    private String author;

    private String genre;

    private Integer numberOfCopies;

    private Integer numberOfCopiesAvailable;

    private Integer locationId;

}
