package com.github.kalininaleksandrv.validation;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class Address {
    @NotBlank(message = "index can't be empty")
    private String index;
    @NotBlank(message = "street can't be empty")
    private String street;
    @Min(value = 1, message = "number can't be less then 1")
    @Max(value = 100, message = "number can't be greater then 100")
    private Integer house;
}
