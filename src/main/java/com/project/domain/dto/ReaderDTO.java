package com.project.domain.dto;

import com.project.domain.enums.ReaderStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDTO extends BaseDTO{

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull
    private String address;

    private String phoneNumber;

    @NotNull
    private ReaderStatus status;

    @NotNull
    private UserDTO user;

}
