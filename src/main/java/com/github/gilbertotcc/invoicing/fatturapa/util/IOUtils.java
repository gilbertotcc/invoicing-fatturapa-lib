package com.github.gilbertotcc.invoicing.fatturapa.util;

import java.io.File;
import java.io.IOException;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.internal.FatturaElettronicaTypeToInvoiceConverter;
import com.github.gilbertotcc.invoicing.fatturapa.internal.InvoiceToFatturaElettronicaTypeConverter;
import com.github.gilbertotcc.invoicing.fatturapa.internal.XmlUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOUtils {

    public static final IOUtils INSTANCE = new IOUtils(
            new FatturaElettronicaTypeToInvoiceConverter(),
            new InvoiceToFatturaElettronicaTypeConverter(),
            new XmlUtils()
    );

    private FatturaElettronicaTypeToInvoiceConverter fatturaElettronicaTypeToInvoiceConverter;
    private InvoiceToFatturaElettronicaTypeConverter invoiceToFatturaElettronicaTypeConverter;
    private XmlUtils xmlUtils;

    IOUtils(
            final FatturaElettronicaTypeToInvoiceConverter fatturaElettronicaTypeToInvoiceConverter,
            final InvoiceToFatturaElettronicaTypeConverter invoiceToFatturaElettronicaTypeConverter,
            final XmlUtils xmlUtils
    ) {
        this.fatturaElettronicaTypeToInvoiceConverter = fatturaElettronicaTypeToInvoiceConverter;
        this.invoiceToFatturaElettronicaTypeConverter = invoiceToFatturaElettronicaTypeConverter;
        this.xmlUtils = xmlUtils;
    }

    public Invoice loadInvoiceFrom(final File file) throws IOException {
        log.debug("Load invoice from file '{}'", file.getAbsolutePath());
        return fatturaElettronicaTypeToInvoiceConverter.convert(
                xmlUtils.loadIFatturaElettronicaTypeFrom(file)
        );
    }

    public void saveInvoiceTo(final Invoice invoice, final File file) throws IOException {
        log.debug("Save invoice {} to file '{}'", invoice, file.getAbsolutePath());
        xmlUtils.saveFatturaElettronicaTypeTo(
                invoiceToFatturaElettronicaTypeConverter.convert(invoice),
                file
        );
    }
}
