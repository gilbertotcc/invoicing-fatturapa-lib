package com.github.gilbertotcc.invoicing.fatturapa.model;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
public class Transferor extends AbstractBasicSubject {

    @Value
    public static class Delegate extends AbstractBasicSubject {

        private String salutation;

        private String eoriCode; // Economic Operator Registration and Identification Code

        @Builder
        private Delegate(final UserFiscalId userFiscalId,
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

    private String salutation;

    private String eoriCode; // Economic Operator Registration and Identification Code

    private ProfessionalRegisterSubscriptionData professionalRegisterSubscriptionData;

    private Address address;

    private Address permanentEstablishmentAddress;

    @Singular
    private List<Contact> contacts;

    private String administrationReference;

    private Delegate delegate;

    @Builder
    private Transferor(final UserFiscalId userFiscalId,
                       final String fiscalCode,
                       final String businessName,
                       final String firstName,
                       final String lastName,
                       final String salutation,
                       final String eoriCode,
                       final ProfessionalRegisterSubscriptionData professionalRegisterSubscriptionData,
                       final Address address,
                       final Address permanentEstablishmentAddress,
                       final List<Contact> contacts,
                       final String administrationReference,
                       final Transferor.Delegate delegate) {
        super(userFiscalId, fiscalCode, businessName, firstName, lastName);
        this.salutation = salutation;
        this.eoriCode = eoriCode;
        this.professionalRegisterSubscriptionData = professionalRegisterSubscriptionData;
        this.address = address;
        this.permanentEstablishmentAddress = permanentEstablishmentAddress;
        this.contacts = contacts;
        this.administrationReference = administrationReference;
        this.delegate = delegate;
    }
}
