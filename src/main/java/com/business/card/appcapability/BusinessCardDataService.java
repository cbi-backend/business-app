package com.business.card.appcapability;

import java.text.Collator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class BusinessCardDataService {
	
	@Autowired
	private BusinessCardDataRepository businessCardDataRepository;

	private static final String SAVED = "SAVED";	
	private static final String DELETED = "DELETED";
	private static final String DRAFTED = "DRAFTED";

	
	public BusinessCardData getBusinessCardDataById(String id) {
		if (this.businessCardDataRepository.existsById(id)) {
			Optional<BusinessCardData> dataById = this.businessCardDataRepository.findById(id);
			if (dataById != null && dataById.get() != null &&
					! dataById.get().getStatus().equals(DELETED)) {
				return dataById.get();
			}
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}

	public BusinessCardData getBusinessCardDataByCardId(String cardId) {
		BusinessCardData dataByCardId = this.businessCardDataRepository.findByCardId(cardId);
		if (dataByCardId != null && dataByCardId.getStatus() != null &&
				! dataByCardId.getStatus().equals(DELETED)) {
			return dataByCardId;
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}

	public List<BusinessCardData> getBusinessCardDatas(String ownerId) {
		List<BusinessCardData> finalData = this.businessCardDataRepository.getByOwnerIdAndStaus(ownerId, SAVED);
		return finalData;
	}
	
	public List<BusinessCardData> getBusinessCardDatasDrafts() {
		List<BusinessCardData> finalData = this.businessCardDataRepository.findAll().stream()
		.filter(arg0 -> arg0.getStatus().equals(DRAFTED)).collect(Collectors.toList());
		return finalData;
	}

	public BusinessCardData updateBusinessCardData(String id, BusinessCardData businessCardData) {
		if (this.businessCardDataRepository.existsById(id)) {
			Optional<BusinessCardData> dataById = this.businessCardDataRepository.findById(id);
			if (dataById != null && dataById.get() != null ) {
				BusinessCardData tobeUpdatedBusinessCardData = prepareDataForUpdation(businessCardData, dataById.get());
				return this.businessCardDataRepository.save(tobeUpdatedBusinessCardData);
			}
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}
	
	private BusinessCardData prepareDataForUpdation(BusinessCardData businessCardData,
			BusinessCardData oldBusinessCardData) {
		if (! CollectionUtils.isEmpty(businessCardData.getElements())) {
			oldBusinessCardData.setElements(businessCardData.getElements());
		}
		if (businessCardData.getPrimary_color() != null) {
			oldBusinessCardData.setPrimary_color(businessCardData.getPrimary_color());
		}
		if (businessCardData.getSecondary_color() != null) {
			oldBusinessCardData.setSecondary_color(businessCardData.getSecondary_color());
		}
		if (businessCardData.getAcent_color() != null) {
			oldBusinessCardData.setAcent_color(businessCardData.getAcent_color());
		}
		if (businessCardData.getColor() != null) {
			oldBusinessCardData.setColor(businessCardData.getColor());
		}
		if (businessCardData.getRaw_conetent() != null) {
			oldBusinessCardData.setRaw_conetent(businessCardData.getRaw_conetent());
		}
		if (businessCardData.getDesign_specific() != null) {
			oldBusinessCardData.setDesign_specific(businessCardData.getDesign_specific());
		}
		if (businessCardData.getType() != null) {
			oldBusinessCardData.setType(businessCardData.getType());
		}
		oldBusinessCardData.setLast_updated_date(new Date(System.currentTimeMillis()));
		// TODO: remove the hard coded value REST API for Last_updated_by_id
		if (businessCardData.getLast_updated_by_id() != null) {
			oldBusinessCardData.setLast_updated_by_id(businessCardData.getLast_updated_by_id());
		}
		oldBusinessCardData.setLast_updated_by_id("REST API");
		return oldBusinessCardData;
	}

	public BusinessCardData addBusinessCardData(BusinessCardData businessCardData) {
		prepareDataForCreation(businessCardData, SAVED);
		return this.businessCardDataRepository.save(businessCardData);
	}
	
	public BusinessCardData draftBusinessCardData(BusinessCardData businessCardData) {
		prepareDataForCreation(businessCardData, DRAFTED);
		return this.businessCardDataRepository.save(businessCardData);
	}
	
	private void prepareDataForCreation(BusinessCardData businessCardData, String status) {
		businessCardData.setId(null);
		businessCardData.setLast_updated_by_id("Back end");
		businessCardData.setStatus(status);
		businessCardData.setCard_id("BUSINESS_CARD_APP_CARD_" + System.currentTimeMillis());
		businessCardData.setAdded_date(new Date(System.currentTimeMillis()));
		businessCardData.setLast_updated_date(new Date(System.currentTimeMillis()));
	}

	public BusinessCardData deleteBusinessCardDataById(String id) {
		if (this.businessCardDataRepository.existsById(id)) {
			Optional<BusinessCardData> dataById = this.businessCardDataRepository.findById(id);
			if (dataById != null && dataById.get() != null &&
					! dataById.get().getStatus().equals(DELETED) ) {
				BusinessCardData businessCardDataToBeUpdated = dataById.get();
				businessCardDataToBeUpdated.setStatus(DELETED);
				return this.businessCardDataRepository.save(businessCardDataToBeUpdated);
			}
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}
	
	
}
