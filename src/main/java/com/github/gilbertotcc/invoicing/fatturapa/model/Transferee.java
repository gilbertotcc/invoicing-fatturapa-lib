package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
public class Transferee extends AbstractBasicSubject {

    @Value
    public static class Delegate extends AbstractBasicSubject {

        @Builder
        private Delegate(final UserFiscalId userFiscalId,
                         final String fiscalCode,
                         final String businessName,
                         final String firstName,
                         final String lastName) {
            super(userFiscalId, fiscalCode, businessName, firstName, lastName);
        }
    }

    private String salutation;

    private String eoriCode; // Economic Operator Registration and Identification Code

    private Address address;

    private Address permanentEstablishmentAddress;

    private Delegate delegate;

    @Builder
    private Transferee(final UserFiscalId userFiscalId,
                       final String fiscalCode,
                       final String businessName,
                       final String firstName,
                       final String lastName,
                       final String salutation,
                       final String eoriCode,
                       final Address address,
                       final Address permanentEstablishmentAddress,
                       final Delegate delegate) {
        super(userFiscalId, fiscalCode, businessName, firstName, lastName);
        this.salutation = salutation;
        this.eoriCode = eoriCode;
        this.address = address;
        this.permanentEstablishmentAddress = permanentEstablishmentAddress;
        this.delegate = delegate;
    }
}
