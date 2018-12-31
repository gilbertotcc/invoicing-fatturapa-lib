package com.github.gilbertotcc.invoicing.fatturapa.internal;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.internal.xml.DatiTrasmissioneTypeFactory;
import it.gov.fatturapa.DatiTrasmissioneType;
import it.gov.fatturapa.FatturaElettronicaHeaderType;
import it.gov.fatturapa.FatturaElettronicaType;

public class InvoiceToFatturaElettronicaTypeConverter implements Converter<Invoice, FatturaElettronicaType> {

    private static final DatiTrasmissioneTypeFactory DATI_TRASMISSIONE_TYPE_FACTORY = new DatiTrasmissioneTypeFactory();

    @Override
    public FatturaElettronicaType convert(final Invoice object) {

        // Header
        FatturaElettronicaHeaderType fatturaElettronicaHeaderType = new FatturaElettronicaHeaderType();
        DatiTrasmissioneType datiTrasmissioneType = DATI_TRASMISSIONE_TYPE_FACTORY.elementFrom(object);
        fatturaElettronicaHeaderType.setDatiTrasmissione(datiTrasmissioneType);

        // Body

        FatturaElettronicaType fatturaElettronicaType = new FatturaElettronicaType();
        fatturaElettronicaType.setFatturaElettronicaHeader(fatturaElettronicaHeaderType);

        return fatturaElettronicaType;
    }
}
