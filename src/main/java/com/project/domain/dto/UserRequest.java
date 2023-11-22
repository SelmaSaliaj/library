package com.project.domain.dto;

import com.project.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String username;

    private String password;

    private Role authorities;

    private Integer readerId;

}
