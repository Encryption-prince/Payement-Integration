package com.spring.implementation.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.razorpay.RazorpayException;
import com.spring.implementation.model.Orders;
import com.spring.implementation.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "Order API")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;

//	@GetMapping("/orders")
//	public String ordersPage() {
//		return "orders";
//	}
	
//	@PostMapping(value = "/createOrder", produces = "application/json")
//	public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) throws RazorpayException{
//		Orders razorpayOrder = orderService.createOrder(orders);
//		return new ResponseEntity<>(razorpayOrder,HttpStatus.CREATED);
//	}
//
//	@PostMapping("/paymentCallback")
//	public String paymentCallback(@RequestParam Map<String, String> response) {
//		 	orderService.updateStatus(response);
//		 	return "success";
//	}

	@PostMapping("/create")
	public ResponseEntity<Orders> createOrder(@RequestBody Orders order) throws RazorpayException {
		Orders createdOrder = orderService.createOrder(order);
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}

//	@PostMapping("/paymentCallback")
//	public ResponseEntity<Orders> updatePaymentStatus(@RequestBody Map<String, String> callbackData) {
//		Orders updatedOrder = orderService.updateStatus(callbackData);
//		return ResponseEntity.ok(updatedOrder);
//	}

//	@PostMapping("/paymentCallback")
//	public ResponseEntity<Map<String, String>> updatePaymentStatus(@RequestBody Map<String, String> callbackData) {
//		Orders updatedOrder = orderService.updateStatus(callbackData);
//
//		// Once the order is updated, you can provide the URL for the success page.
//		Map<String, String> response = new HashMap<>();
//		response.put("redirectUrl", "http://localhost:5173/payment-success");
//
//		return ResponseEntity.ok(response);
//	}
//@PostMapping("/paymentCallback")
//public void updatePaymentStatus(HttpServletResponse response, @RequestBody Map<String, String> callbackData) throws IOException {
//	Orders updatedOrder = orderService.updateStatus(callbackData);
//
//	// After updating the order, redirect to the success page
//	response.sendRedirect("http://localhost:5173/payment-success");
//}

	@PostMapping("/paymentCallback")
	public ResponseEntity<String> updatePaymentStatus(@RequestBody Map<String, String> callbackData) {
		Orders updatedOrder = orderService.updateStatus(callbackData);
		return ResponseEntity.ok("Payment status updated");
	}


}
