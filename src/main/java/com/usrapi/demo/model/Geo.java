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
public class Geo {
    @Column(name = "lat")
    private String lat;
    
    @Column(name = "lng")
    private String lng;
}
