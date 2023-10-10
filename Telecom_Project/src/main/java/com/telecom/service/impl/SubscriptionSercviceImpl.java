package com.telecom.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.telecom.model.Subscription;
import com.telecom.repository.SubscriptionRepository;
import com.telecom.service.SubscriptionService;

@Service
public class SubscriptionSercviceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public void deleteSubscription(int suscriptionId) {

		subscriptionRepository.deleteById(suscriptionId);
		// TODO Auto-generated method stub

	}

	@Override
	public Subscription activateSubscription(int suscriptionId) {

		Optional<Subscription> optional = subscriptionRepository.findById(suscriptionId);

		if (optional.isPresent()) {

			Subscription subscription = optional.get();

			subscription.setActive(true);

			Subscription subscription2 = subscriptionRepository.save(subscription);

			return subscription2;

		}

		else {

			return null;
		}

	}

}
