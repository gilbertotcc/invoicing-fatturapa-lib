package com.github.gilbertotcc.invoicing.fatturapa.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Contact {

    public enum Type {
        PHONE,
        FAX,
        EMAIL,
        CERTIFIED_EMAIL
    }

    @NonNull
    private final Type type;

    @NonNull
    private final String value;

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static class Phone extends Contact {

        public Phone(final String number) {
            super(Type.PHONE, number);
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static class Fax extends Contact {

        public Fax(final String number) {
            super(Type.FAX, number);
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static class Email extends Contact {

        public Email(final String email) {
            super(Type.EMAIL, email);
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static class CertifiedEmail extends Contact {

        public CertifiedEmail(final String email) {
            super(Type.CERTIFIED_EMAIL, email);
        }
    }
}
