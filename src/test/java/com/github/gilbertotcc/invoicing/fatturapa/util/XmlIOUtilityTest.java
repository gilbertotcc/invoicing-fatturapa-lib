package com.github.gilbertotcc.invoicing.fatturapa.util;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import it.gov.fatturapa.FatturaElettronicaType;
import org.junit.BeforeClass;
import org.junit.Test;

public class XmlIOUtilityTest {

    private static XmlIOUtility<FatturaElettronicaType> xmlIOUtility;

    @BeforeClass
    public static void setUp() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FatturaElettronicaType.class);
            xmlIOUtility = () -> jaxbContext;
        } catch (JAXBException e) {
            throw new RuntimeException("Cannot create JAXBContext");
        }
    }

    @Test
    public void loadFatturaElettronicaTypeShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType = xmlIOUtility
                .loadObjectFrom(new File("src/test/resources/invoice_examples/IT01234567890_FPA01.xml"));
    }
}
