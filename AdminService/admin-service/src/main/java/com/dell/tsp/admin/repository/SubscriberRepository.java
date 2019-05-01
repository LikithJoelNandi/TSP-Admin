package com.dell.tsp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.tsp.admin.entity.SubscriberEntity;
import com.dell.tsp.admin.model.Subscriber;


@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long>{
	SubscriberEntity findByMobileNo( long mobileNo);
}
