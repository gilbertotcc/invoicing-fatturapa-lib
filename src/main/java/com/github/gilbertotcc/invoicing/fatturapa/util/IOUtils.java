package com.github.gilbertotcc.invoicing.fatturapa.util;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import it.gov.fatturapa.FatturaElettronicaType;

public class IOUtils {

    private static final Marshaller marshaller;
    private static final Unmarshaller unmarshaller;

    static {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FatturaElettronicaType.class);
            marshaller = jaxbContext.createMarshaller();
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(format("Cannot initialize IOUtils: %s", e.toString()), e);
        }
    }

    private IOUtils() {}

    public static Invoice loadInvoiceFrom(final File file) throws IOException {
        try {
            FatturaElettronicaType fatturaElettronicaType = (FatturaElettronicaType) JAXBIntrospector.getValue(unmarshaller.unmarshal(file));
            return new Invoice(fatturaElettronicaType);
        } catch (JAXBException e) {
            throw new IOException(format("Cannot load invoice from file '%s'", file.getAbsolutePath()), e);
        }
    }

    public static void saveInvoiceTo(final Invoice invoice, final File file) throws IOException {
        try {
            FatturaElettronicaType fatturaElettronicaType = invoice.getFatturaElettronicaType();
            marshaller.marshal(fatturaElettronicaType, file);
        } catch (JAXBException e) {
            throw new IOException(format("Cannot save invoice to file '%s'", file.getAbsolutePath()), e);
        }
    }
}
