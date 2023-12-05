package com.business.card.appcapability;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class BusinessCardDataController {

	@Autowired
	private BusinessCardDataService businessCardDataService;

	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
	}

	@GetMapping("api/v0/cardData/getById/{id}")
	@ResponseBody
	public BusinessCardData getBusinessCardDataById(@PathVariable("id") String id) {
		return this.businessCardDataService.getBusinessCardDataById(id);
	}

	@GetMapping("api/v0/cardData/getByCardId/{cardId}")
	@ResponseBody
	public BusinessCardData getBusinessCardDataByCardId(@PathVariable("cardId") String cardId) {
		return this.businessCardDataService.getBusinessCardDataByCardId(cardId);
	}


	@GetMapping("api/v0/cardData/myDrafts")
	@ResponseBody
	public List<BusinessCardData> getBusinessCardDataForDrafts() {
		return this.businessCardDataService.getBusinessCardDatasDrafts();
	}

	@GetMapping("api/v0/cardData/myCards/{ownerId}")
	@ResponseBody
	public List<BusinessCardData> getBusinessCardDataForMyCards(@PathVariable("ownerId") String ownerId) {
		return this.businessCardDataService.getBusinessCardDatas(ownerId);
	}

	@PutMapping("api/v0/cardData/update/{id}")
	@ResponseBody
	public BusinessCardData updateBusinessCardData(@PathVariable("id") String id, @RequestBody BusinessCardData businessCardData) {
		return this.businessCardDataService.updateBusinessCardData(id,businessCardData);
	}

	@PostMapping("api/v0/cardData/add")
	@ResponseBody
	public BusinessCardData addBusinessCardData(@RequestBody BusinessCardData businessCardData) {
		return this.businessCardDataService.addBusinessCardData(businessCardData);
	}

	@PostMapping("api/v0/cardData/addToDrafts")
	@ResponseBody
	public BusinessCardData draftBusinessCardData(@RequestBody BusinessCardData businessCardData) {
		return this.businessCardDataService.draftBusinessCardData(businessCardData);
	}

	@PutMapping("api/v0/cardData/delete/{id}")
	@ResponseBody
	public BusinessCardData deleteBusinessCardDataById(@PathVariable("id") String id) {
		return this.businessCardDataService.deleteBusinessCardDataById(id);
	}
	
}
