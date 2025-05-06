package com.victorxavier.modularmonolith.modules.payment.domain.gateway;

import java.math.BigDecimal;

public interface OrderGateway {
    BigDecimal getOrderTotalById(Long orderId);
}
