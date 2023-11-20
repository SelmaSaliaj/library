package com.project.domain.dto;

import com.project.domain.enums.ReaderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderRequest extends BaseRequest{

    private String name;

    private String surname;

    private String email;

    private String address;

    private String phoneNumber;

    private ReaderStatus status;

    private Integer userId;

}
