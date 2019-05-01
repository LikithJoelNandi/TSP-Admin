package com.dell.tsp.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dell.tsp.admin.DTO.OfferDTO;
import com.dell.tsp.admin.DTO.ServiceDTO;
import com.dell.tsp.admin.DTO.ServiceGroupDTO;
import com.dell.tsp.admin.entity.OfferEntity;
import com.dell.tsp.admin.entity.ServiceEntity;
import com.dell.tsp.admin.entity.ServiceGroupEntity;
import com.dell.tsp.admin.entity.SubscriberEntity;
import com.dell.tsp.admin.model.Subscriber;
import com.dell.tsp.admin.repository.AdminRepository;
import com.dell.tsp.admin.repository.OfferRepository;
import com.dell.tsp.admin.repository.ServiceGroupRepository;
import com.dell.tsp.admin.repository.ServiceRepository;
import com.dell.tsp.admin.repository.SubscriberRepository;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	private static Logger LOG = LoggerFactory.getLogger(SubscriberServiceImpl.class);
	
	private SubscriberRepository subscriberRepository;
	private SubscriberEntity subscriberEntity;
	
	EntityManager entityManager;
	
//	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@Autowired
	Transction transction;
	
//	@Autowired
	AdminRepository adminRepository;
	
//	@Autowired
	OfferRepository offerRepository;
	
//	@Autowired
	ServiceRepository serviceRepository;
	
//	@Autowired
	ServiceGroupRepository serviceGroupRepository;

//	@Autowired
	public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
		this.subscriberRepository = subscriberRepository;
	}

	@Autowired


	public ArrayList<SubscriberEntity> getAllSubscribers() {
		return (ArrayList<SubscriberEntity>) subscriberRepository.findAll();
	}

	@Autowired
	public SubscriberServiceImpl(SubscriberRepository subscriberRepository,
			EntityManager entityManager, JdbcTemplate jdbcTemplate, Transction transction,
			AdminRepository adminRepository, OfferRepository offerRepository, ServiceRepository serviceRepository,
			ServiceGroupRepository serviceGroupRepository) {
		super();
		this.subscriberRepository = subscriberRepository;
		this.entityManager = entityManager;
		this.jdbcTemplate = jdbcTemplate;
		this.transction = transction;
		this.adminRepository = adminRepository;
		this.offerRepository = offerRepository;
		this.serviceRepository = serviceRepository;
		this.serviceGroupRepository = serviceGroupRepository;
	}
	
	public SubscriberServiceImpl() {}

	public void verifySubscriber(Subscriber subscriber) {
		
	}

	public SubscriberEntity enrollSubscriber(Subscriber subscriber) {	
		return subscriberRepository.save(convertToSubscriberEntity(subscriber));
	}
	public SubscriberEntity convertToSubscriberEntity(Subscriber subscriber) {
		subscriberEntity = new SubscriberEntity();
		subscriberEntity.setFirstName(subscriber.getFirstName());
		subscriberEntity.setLastName(subscriber.getLastName());
		subscriberEntity.setMobileNo(subscriber.getMobileNo());
		subscriberEntity.setEmail(subscriber.getEmail());
		subscriberEntity.setAddress(subscriber.getAddress());
		subscriberEntity.setAdharNo(subscriber.getAdharNo());
		return subscriberEntity;
	}

	public SubscriberEntity getSubscriber(long mobileNo) {	
		 return subscriberRepository.findByMobileNo(mobileNo);
		
	}
	public void addOfferData(ArrayList<OfferDTO> offerList) {		
		for(OfferDTO offer : offerList) {
			offerRepository.save(new OfferEntity(offer.getOfferId(), offer.getOfferName(), 
					offer.getValidityInDays(), offer.getServiceGroupId(), offer.getPrice()));
		}
	}

	public ServiceEntity addServiceData(ServiceDTO serviceDTO) {
			return serviceRepository.save(new ServiceEntity(serviceDTO.getServiceId(),
					serviceDTO.getServiceName(), serviceDTO.getServiceDesc()));		
	}

	public void addServiceGroupData(ArrayList<ServiceGroupDTO> serviceGroupList) {
		for(ServiceGroupDTO service : serviceGroupList) {
			serviceGroupRepository.save(new ServiceGroupEntity(service.getServiceGroupId(),
					service.getServices()));
		}
	}

	public OfferEntity createSingleOffer(OfferDTO offer) {
		return offerRepository.save(new OfferEntity(offer.getOfferId(), offer.getOfferName(), 
				offer.getValidityInDays(), offer.getServiceGroupId(), offer.getPrice()));
	}

	public OfferEntity modifySingleOffer(OfferDTO offer) {
		return offerRepository.save(new OfferEntity(offer.getOfferId(), offer.getOfferName(), 
				offer.getValidityInDays(), offer.getServiceGroupId(), offer.getPrice()));
	}

	public boolean deleteSingleOffer(OfferDTO offer) {
		try {
			offerRepository.delete(new OfferEntity(offer.getOfferId(), offer.getOfferName(), 
					offer.getValidityInDays(), offer.getServiceGroupId(), offer.getPrice())) ;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ServiceEntity modifyService(ServiceDTO serviceDTO) {
		try {
			return serviceRepository.save(new ServiceEntity(serviceDTO.getServiceId(),
					serviceDTO.getServiceName(), serviceDTO.getServiceDesc()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteService(ServiceDTO serviceDTO) {
		try {
			serviceRepository.delete(new ServiceEntity(serviceDTO.getServiceId(),
					serviceDTO.getServiceName(), serviceDTO.getServiceDesc()));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ServiceGroupEntity addServiceGroup(ServiceGroupDTO serviceGroupDTO) {
		return serviceGroupRepository.save(new ServiceGroupEntity(serviceGroupDTO.getServiceGroupId(), serviceGroupDTO.getServices()));
	}

	
}


