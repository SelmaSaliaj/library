package com.project.domain.dto;

import com.project.domain.enums.Role;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO{

    @NotBlank(message = "Username is required")
    private String username;

    @NotNull(message = "Authority is required")
    private Role authorities;

}
