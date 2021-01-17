package com.example.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull
    @Size(max = 60)
    private String firstName;

    @NotNull
    @Size(max = 60)
    private String lastName;

    @NotNull
    private String email;
}
