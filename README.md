# FatturaPA library

_FatturaPA_ library is a Java library that provides methods to load, create, and save electronic invoices which fulfil the _FatturaPA_ format,
the Italian standard for electronically invoicing (a.k.a. _Fatturazione elettronica_).

Below, the main purposes this library aim at.

- Design a clean and concise model to represents invoices, while ensuring compatibility with at least one version of FatturaPA format.
- Provide methods for loading/storing invoices from/to file in FatturaPA format.
- Support non-Italian readers in working with Italian electronically invoicing (at least the invoice model). Indeed existing documentation might not
  suffice.

More information about electronically invoicing and the FatturaPA format can be found at
[FatturaPA documentation](https://www.fatturapa.gov.it/export/fatturazione/en/normativa/f-2.htm?l=en).

## Usage

_TODO ...._

## FatturaPA supported format

The library supports version 1.2.1 of FatturaPA format.

In order to automatically generate Java code from XML Schema definition of FatturaPA document, I had to fix a typo in
[Schema_del_file_xml_FatturaPA_versione_1.2.1.xsd](https://www.fatturapa.gov.it/export/fatturazione/sdi/fatturapa/v1.2.1/Schema_del_file_xml_FatturaPA_versione_1.2.1.xsd)
with the following patch:

```diff
--- FatturaPA_versione_1.2.1.xsd.orig	2018-12-29 11:27:04.000000000 +0100
+++ FatturaPA_versione_1.2.1.xsd	2018-12-29 11:28:12.000000000 +0100
@@ -4,7 +4,7 @@
 	xmlns="http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2"
 	targetNamespace="http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2"
 	version="1.2">
-  <xsd:import namespace="http://www.w3.org/2000/09/xmldsig#" schemaLocation="http://www.w3.org/TR/2002/REC-xmldsig-core-20020212/xmldsig-core-schema.xsd"/>
+  <xs:import namespace="http://www.w3.org/2000/09/xmldsig#" schemaLocation="http://www.w3.org/TR/2002/REC-xmldsig-core-20020212/xmldsig-core-schema.xsd"/>

   <xs:element name="FatturaElettronica" type="FatturaElettronicaType">
     <xs:annotation>
```

Unfortunately, technical documentation for FatturaPA version 1.2.1 is in Italian language only. If you are an Italian reader you can find it at
[Specifiche tecniche del formato della FatturaPA versione 1.2.1](https://www.fatturapa.gov.it/export/fatturazione/sdi/Specifiche_tecniche_del_formato_FatturaPA_v1.2.1.pdf).

English documentation is available for FatturaPA version 1.1 at
[Technical specifications of the invoice format version 1.1](https://www.fatturapa.gov.it/export/fatturazione/sdi/Specifiche_tecniche_del_formato_FatturaPA_v1.1_EN.pdf).
Version 1.2.1 added some new fields and updated some types as described in
[Elenco modifiche al tracciato FatturaPA](https://www.fatturapa.gov.it/export/fatturazione/sdi/fatturapa/v1.2/changelog_formato.pdf) (in IT language
only).

