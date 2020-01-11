package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
abstract class AbstractBasicSubject {

    private final UserFiscalId userFiscalId;

    private final String fiscalCode;

    private final String businessName;

    private final String firstName;

    private final String lastName;
}
