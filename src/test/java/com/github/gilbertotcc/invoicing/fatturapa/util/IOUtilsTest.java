package com.github.gilbertotcc.invoicing.fatturapa.util;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.internal.FatturaElettronicaTypeToInvoiceConverter;
import com.github.gilbertotcc.invoicing.fatturapa.internal.InvoiceToFatturaElettronicaTypeConverter;
import com.github.gilbertotcc.invoicing.fatturapa.internal.XmlUtils;
import it.gov.fatturapa.FatturaElettronicaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IOUtilsTest {

    @Mock
    private FatturaElettronicaTypeToInvoiceConverter fatturaElettronicaTypeToInvoiceConverter;

    @Mock
    private InvoiceToFatturaElettronicaTypeConverter invoiceToFatturaElettronicaTypeConverter;

    @Mock
    private XmlUtils xmlUtils;

    @Test
    public void verifyLoadInvoiceFromFile() throws IOException {
        IOUtils ioUtils = new IOUtils(fatturaElettronicaTypeToInvoiceConverter, invoiceToFatturaElettronicaTypeConverter, xmlUtils);

        File file = temporaryFile();
        ioUtils.loadInvoiceFrom(file);

        verify(xmlUtils, times(1)).loadIFatturaElettronicaTypeFrom(eq(file));
        verify(fatturaElettronicaTypeToInvoiceConverter, times(1))
                .convert(any(FatturaElettronicaType.class));
    }

    @Test
    public void verifySaveInvoiceToFile() throws IOException {
        IOUtils ioUtils = new IOUtils(fatturaElettronicaTypeToInvoiceConverter, invoiceToFatturaElettronicaTypeConverter, xmlUtils);

        Invoice invoice = randomInvoice();
        ioUtils.saveInvoiceTo(invoice, temporaryFile());

        verify(invoiceToFatturaElettronicaTypeConverter, times(1)).convert(eq(invoice));
        verify(xmlUtils, times(1))
                .saveFatturaElettronicaTypeTo(any(FatturaElettronicaType.class), any(File.class));
    }

    private static File temporaryFile() throws IOException {
        File temporaryFile = File.createTempFile("IOUtilsTest-", null);
        temporaryFile.deleteOnExit();
        return temporaryFile;
    }

    private static Invoice randomInvoice() {
        return Invoice
                .builder()
                .build();
    }
}
