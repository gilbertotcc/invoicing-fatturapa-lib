package com.github.gilbertotcc.invoicing.fatturapa;

import it.gov.fatturapa.FatturaElettronicaType;
import lombok.Data;

@Data
public class Invoice {

    // TODO Very dummy FatturaPA is only a wrapper of FatturaElettronicaType
    private final FatturaElettronicaType fatturaElettronicaType;
}
