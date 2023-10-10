package com.telecom.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.telecom.model.Subscription;

public interface SubscriptionService {
	
	
	public void deleteSubscription(int suscriptionId);
	
	
	public Subscription activateSubscription(int suscriptionId) ;

}
