package com.github.gilbertotcc.invoicing.fatturapa.internal;

import static com.github.gilbertotcc.invoicing.fatturapa.model.RecipientCode.publicAdministrationCode;
import static com.github.gilbertotcc.invoicing.fatturapa.model.UserFiscalId.userFiscalId;
import static org.junit.Assert.assertEquals;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.model.TransmissionData;
import it.gov.fatturapa.FatturaElettronicaType;
import org.junit.Test;

public class InvoiceToFatturaElettronicaTypeConverterTest {

    @Test
    public void convertShouldSuccess() {
        InvoiceToFatturaElettronicaTypeConverter converter = new InvoiceToFatturaElettronicaTypeConverter();

        Invoice invoice = invoice();
        FatturaElettronicaType fatturaElettronicaType = converter.convert(invoice);

        assertEquals(
                invoice.getTransmissionData().getDocumentId(),
                fatturaElettronicaType.getFatturaElettronicaHeader().getDatiTrasmissione().getProgressivoInvio());
        // TODO Add more asserts
    }

    private static Invoice invoice() {
        TransmissionData transmissionData = TransmissionData.builder()
                .userFiscalId(userFiscalId("IT", "01234567890"))
                .documentId("00001")
                .recipientCode(publicAdministrationCode("AAAAAA"))
                .build();

        FatturaElettronicaType fatturaElettronicaType = new FatturaElettronicaType();
        return Invoice.builder()
                .transmissionData(transmissionData)
                .fatturaElettronicaType(fatturaElettronicaType)
                .build();
    }
}
