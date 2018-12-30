package com.github.gilbertotcc.invoicing.fatturapa.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import it.gov.fatturapa.CedentePrestatoreType;
import it.gov.fatturapa.CessionarioCommittenteType;
import it.gov.fatturapa.DatiTrasmissioneType;
import it.gov.fatturapa.FatturaElettronicaType;
import it.gov.fatturapa.FormatoTrasmissioneType;
import it.gov.fatturapa.RegimeFiscaleType;
import org.junit.BeforeClass;
import org.junit.Test;

public class XmlUtilsTest {

    private static final String INVOICES_PATH = "src/test/resources/invoice_examples/";

    private static XmlUtils xmlUtils;

    @BeforeClass
    public static void setUp() {
        xmlUtils = new XmlUtils();
    }

    @Test
    public void loadInvoiceIT01234567890_FPA01FromFileShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType =
                xmlUtils.loadIFatturaElettronicaTypeFrom(new File(INVOICES_PATH + "IT01234567890_FPA01.xml"));

        assertNotNull(fatturaElettronicaType);

        assertEquals(FormatoTrasmissioneType.FPA_12, fatturaElettronicaType.getVersione());

        DatiTrasmissioneType datiTrasmissioneType = fatturaElettronicaType.getFatturaElettronicaHeader().getDatiTrasmissione();
        assertEquals("IT", datiTrasmissioneType.getIdTrasmittente().getIdPaese());
        assertEquals("01234567890", datiTrasmissioneType.getIdTrasmittente().getIdCodice());
        assertEquals("00001", datiTrasmissioneType.getProgressivoInvio());
        assertEquals(FormatoTrasmissioneType.FPA_12, datiTrasmissioneType.getFormatoTrasmissione());
        assertEquals("AAAAAA", datiTrasmissioneType.getCodiceDestinatario());

        CedentePrestatoreType cedentePrestatoreType = fatturaElettronicaType.getFatturaElettronicaHeader().getCedentePrestatore();
        assertEquals("IT", cedentePrestatoreType.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese());
        assertEquals("01234567890", cedentePrestatoreType.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice());
        assertEquals("ALPHA SRL", cedentePrestatoreType.getDatiAnagrafici().getAnagrafica().getDenominazione());
        assertEquals("IT", cedentePrestatoreType.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese());
        assertEquals(RegimeFiscaleType.RF_19, cedentePrestatoreType.getDatiAnagrafici().getRegimeFiscale());
        assertEquals("VIALE ROMA 543", cedentePrestatoreType.getSede().getIndirizzo());
        assertEquals("07100", cedentePrestatoreType.getSede().getCAP());
        assertEquals("SASSARI", cedentePrestatoreType.getSede().getComune());
        assertEquals("SS", cedentePrestatoreType.getSede().getProvincia());
        assertEquals("IT", cedentePrestatoreType.getSede().getNazione());

        CessionarioCommittenteType cessionarioCommittenteType = fatturaElettronicaType.getFatturaElettronicaHeader().getCessionarioCommittente();
        assertEquals("09876543210", cessionarioCommittenteType.getDatiAnagrafici().getCodiceFiscale());
        assertEquals("AMMINISTRAZIONE BETA", cessionarioCommittenteType.getDatiAnagrafici().getAnagrafica().getDenominazione());
        assertEquals("VIA TORINO 38-B", cessionarioCommittenteType.getSede().getIndirizzo());
        assertEquals("00145", cessionarioCommittenteType.getSede().getCAP());
        assertEquals("ROMA", cessionarioCommittenteType.getSede().getComune());
        assertEquals("RM", cessionarioCommittenteType.getSede().getProvincia());
        assertEquals("IT", cessionarioCommittenteType.getSede().getNazione());

        // TODO Add asserts for body

        assertNull(fatturaElettronicaType.getSignature());
    }

    @Test
    public void loadInvoiceIT01234567890_FPA02FromFileShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType =
                xmlUtils.loadIFatturaElettronicaTypeFrom(new File(INVOICES_PATH + "IT01234567890_FPA02.xml"));

        assertNotNull(fatturaElettronicaType);

        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPA03FromFileShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType =
                xmlUtils.loadIFatturaElettronicaTypeFrom(new File(INVOICES_PATH + "IT01234567890_FPA03.xml"));

        assertNotNull(fatturaElettronicaType);

        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPR01FromFileShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType =
                xmlUtils.loadIFatturaElettronicaTypeFrom(new File(INVOICES_PATH + "IT01234567890_FPR01.xml"));

        assertNotNull(fatturaElettronicaType);

        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPR02FromFileShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType =
                xmlUtils.loadIFatturaElettronicaTypeFrom(new File(INVOICES_PATH + "IT01234567890_FPR02.xml"));

        assertNotNull(fatturaElettronicaType);

        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPR03FromFileShouldSuccess() throws IOException {
        FatturaElettronicaType fatturaElettronicaType =
                xmlUtils.loadIFatturaElettronicaTypeFrom(new File(INVOICES_PATH + "IT01234567890_FPR03.xml"));

        assertNotNull(fatturaElettronicaType);

        // TODO Add asserts
    }
}
