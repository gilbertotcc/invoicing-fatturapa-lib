package com.github.gilbertotcc.invoicing.fatturapa.model;

public interface RecipientCode {

    String recipientCode();

    static RecipientCode publicAdministrationCode(final String code) {
        return () -> code;
    }

    static RecipientCode exchangeSystemCode(final String code) {
        return () -> code;
    }

    static RecipientCode pecRecipientCode() {
        return () -> "0000000";
    }
}
