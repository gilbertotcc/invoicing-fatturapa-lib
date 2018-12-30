package com.github.gilbertotcc.invoicing.fatturapa.internal;

import java.util.Optional;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.internal.xml.XmlElementFactory;
import com.github.gilbertotcc.invoicing.fatturapa.model.TransmissionData;
import it.gov.fatturapa.ContattiTrasmittenteType;
import it.gov.fatturapa.DatiTrasmissioneType;
import it.gov.fatturapa.IdFiscaleType;

public class DatiTrasmissioneTypeFactory implements XmlElementFactory<DatiTrasmissioneType> {

    @Override
    public DatiTrasmissioneType elementFrom(final Invoice invoice) {
        TransmissionData transmissionData = invoice.getTransmissionData();

        DatiTrasmissioneType datiTrasmissioneType = new DatiTrasmissioneType();
        Optional.of(transmissionData.getUserFiscalId())
                .map(userFiscalId -> {
                    IdFiscaleType idFiscaleType = new IdFiscaleType();
                    idFiscaleType.setIdPaese(userFiscalId.getCountryCode());
                    idFiscaleType.setIdCodice(userFiscalId.getUserCode());
                    return idFiscaleType;
                })
                .ifPresent(datiTrasmissioneType::setIdTrasmittente);
        datiTrasmissioneType.setProgressivoInvio(transmissionData.getDocumentId());
        datiTrasmissioneType.setFormatoTrasmissione(null /* FIXME */);
        datiTrasmissioneType.setCodiceDestinatario(transmissionData.getRecipientCode().recipientCode());

        ContattiTrasmittenteType contattiTrasmittenteType = new ContattiTrasmittenteType();
        contattiTrasmittenteType.setTelefono(transmissionData.getSenderPhone());
        contattiTrasmittenteType.setEmail(transmissionData.getSenderEmail());
        datiTrasmissioneType.setContattiTrasmittente(contattiTrasmittenteType);

        datiTrasmissioneType.setPECDestinatario(transmissionData.getSenderCertifiedEmail());

        return datiTrasmissioneType;
    }
}
