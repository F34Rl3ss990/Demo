package com.example.demo.web.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    @NotNull
    @Max(999999)
    private int mileage;

    @NotNull
    @Size(max = 60)
    private String type;

    @NotNull
    @Pattern(regexp = "[A-Za-z]")
    @Size(max = 60)
    private String brand;

    @NotNull
    @Min(1900)
    private int yearOfManufacture;

    @NotNull
    private int userId;
}
