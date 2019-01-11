package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TransfereeDelegate {

    private UserFiscalId userFiscalId;

    private String fiscalCode;

    private String businessName;

    private String firstName;

    private String lastName;
}
