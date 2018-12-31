package com.github.gilbertotcc.invoicing.fatturapa.internal.xml;

import static com.github.gilbertotcc.invoicing.fatturapa.model.RecipientCode.publicAdministrationCode;
import static org.junit.Assert.assertEquals;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import com.github.gilbertotcc.invoicing.fatturapa.model.TransmissionData;
import static com.github.gilbertotcc.invoicing.fatturapa.model.UserFiscalId.userFiscalId;
import it.gov.fatturapa.DatiTrasmissioneType;
import org.junit.Test;

public class DatiTrasmissioneTypeFactoryTest {

    @Test
    public void elementFromInvoiceShouldSuccess() {
        TransmissionData transmissionData = TransmissionData.builder()
                .userFiscalId(userFiscalId("IT", "01234567890"))
                .documentId("00001")
                .recipientCode(publicAdministrationCode("AAAAAA"))
                .build();

        Invoice invoice = Invoice.builder()
                .transmissionData(transmissionData)
                .build();

        DatiTrasmissioneType datiTrasmissioneType = new DatiTrasmissioneTypeFactory()
                .elementFrom(invoice);

        assertEquals("IT", datiTrasmissioneType.getIdTrasmittente().getIdPaese());
        assertEquals("01234567890", datiTrasmissioneType.getIdTrasmittente().getIdCodice());
        assertEquals("00001", datiTrasmissioneType.getProgressivoInvio());
        assertEquals(null /* FIXME */, datiTrasmissioneType.getFormatoTrasmissione());
        assertEquals("AAAAAA", datiTrasmissioneType.getCodiceDestinatario());
    }
}
