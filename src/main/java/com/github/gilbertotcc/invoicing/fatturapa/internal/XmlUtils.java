package com.github.gilbertotcc.invoicing.fatturapa.internal;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import it.gov.fatturapa.FatturaElettronicaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlUtils {

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XmlUtils() {
        try {
            log.trace("Initializing XmlUtils ...");
            JAXBContext jaxbContext = JAXBContext.newInstance(FatturaElettronicaType.class);
            marshaller = jaxbContext.createMarshaller();
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(format("Cannot initialize XmlUtils. %s", e.toString()), e);
        }
    }

    public FatturaElettronicaType loadIFatturaElettronicaTypeFrom(final File file) throws IOException {
        try {
            log.trace("Load XML from file {}", file.getAbsolutePath());
            return (FatturaElettronicaType) JAXBIntrospector.getValue(unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            throw new IOException(format("Cannot load XML from file '%s'", file.getAbsolutePath()), e);
        }
    }

    public void saveFatturaElettronicaTypeTo(final FatturaElettronicaType fatturaElettronicaType, final File file) throws IOException {
        try {
            log.trace("Save XML to file {}", file.getAbsolutePath());
            marshaller.marshal(fatturaElettronicaType, file);
        } catch (JAXBException e) {
            throw new IOException(format("Cannot save XML to file '%s'", file.getAbsolutePath()), e);
        }
    }
}
