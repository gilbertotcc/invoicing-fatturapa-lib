package com.github.gilbertotcc.invoicing.fatturapa.internal.xml;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Optional;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.model.Contact;
import com.github.gilbertotcc.invoicing.fatturapa.model.InvoiceFormat;
import com.github.gilbertotcc.invoicing.fatturapa.model.TransmissionData;
import it.gov.fatturapa.ContattiTrasmittenteType;
import it.gov.fatturapa.DatiTrasmissioneType;
import it.gov.fatturapa.FormatoTrasmissioneType;
import it.gov.fatturapa.IdFiscaleType;

public class DatiTrasmissioneTypeFactory implements XmlElementFactory<DatiTrasmissioneType> {

    private static final EnumMap<InvoiceFormat, FormatoTrasmissioneType> FORMAT_FORMATO_TRASMISSIONE_TYPE_ENUM_MAP =
            new EnumMap<>(InvoiceFormat.class);
    static {
        FORMAT_FORMATO_TRASMISSIONE_TYPE_ENUM_MAP.put(InvoiceFormat.PUBLIC_ADMINISTRATION_INVOICE_FORMAT, FormatoTrasmissioneType.FPA_12);
        FORMAT_FORMATO_TRASMISSIONE_TYPE_ENUM_MAP.put(InvoiceFormat.PPRIVATE_INVOICE_FORMAT, FormatoTrasmissioneType.FPR_12);
    }

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
        FormatoTrasmissioneType formatoTrasmissioneType = FORMAT_FORMATO_TRASMISSIONE_TYPE_ENUM_MAP.get(transmissionData.getInvoiceFormat());
        datiTrasmissioneType.setFormatoTrasmissione(formatoTrasmissioneType);
        datiTrasmissioneType.setCodiceDestinatario(transmissionData.getRecipientCode().recipientCode());

        String senderPhone = firstContactValueByTypeIn(transmissionData.getSenderContacts(), Contact.Type.PHONE).orElse(null);
        String senderEmail = firstContactValueByTypeIn(transmissionData.getSenderContacts(), Contact.Type.EMAIL).orElse(null);

        ContattiTrasmittenteType contattiTrasmittenteType = new ContattiTrasmittenteType();
        contattiTrasmittenteType.setTelefono(senderPhone);
        contattiTrasmittenteType.setEmail(senderEmail);
        datiTrasmissioneType.setContattiTrasmittente(contattiTrasmittenteType);

        String senderCertifiedEmail = firstContactValueByTypeIn(transmissionData.getSenderContacts(), Contact.Type.CERTIFIED_EMAIL).orElse(null);
        datiTrasmissioneType.setPECDestinatario(senderCertifiedEmail);

        return datiTrasmissioneType;
    }

    private static Optional<String> firstContactValueByTypeIn(Collection<Contact> contacts, Contact.Type contactType) {
        return contacts.stream()
                .filter(contact -> contact.getType() == contactType)
                .map(Contact::getValue)
                .findFirst();
    }
}
