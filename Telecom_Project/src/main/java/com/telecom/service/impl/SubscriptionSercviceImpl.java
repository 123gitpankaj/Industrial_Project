package com.telecom.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telecom.model.Subscription;
import com.telecom.repository.SubscriptionRepository;
import com.telecom.service.SubscriptionService;

@Service
public class SubscriptionSercviceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public ResponseEntity<Object> deleteSubscription(int suscriptionId) {

		Optional<Subscription> data = subscriptionRepository.findById(suscriptionId);

		if (data.isPresent()) {

			subscriptionRepository.deleteById(suscriptionId);

			return ResponseEntity.noContent().build();

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");

		}

	}

	@Override
	public ResponseEntity<Object> activateSubscription(int subscriptionId) {

		Optional<Subscription> userOptional = subscriptionRepository.findById(subscriptionId);

		if (userOptional.isPresent()) {

			Subscription user = userOptional.get();

			if (user.isActive()) {

				return ResponseEntity.badRequest().body("Subscription is already activated");

			}

			else {

				user.setActive(true);

				subscriptionRepository.save(user);

				return ResponseEntity.ok("Subscription activated successfully");

			}

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is not found");

		}

	}

}
