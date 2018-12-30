package com.github.gilbertotcc.invoicing.fatturapa.internal;

import static org.junit.Assert.assertEquals;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import it.gov.fatturapa.FatturaElettronicaType;
import org.junit.Test;

public class InvoiceToFatturaElettronicaTypeConverterTest {

    @Test
    public void convertShouldSuccess() {
        InvoiceToFatturaElettronicaTypeConverter converter = new InvoiceToFatturaElettronicaTypeConverter();

        Invoice invoice = invoice();
        FatturaElettronicaType fatturaElettronicaType = converter.convert(invoice);

        assertEquals(invoice.getFatturaElettronicaType(), fatturaElettronicaType);
    }

    private static Invoice invoice() {
        FatturaElettronicaType fatturaElettronicaType = new FatturaElettronicaType();
        return Invoice.builder()
                .fatturaElettronicaType(fatturaElettronicaType)
                .build();
    }
}
