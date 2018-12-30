package com.github.gilbertotcc.invoicing.fatturapa;

import it.gov.fatturapa.FatturaElettronicaType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Invoice {

    // TODO Very dummy FatturaPA is only a wrapper of FatturaElettronicaType
    private final FatturaElettronicaType fatturaElettronicaType;
}
