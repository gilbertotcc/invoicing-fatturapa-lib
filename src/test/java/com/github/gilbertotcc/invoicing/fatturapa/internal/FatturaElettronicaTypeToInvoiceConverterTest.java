package com.github.gilbertotcc.invoicing.fatturapa.internal;

import static org.junit.Assert.assertEquals;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import it.gov.fatturapa.FatturaElettronicaType;
import org.junit.Test;

public class FatturaElettronicaTypeToInvoiceConverterTest {

    @Test
    public void convertShouldSucccess() {
        FatturaElettronicaTypeToInvoiceConverter converter = new FatturaElettronicaTypeToInvoiceConverter();

        FatturaElettronicaType fatturaElettronicaType = fatturaElettronicaType();
        Invoice invoice = converter.convert(fatturaElettronicaType);

        assertEquals(fatturaElettronicaType, invoice.getFatturaElettronicaType());
    }

    private static FatturaElettronicaType fatturaElettronicaType() {
        FatturaElettronicaType fatturaElettronicaType = new FatturaElettronicaType();
        // FIXME This is an empty FatturaElettronicaType... Please, consider to set other fields
        return fatturaElettronicaType;
    }
}
