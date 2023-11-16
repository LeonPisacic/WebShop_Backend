package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data
// using this class to send back Java object as JSON
public class PurchaseResponse {

    private final String orderTrackingNumber;

}
