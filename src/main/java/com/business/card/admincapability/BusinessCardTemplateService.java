package com.business.card.admincapability;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class BusinessCardTemplateService {
	
	@Autowired
	private BusinessCardTemplateRepository businessCardTemplateRepository;
	
	public BusinessCardTemplate getBusinessCardTemplateById(String id) {
		if (this.businessCardTemplateRepository.existsById(id)) {
			Optional<BusinessCardTemplate> templateById = this.businessCardTemplateRepository.findById(id);
			if (templateById != null &&
					templateById.get() != null &&
					! templateById.get().getStatus().equals("DELETED")) {
				return templateById.get();
			}
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}

	public List<BusinessCardTemplate> getBusinessCardTemplates() {
		List<BusinessCardTemplate> finalData = this.businessCardTemplateRepository.findAll().stream()
		.filter(arg0 -> !arg0.getStatus().equals("DELETED")).collect(Collectors.toList());
		return finalData;
	}
	
	public BusinessCardTemplate updateBusinessCardTemplate(String id, BusinessCardTemplate businessCardTemplate) {
		if (this.businessCardTemplateRepository.existsById(id)) {
			Optional<BusinessCardTemplate> templateById = this.businessCardTemplateRepository.findById(id);
			if (templateById != null &&
					templateById.get() != null ) {
				BusinessCardTemplate tobeUpdatedBusinessCardTemplate = prepareDataForUpdation(businessCardTemplate, templateById.get());
				return this.businessCardTemplateRepository.save(tobeUpdatedBusinessCardTemplate);
			}
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}
	
	private BusinessCardTemplate prepareDataForUpdation(BusinessCardTemplate businessCardTemplate,
			BusinessCardTemplate oldBusinessCardTemplate) {
		if (! CollectionUtils.isEmpty(businessCardTemplate.getElements())) {
			oldBusinessCardTemplate.setElements(businessCardTemplate.getElements());
		}
		if (businessCardTemplate.getPrimary_color() != null) {
			oldBusinessCardTemplate.setPrimary_color(businessCardTemplate.getPrimary_color());
		}
		if (businessCardTemplate.getSecondary_color() != null) {
			oldBusinessCardTemplate.setSecondary_color(businessCardTemplate.getSecondary_color());
		}
		if (businessCardTemplate.getAcent_color() != null) {
			oldBusinessCardTemplate.setAcent_color(businessCardTemplate.getAcent_color());
		}
		if (businessCardTemplate.getColor() != null) {
			oldBusinessCardTemplate.setColor(businessCardTemplate.getColor());
		}
		if (businessCardTemplate.getRaw_conetent() != null) {
			oldBusinessCardTemplate.setRaw_conetent(businessCardTemplate.getRaw_conetent());
		}
		if (businessCardTemplate.getDesign_specific() != null) {
			oldBusinessCardTemplate.setDesign_specific(businessCardTemplate.getDesign_specific());
		}
		if (businessCardTemplate.getType() != null) {
			oldBusinessCardTemplate.setType(businessCardTemplate.getType());
		}
		oldBusinessCardTemplate.setLast_updated_date(new Date(System.currentTimeMillis()));
		// TODO: remove the hard coded value REST API for Last_updated_by_id
		if (businessCardTemplate.getLast_updated_by_id() != null) {
			oldBusinessCardTemplate.setLast_updated_by_id(businessCardTemplate.getLast_updated_by_id());
		}
		oldBusinessCardTemplate.setLast_updated_by_id("REST API");
		return oldBusinessCardTemplate;
	}

	public BusinessCardTemplate addBusinessCardTemplate(BusinessCardTemplate businessCardTemplate) {
		prepareDataForCreation(businessCardTemplate);
		return this.businessCardTemplateRepository.save(businessCardTemplate);
	}
	
	private void prepareDataForCreation(BusinessCardTemplate businessCardTemplate) {
		businessCardTemplate.setId(null);
		businessCardTemplate.setLast_updated_by_id("Back end");
		businessCardTemplate.setOwner_id("REST API");
		businessCardTemplate.setStatus("CREATED");
		businessCardTemplate.setTemplate_id("BUSINESS_CARD_APP_TEMPLATE_" + System.currentTimeMillis());
		businessCardTemplate.setAdded_date(new Date(System.currentTimeMillis()));
		businessCardTemplate.setLast_updated_date(new Date(System.currentTimeMillis()));
	}

	public BusinessCardTemplate deleteBusinessCardTemplateById(String id) {
		if (this.businessCardTemplateRepository.existsById(id)) {
			Optional<BusinessCardTemplate> templateById = this.businessCardTemplateRepository.findById(id);
			if (templateById != null &&
					templateById.get() != null &&
					! templateById.get().getStatus().equals("DELETED") ) {
				BusinessCardTemplate businessCardTemplateToBeUpdated = templateById.get();
				businessCardTemplateToBeUpdated.setStatus("DELETED");
				return this.businessCardTemplateRepository.save(businessCardTemplateToBeUpdated);
			}
		}
		throw new RuntimeException("Invalid action",
			new Throwable("data not found"));
	}
	
	
}
