package com.vikas.udemy.mysqldataapp.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Address {
    @Column(name = "address_line1")
    private String line1;
    @Column(name = "address_line2")
    private String line2;
}
