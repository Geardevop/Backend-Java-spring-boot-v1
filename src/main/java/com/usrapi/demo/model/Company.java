package com.usrapi.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String name;
    
    @Column(name = "catch_phrase")
    private String catchPhrase;
    
    private String bs;
}
