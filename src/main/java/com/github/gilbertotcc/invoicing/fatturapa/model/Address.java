package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {

    private String street;

    private String streetNumber;

    private String postalCode;

    private String city;

    private String provinceCode;

    private String countryCode;
}
