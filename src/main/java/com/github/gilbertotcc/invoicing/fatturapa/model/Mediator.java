package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
public class Mediator extends AbstractBasicSubject {

    private String salutation;

    private String eoriCode; // Economic Operator Registration and Identification Code

    @Builder
    private Mediator(final UserFiscalId userFiscalId,
                     final String fiscalCode,
                     final String businessName,
                     final String firstName,
                     final String lastName,
                     final String salutation,
                     final String eoriCode) {
        super(userFiscalId, fiscalCode, businessName, firstName, lastName);
        this.salutation = salutation;
        this.eoriCode = eoriCode;
    }
}
