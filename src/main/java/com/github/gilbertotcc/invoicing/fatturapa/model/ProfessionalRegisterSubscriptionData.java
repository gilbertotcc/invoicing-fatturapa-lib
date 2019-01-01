package com.github.gilbertotcc.invoicing.fatturapa.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProfessionalRegisterSubscriptionData {

    private String professionalRegisterName;

    private String professionalRegisterProvinceCode;

    private String subscriptionNumber;

    private LocalDate subscriptionDate;
}
