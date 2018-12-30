package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TransmissionData {

    private UserFiscalId userFiscalId;

    private String documentId;

    // FIXME Add type "Pubblica Amministrazione" or "Privato"

    private RecipientCode recipientCode;

    private String senderPhone;

    private String senderEmail;

    private String senderCertifiedEmail;
}
