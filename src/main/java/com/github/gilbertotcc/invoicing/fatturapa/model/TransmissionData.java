package com.github.gilbertotcc.invoicing.fatturapa.model;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder
public class TransmissionData {

    private UserFiscalId userFiscalId;

    private String documentId;

    private InvoiceFormat invoiceFormat;

    private RecipientCode recipientCode;

    @Singular
    private List<Contact> senderContacts;
}
