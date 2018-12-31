package com.github.gilbertotcc.invoicing.fatturapa.internal.xml;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;

public interface XmlElementFactory<T> {

    T elementFrom(final Invoice invoice);
}
