package com.luv2code.ecommerce.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.ecommerce.dto.PaymentInfo;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

// comments
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    // comments
    private Logger logger = Logger.getLogger(getClass().getName());

    private CheckoutService checkoutService;

    // comments
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase") // handling purchase request, storing all information to the database
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

    // comments
    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {

        logger.info("paymentinfo.amount " + paymentInfo.getAmount());

        // comments
        PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);

        String paymentString = paymentIntent.toJson();

        // comments
        return new ResponseEntity<>(paymentString, HttpStatus.OK);
    }

}
