package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Value;

@Value(staticConstructor = "userFiscalId")
public class UserFiscalId {

    private String countryCode;

    private String userCode;
}
