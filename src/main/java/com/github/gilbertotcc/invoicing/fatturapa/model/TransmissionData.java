package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TransmissionData {

    private UserFiscalId userFiscalId;

    private String documentId;

    private InvoiceFormat invoiceFormat;

    private RecipientCode recipientCode;

    private String senderPhone;

    private String senderEmail;

    private String senderCertifiedEmail;
}
