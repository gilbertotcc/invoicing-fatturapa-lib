package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
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

    private String phone;

    private String fax;

    private String email;

    private String administrationReference;
}
