package za.co.rendani.myworld.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import za.co.rendani.myworld.domain.ChargeError;
import za.co.rendani.myworld.domain.ChargeResponse;
import za.co.rendani.myworld.domain.ProcessPaymentRequest;
import za.co.rendani.myworld.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final WebClient yocoClient;

    @Autowired
    public PaymentServiceImpl(WebClient yocoClient) {
        this.yocoClient = yocoClient;
    }

    @Override
    public ChargeResponse processPayment(ProcessPaymentRequest request) {
        Mono<ClientResponse> exchange = yocoClient
                .post()
                .body(BodyInserters.fromFormData("token", request.getPaymentReferenceId())
                        .with("amountInCents", request.getAmountInCents().toString())
                        .with("currency", "ZAR"))
                .exchange();

        ClientResponse clientResponse = exchange.block();

        if (null == clientResponse) {
            throw new RuntimeException("Could not get response from Yoco.");
        }

        if (HttpStatus.CREATED.equals(clientResponse.statusCode())) {
            LOGGER.info("Payment successful.");
            ChargeResponse chargeResponse = clientResponse.bodyToMono(ChargeResponse.class).block();
            LOGGER.info(String.valueOf(chargeResponse));
            return chargeResponse;
        } else if (HttpStatus.BAD_REQUEST.equals(clientResponse.statusCode())) {
            LOGGER.warn("Card declined.");
            ChargeError chargeError = clientResponse.bodyToMono(ChargeError.class).block();
            LOGGER.warn(String.valueOf(chargeError));
            throw new RuntimeException("Card declined: " + chargeError.getErrorMessage());
        } else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(clientResponse.statusCode())) {
            LOGGER.warn("Error on payment gateway");
            ChargeError chargeError = clientResponse.bodyToMono(ChargeError.class).block();
            LOGGER.warn(String.valueOf(chargeError));
            throw new RuntimeException("Error on payment gateway: " + chargeError.getErrorMessage());
        }

        throw new RuntimeException("Unexpected response code from Payment Gateway.");
    }
}
