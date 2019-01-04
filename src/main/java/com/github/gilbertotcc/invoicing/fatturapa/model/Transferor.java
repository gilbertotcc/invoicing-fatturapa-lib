package com.github.gilbertotcc.invoicing.fatturapa.model;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder
public class Transferor {

    private UserFiscalId userFiscalId;

    private String fiscalCode;

    private String businessName;

    private String firstName;

    private String lastName;

    private String salutation;

    private String eoriCode; // Economic Operator Registration and Identification Code

    private ProfessionalRegisterSubscriptionData professionalRegisterSubscriptionData;

    private Address address;

    private Address permanentEstablishmentAddress;

    @Singular
    private List<Contact> contacts;

    private String administrationReference;

    private TransferorDelegate transferorDelegate;
}
