package za.co.rendani.myworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.rendani.myworld.domain.ChargeResponse;
import za.co.rendani.myworld.domain.ProcessPaymentRequest;
import za.co.rendani.myworld.service.PaymentService;

@Controller
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public String homePage(Model model) {
        return "test-payment";
    }

    @PostMapping("/payment")
    @ResponseBody
    public ChargeResponse processPayment(@RequestBody ProcessPaymentRequest request) {
        return paymentService.processPayment(request);
    }
}
