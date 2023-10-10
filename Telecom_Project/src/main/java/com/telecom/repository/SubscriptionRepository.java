package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {

}
