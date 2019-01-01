package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.Value;

@Value(staticConstructor = "contact")
public class Contact {

    public enum Type {
        PHONE,
        FAX,
        EMAIL,
        CERTIFIED_EMAIL
    }

    private Type type;

    private String value;
}
