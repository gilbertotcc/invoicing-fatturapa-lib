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

    public static Contact phone(final String phoneNumber) {
        return new Contact(Type.PHONE, phoneNumber);
    }

    public static Contact fax(final String faxNumber) {
        return new Contact(Type.FAX, faxNumber);
    }

    public static Contact email(final String email) {
        return new Contact(Type.EMAIL, email);
    }

    public static Contact certifiedEmail(final String certifiedEmail) {
        return new Contact(Type.CERTIFIED_EMAIL, certifiedEmail);
    }
}
