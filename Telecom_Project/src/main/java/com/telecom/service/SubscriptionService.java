package com.telecom.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import com.telecom.model.Subscription;

public interface SubscriptionService {
	
	
	public ResponseEntity<Object> deleteSubscription(int suscriptionId);
	
	public ResponseEntity<Object> activateSubscription(int subscriptionId);

}
