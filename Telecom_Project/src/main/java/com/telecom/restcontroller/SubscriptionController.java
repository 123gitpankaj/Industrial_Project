package com.telecom.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
	public void deleteSubscription(@PathVariable("id") int id) {

		subscriptionService.deleteSubscription(id);

	}
	
	
	@PutMapping("/activate/{id}")
	public Subscription activateSubscription(@PathVariable("id") int id) {
		
		 Subscription subscription = subscriptionService.activateSubscription(id);
		
		return subscription;
	}


}
