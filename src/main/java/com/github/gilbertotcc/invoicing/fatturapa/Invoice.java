package com.github.gilbertotcc.invoicing.fatturapa;

import com.github.gilbertotcc.invoicing.fatturapa.model.Mediator;
import com.github.gilbertotcc.invoicing.fatturapa.model.Transferee;
import com.github.gilbertotcc.invoicing.fatturapa.model.Transferor;
import com.github.gilbertotcc.invoicing.fatturapa.model.TransmissionData;
import it.gov.fatturapa.FatturaElettronicaType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Invoice {

    private TransmissionData transmissionData;

    private Transferor transferor;

    private Transferee transferee;

    private Mediator mediator;

    // TODO Very dummy FatturaPA is only a wrapper of FatturaElettronicaType
    private final FatturaElettronicaType fatturaElettronicaType;
}
