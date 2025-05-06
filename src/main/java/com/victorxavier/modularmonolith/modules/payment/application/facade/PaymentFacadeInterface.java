package com.victorxavier.modularmonolith.modules.payment.application.facade;

import com.victorxavier.modularmonolith.modules.payment.application.facade.dto.PaymentFacadeInputDto;
import com.victorxavier.modularmonolith.modules.payment.application.facade.dto.PaymentFacadeOutputDto;

public interface PaymentFacadeInterface {
    PaymentFacadeOutputDto process(PaymentFacadeInputDto input);
}
