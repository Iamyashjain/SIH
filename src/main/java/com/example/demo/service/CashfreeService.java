package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class CashfreeService {

    @Value("${cashfree.app.id}")
    private String appId;

    @Value("${cashfree.secret.key}")
    private String secretKey;

    @Value("${cashfree.environment}")
    private String environment;

    @Value("${cashfree.return.url}")
    private String returnUrl;

    @Value("${cashfree.notify.url}")
    private String notifyUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String createorderdirectly(Booking b, User U)
    {
        SecureRandom random = new SecureRandom();

        // Generate a random number and convert it to a string
        int randomValue = random.nextInt(999999);

        // Concatenate the fields and the random value
        String orderId = b.getBid() + b.getMid() + U.getUid() + String.format("%06d", randomValue);
        String url = environment.equals("TEST")
                ? "https://sandbox.cashfree.com/pg/orders"
                : "https://api.cashfree.com/pg/orders";

        // Construct the request payload
        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("order_id", orderId);
        requestPayload.put("order_amount",  b.getPayment_amount()); // Ensure two decimal places
        requestPayload.put("order_currency", "INR");

        Map<String, String> customerDetails = new HashMap<>();
        customerDetails.put("customer_id", "User1234"); // This can be dynamic if needed
        customerDetails.put("customer_name", U.getName());
        customerDetails.put("customer_email", U.getEmail());
        customerDetails.put("customer_phone", U.getMobile()+"");

        requestPayload.put("customer_details", customerDetails);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("content-type", "application/json");
        headers.set("x-api-version", "2023-08-01");
        headers.set("x-client-id", appId);
        headers.set("x-client-secret", secretKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestPayload, headers);

        // Call the Cashfree API and return the response (this will include the payment link)
        try {
            // Send the request and get the response as a String
            String response = restTemplate.postForObject(url, entity, String.class);
            System.out.println(response);
            // Parse the response JSON to a Map
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

            // Extract the payment_session_id
            String paymentSessionId = (String) responseMap.get("payment_session_id");

            // Return the payment session ID
            return paymentSessionId;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    // Method to create an order
    public String createOrder(String orderId, double amount, String customerName, String customerEmail, String customerPhone) {
        String url = environment.equals("TEST")
                ? "https://sandbox.cashfree.com/pg/orders"
                : "https://api.cashfree.com/pg/orders";

        // Construct the request payload
        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("order_id", orderId);
        requestPayload.put("order_amount", String.format("%.2f", amount)); // Ensure two decimal places
        requestPayload.put("order_currency", "INR");

        Map<String, String> customerDetails = new HashMap<>();
        customerDetails.put("customer_id", "User1234"); // This can be dynamic if needed
        customerDetails.put("customer_name", customerName);
        customerDetails.put("customer_email", customerEmail);
        customerDetails.put("customer_phone", customerPhone);

        requestPayload.put("customer_details", customerDetails);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("content-type", "application/json");
        headers.set("x-api-version", "2023-08-01");
        headers.set("x-client-id", appId);
        headers.set("x-client-secret", secretKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestPayload, headers);

        // Call the Cashfree API and return the response (this will include the payment link)



            try {
                // Send the request and get the response as a String
                String response = restTemplate.postForObject(url, entity, String.class);
                System.out.println(response);
                // Parse the response JSON to a Map
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);

                // Extract the payment_session_id
                String paymentSessionId = (String) responseMap.get("payment_session_id");

                // Return the payment session ID
                return paymentSessionId;

            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }



    // Method to check the status of an order
    public String checkOrderStatus(String orderId) {
        String url = environment.equals("TEST")
                ? "https://sandbox.cashfree.com/pg/orders/" + orderId
                : "https://api.cashfree.com/pg/orders/" + orderId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("x-api-version", "2023-08-01");
        headers.set("x-client-id", appId);
        headers.set("x-client-secret", secretKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Call the Cashfree API and return the response
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public void createOrder() {
    }
}
