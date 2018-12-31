package com.github.gilbertotcc.invoicing.fatturapa.internal;

import static org.junit.Assert.assertEquals;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import it.gov.fatturapa.DatiTrasmissioneType;
import it.gov.fatturapa.FatturaElettronicaHeaderType;
import it.gov.fatturapa.FatturaElettronicaType;
import it.gov.fatturapa.FormatoTrasmissioneType;
import it.gov.fatturapa.IdFiscaleType;
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
        IdFiscaleType idFiscaleType = new IdFiscaleType();
        idFiscaleType.setIdPaese("IT");
        idFiscaleType.setIdCodice("01234567890");

        DatiTrasmissioneType datiTrasmissioneType = new DatiTrasmissioneType();
        datiTrasmissioneType.setIdTrasmittente(idFiscaleType);
        datiTrasmissioneType.setProgressivoInvio("00001");
        datiTrasmissioneType.setFormatoTrasmissione(FormatoTrasmissioneType.FPA_12);
        datiTrasmissioneType.setCodiceDestinatario("AAAAAA");

        FatturaElettronicaHeaderType fatturaElettronicaHeaderType = new FatturaElettronicaHeaderType();
        fatturaElettronicaHeaderType.setDatiTrasmissione(datiTrasmissioneType);

        FatturaElettronicaType fatturaElettronicaType = new FatturaElettronicaType();
        fatturaElettronicaType.setFatturaElettronicaHeader(fatturaElettronicaHeaderType);
        // FIXME This is an empty FatturaElettronicaType... Please, consider to set other fields
        return fatturaElettronicaType;
    }
}
