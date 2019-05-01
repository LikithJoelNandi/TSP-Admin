package com.dell.tsp.admin.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.dell.tsp.admin.DTO.OfferDTO;
import com.dell.tsp.admin.DTO.ServiceDTO;
import com.dell.tsp.admin.DTO.ServiceGroupDTO;
import com.dell.tsp.admin.entity.OfferEntity;
import com.dell.tsp.admin.entity.ServiceEntity;
import com.dell.tsp.admin.entity.ServiceGroupEntity;
import com.dell.tsp.admin.entity.SubscriberEntity;
import com.dell.tsp.admin.model.Subscriber;

import antlr.collections.List;

public interface SubscriberService {
	public ArrayList<SubscriberEntity> getAllSubscribers();

	public void verifySubscriber(Subscriber subscriber);

	public SubscriberEntity enrollSubscriber(Subscriber subscriber);

	public SubscriberEntity getSubscriber(long mobileNo);

		public void addOfferData(ArrayList<OfferDTO> offerList);

	public ServiceEntity addServiceData(ServiceDTO serviceDTO);
 void addServiceGroupData(ArrayList<ServiceGroupDTO> serviceGroupList);

	public OfferEntity createSingleOffer(OfferDTO offer);

	public OfferEntity modifySingleOffer(OfferDTO offer);

	public boolean deleteSingleOffer(OfferDTO offer);

	public ServiceEntity modifyService(ServiceDTO serviceDTO); 

	public boolean deleteService(ServiceDTO serviceDTO);

	public ServiceGroupEntity addServiceGroup(ServiceGroupDTO serviceGroupDTO); 
}
