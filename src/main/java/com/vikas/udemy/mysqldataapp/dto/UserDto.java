package com.vikas.udemy.mysqldataapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(description = "Information regarding UserDto object")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDto {
    private long id;
    @Schema(description = "user first name")
    @NotEmpty(message = "first name must not be empty")
    private String firstName;
    @Schema(description = "user last name")
    @NotEmpty(message = "last name must not be empty")
    private String lastName;
    @Schema(description = "user email")
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email must be valid")
    private String email;
    @Schema(description = "user address lines")
    private AddressDto address;
}
