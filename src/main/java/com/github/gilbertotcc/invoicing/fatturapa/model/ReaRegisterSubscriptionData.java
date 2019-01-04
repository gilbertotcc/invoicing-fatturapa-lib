package com.github.gilbertotcc.invoicing.fatturapa.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReaRegisterSubscriptionData {

    private String reaRegisterProvinceCode;

    private String subscriptionNumber;

    private BigDecimal shareCapital; // FIXME Default EUR. Is REA used only for Italian businesses?

    private boolean singlePartnerBusiness;

    private boolean inLiquidationBusiness;

}
