package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Transferee {

    private UserFiscalId userFiscalId;

    private String fiscalCode;

    private String businessName;

    private String firstName;

    private String lastName;

    private String salutation;

    private String eoriCode; // Economic Operator Registration and Identification Code

    private Address address;

    private Address permanentEstablishmentAddress;

    private TransfereeDelegate delegate;

}
