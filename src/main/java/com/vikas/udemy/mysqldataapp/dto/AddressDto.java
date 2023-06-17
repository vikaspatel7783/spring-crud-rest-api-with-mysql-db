package com.vikas.udemy.mysqldataapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AddressDto {
    @NotEmpty
    private String line1;
    private String line2;
}
