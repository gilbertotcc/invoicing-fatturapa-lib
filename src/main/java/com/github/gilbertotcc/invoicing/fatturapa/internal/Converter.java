package com.github.gilbertotcc.invoicing.fatturapa.internal;

public interface Converter<T, U> {

    U convert(final T object);
}
