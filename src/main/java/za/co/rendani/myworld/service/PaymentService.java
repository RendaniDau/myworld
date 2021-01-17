package za.co.rendani.myworld.service;

import za.co.rendani.myworld.domain.ChargeResponse;
import za.co.rendani.myworld.domain.ProcessPaymentRequest;

public interface PaymentService {
    ChargeResponse processPayment(ProcessPaymentRequest request);

}
