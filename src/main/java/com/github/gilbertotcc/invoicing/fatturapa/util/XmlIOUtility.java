package com.github.gilbertotcc.invoicing.fatturapa.util;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;

public interface XmlIOUtility<T> {

    JAXBContext jaxbContext();

    @SuppressWarnings("unchecked")
    default T loadObjectFrom(final File file) throws IOException {
        try {
            Object obj = jaxbContext().createUnmarshaller().unmarshal(file);
            return (T) JAXBIntrospector.getValue(obj);
        } catch (JAXBException e) {
            throw new IOException(format("Cannot load object from file '%s'", file.getAbsoluteFile()), e);
        }
    }

    default void saveObjectTo(final T object, final File file) throws IOException {
        try {
            jaxbContext().createMarshaller().marshal(object, file);
        } catch (JAXBException e) {
            throw new IOException(format("Cannot save object %s to file '%s'", object, file.getAbsoluteFile()), e);
        }
    }

}
