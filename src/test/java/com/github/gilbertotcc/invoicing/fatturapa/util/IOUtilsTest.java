package com.github.gilbertotcc.invoicing.fatturapa.util;

import java.io.File;
import java.io.IOException;

import com.github.gilbertotcc.invoicing.fatturapa.Invoice;
import org.junit.Test;

public class IOUtilsTest {

    private static final String INVOICES_PATH = "src/test/resources/invoice_examples/";

    @Test
    public void loadInvoiceIT01234567890_FPA01FromFileShouldSuccess() throws IOException {
        Invoice invoice = IOUtils.loadInvoiceFrom(new File(INVOICES_PATH + "IT01234567890_FPA01.xml"));
        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPA02FromFileShouldSuccess() throws IOException {
        Invoice invoice = IOUtils.loadInvoiceFrom(new File(INVOICES_PATH + "IT01234567890_FPA02.xml"));
        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPA03FromFileShouldSuccess() throws IOException {
        Invoice invoice = IOUtils.loadInvoiceFrom(new File(INVOICES_PATH + "IT01234567890_FPA03.xml"));
        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPR01FromFileShouldSuccess() throws IOException {
        Invoice invoice = IOUtils.loadInvoiceFrom(new File(INVOICES_PATH + "IT01234567890_FPR01.xml"));
        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPR02FromFileShouldSuccess() throws IOException {
        Invoice invoice = IOUtils.loadInvoiceFrom(new File(INVOICES_PATH + "IT01234567890_FPR02.xml"));
        // TODO Add asserts
    }

    @Test
    public void loadInvoiceIT01234567890_FPR03FromFileShouldSuccess() throws IOException {
        Invoice invoice = IOUtils.loadInvoiceFrom(new File(INVOICES_PATH + "IT01234567890_FPR03.xml"));
        // TODO Add asserts
    }
}
