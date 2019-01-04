package com.github.gilbertotcc.invoicing.fatturapa.internal;

import java.util.EnumMap;
import java.util.Optional;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.model.Contact;
import com.github.gilbertotcc.invoicing.fatturapa.model.InvoiceFormat;
import com.github.gilbertotcc.invoicing.fatturapa.model.TransmissionData;
import com.github.gilbertotcc.invoicing.fatturapa.model.UserFiscalId;
import it.gov.fatturapa.DatiTrasmissioneType;
import it.gov.fatturapa.FatturaElettronicaType;
import it.gov.fatturapa.FormatoTrasmissioneType;

public class FatturaElettronicaTypeToInvoiceConverter implements Converter<FatturaElettronicaType, Invoice> {

    private static final EnumMap<FormatoTrasmissioneType, InvoiceFormat> INVOICE_FORMAT_ENUM_MAP = new EnumMap<>(FormatoTrasmissioneType.class);
    static {
        INVOICE_FORMAT_ENUM_MAP.put(FormatoTrasmissioneType.FPA_12, InvoiceFormat.PUBLIC_ADMINISTRATION_INVOICE_FORMAT);
        INVOICE_FORMAT_ENUM_MAP.put(FormatoTrasmissioneType.FPR_12, InvoiceFormat.PPRIVATE_INVOICE_FORMAT);
    }

    @Override
    public Invoice convert(final FatturaElettronicaType object) {

        DatiTrasmissioneType datiTrasmissioneType = object.getFatturaElettronicaHeader().getDatiTrasmissione();
        TransmissionData.TransmissionDataBuilder transmissionDataBuilder = TransmissionData.builder();
        Optional.of(datiTrasmissioneType.getIdTrasmittente())
                .map(idFiscaleType -> UserFiscalId.userFiscalId(idFiscaleType.getIdPaese(), idFiscaleType.getIdCodice()))
                .ifPresent(transmissionDataBuilder::userFiscalId);
        transmissionDataBuilder.documentId(datiTrasmissioneType.getProgressivoInvio());
        transmissionDataBuilder.invoiceFormat(INVOICE_FORMAT_ENUM_MAP.get(datiTrasmissioneType.getFormatoTrasmissione()));
        transmissionDataBuilder.recipientCode(datiTrasmissioneType::getCodiceDestinatario);
        Optional.ofNullable(datiTrasmissioneType.getContattiTrasmittente())
                .ifPresent(contattiTrasmittenteType -> {
                    Optional.ofNullable(contattiTrasmittenteType.getTelefono())
                            .ifPresent(phone -> transmissionDataBuilder.senderContact(Contact.contact(Contact.Type.PHONE, phone)));
                    Optional.ofNullable(contattiTrasmittenteType.getEmail())
                            .ifPresent(email -> transmissionDataBuilder.senderContact(Contact.contact(Contact.Type.EMAIL, email)));
                });
        Optional.ofNullable(datiTrasmissioneType.getPECDestinatario())
                .ifPresent(email -> transmissionDataBuilder.senderContact(Contact.contact(Contact.Type.CERTIFIED_EMAIL, email)));

        return Invoice.builder()
                .transmissionData(transmissionDataBuilder.build())
                .fatturaElettronicaType(object)
                .build();
    }
}
