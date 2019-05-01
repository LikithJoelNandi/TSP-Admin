package com.dell.tsp.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dell.tsp.admin.DTO.AdminDTO;
import com.dell.tsp.admin.DTO.OfferDTO;
import com.dell.tsp.admin.DTO.ServiceDTO;
import com.dell.tsp.admin.DTO.ServiceGroupDTO;
import com.dell.tsp.admin.entity.OfferEntity;
import com.dell.tsp.admin.entity.ServiceEntity;
import com.dell.tsp.admin.entity.ServiceGroupEntity;
import com.dell.tsp.admin.entity.SubscriberEntity;
import com.dell.tsp.admin.model.Subscriber;
import com.dell.tsp.admin.service.CustomMessage;
import com.dell.tsp.admin.service.CustomMessageSender;
import com.dell.tsp.admin.service.LoginService;
import com.dell.tsp.admin.service.SubscriberService;

@RestController
@RequestMapping({ "/" })
@CrossOrigin(origins = "http://localhost:4200")
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;
	private static Logger LOG = LoggerFactory.getLogger(SampleController.class);

	/*
	 * @Autowired public SubscriberController(SubscriberServiceImpl
	 * subscriberService) { super(); this.subscriberService = subscriberService; }
	 */

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomMessageSender customMessageSender;
	
	@Autowired
	private CustomMessage customMessage;

	@RequestMapping(path = "/v1/signin", method = RequestMethod.POST)
	public String signIn(@RequestBody AdminDTO subscriber) {
		return loginService.getLoginDetails(subscriber.getUserName(), subscriber.getPassWord());
	}

	@GetMapping("/v1/subscribers")
	public ResponseEntity<List<SubscriberEntity>> getAllSubscriber() {
		return ResponseEntity.ok().body(subscriberService.getAllSubscribers());
	}

	@GetMapping("/v1/subscriber")
	public ResponseEntity<SubscriberEntity> getSubscriber(@RequestParam long mobileNo) {
		SubscriberEntity subscriberEntity = subscriberService.getSubscriber(mobileNo);		
		 LOG.info("\n subscriber:                                    ************\n"+subscriberEntity);
		return subscriberEntity==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(subscriberService.getSubscriber(mobileNo));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/v1/enroll", method = RequestMethod.POST)
	public ResponseEntity<SubscriberEntity> enrollSubscriber(@RequestBody Subscriber subscriber) {
		SubscriberEntity subscriberEntity = subscriberService.enrollSubscriber(subscriber);
		LOG.info("Subscriber Mobile Number: " , subscriber.getMobileNo());
		customMessage.setBy("vaishnavidavuluri7@gmail.com");
		customMessage.setFrom("vaishnavidavuluri7@gmail.com");
		customMessage.setTo(subscriber.getEmail());
		customMessage.setSubject("Subscriber "+subscriber.getFirstName()+" "+subscriber.getLastName()+" with subscriber id: " +subscriber.getSubscriberId()+" is Enrolled Successfully");
		customMessage.setBody("Subscriber "+subscriber.getFirstName()+" "+subscriber.getLastName()+" got enrolled successfully.");
		customMessage.setSubscriberId(subscriber.getSubscriberId());
		customMessage.setDate(new Date().toString());
		sendMessage(customMessage);
		return subscriberEntity==null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(subscriberEntity);
	}

	@RequestMapping(path = "/v1/Offers", method = RequestMethod.POST)
	public String createOffers(@RequestBody ArrayList<OfferDTO> offerList) {
		subscriberService.addOfferData(offerList);
		return "Offer created successfully ";
	}

	@RequestMapping(path = "/v1/offer", method = RequestMethod.POST)
	public ResponseEntity<OfferEntity> createSingleOffer(@RequestBody OfferDTO offer) {
		OfferEntity offerEntity = subscriberService.createSingleOffer(offer);
		return offerEntity==null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(offerEntity);
	}

	@RequestMapping(path = "/v1/offer", method = RequestMethod.PUT)
	public ResponseEntity<OfferEntity> modifySingleOffer(@RequestBody OfferDTO offer) {
		OfferEntity offerEntity = subscriberService.modifySingleOffer(offer);
		return offerEntity==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(offerEntity);
	}
	

	@RequestMapping(path = "/v1/offer", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteSingleOffer(@RequestBody OfferDTO offer) {
		if(subscriberService.deleteSingleOffer(offer)) {
			return ResponseEntity.ok("Offer is deleted successfully");
		}
		else
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(path = "/v1/service", method = RequestMethod.POST)
	public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceDTO serviceDTO) {
		ServiceEntity serviceEntity = subscriberService.addServiceData(serviceDTO);
		return serviceEntity==null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(serviceEntity);
	}
	
	@RequestMapping(path = "/v1/service", method = RequestMethod.PUT)
	public ResponseEntity<ServiceEntity> modifyService(@RequestBody ServiceDTO serviceDTO) {		
		ServiceEntity serviceEntity = subscriberService.modifyService(serviceDTO);
		return serviceEntity==null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(serviceEntity);
	}
	
	@RequestMapping(path = "/v1/service", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteService(@RequestBody ServiceDTO serviceDTO) {		
		if(subscriberService.deleteService(serviceDTO)) {
			return ResponseEntity.ok("Service is deleted successfully");
		}
		else
			return ResponseEntity.notFound().build();
	}


	@RequestMapping(path = "/v1/service-group-id", method = RequestMethod.POST)
	public String createServiceGroupId(@RequestBody ArrayList<ServiceGroupDTO> serviceGroupList) {
		subscriberService.addServiceGroupData(serviceGroupList);
		return "Service group created";
	}
	
	@RequestMapping(path = "/v1/service-group", method = RequestMethod.POST)
	public ResponseEntity<ServiceGroupEntity> createServiceGroup(@RequestBody ServiceGroupDTO serviceGroupDTO) {
		ServiceGroupEntity serviceGroupEntity = subscriberService.addServiceGroup(serviceGroupDTO);
		return serviceGroupEntity==null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(serviceGroupEntity);
	}
	
	@RequestMapping(path = "/v1/service-group", method = RequestMethod.PUT)
	public ResponseEntity<ServiceGroupEntity> modifyServiceGroup(@RequestBody ServiceGroupDTO serviceGroupDTO) {
		ServiceGroupEntity serviceGroupEntity = subscriberService.addServiceGroup(serviceGroupDTO);
		return serviceGroupEntity==null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(serviceGroupEntity);
	}
	
	
	@RequestMapping(path = "/v1/message", method = RequestMethod.POST)
	public String sendMessage(@RequestBody CustomMessage message) {
		customMessageSender.sendMessage(message);
		return "Successfully sent message";
	}

}
