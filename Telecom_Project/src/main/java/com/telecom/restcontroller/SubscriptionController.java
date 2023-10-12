package com.telecom.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.Subscription;
import com.telecom.service.SubscriptionService;

@RestController
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSubscription(@PathVariable("id") int id) {

		ResponseEntity<Object> responseEntity = subscriptionService.deleteSubscription(id);

		return responseEntity;
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> getActivateSubscription(@PathVariable("id") Integer id) {

		ResponseEntity<Object> response = subscriptionService.activateSubscription(id);

		return response;
	}

}
