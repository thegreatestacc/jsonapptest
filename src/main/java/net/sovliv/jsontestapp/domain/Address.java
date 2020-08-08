package net.sovliv.jsontestapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Embedded
    private Geo geo;
}
