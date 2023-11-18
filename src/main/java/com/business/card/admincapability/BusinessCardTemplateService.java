package com.business.card.admincapability;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCardTemplateService {
	
	@Autowired
	private BusinessCardTemplateRepository businessCardTemplateRepository;
	
	public BusinessCardTemplate getBusinessCardTemplateById(String id) {
		if (this.businessCardTemplateRepository.existsById(id)) {
			if (this.businessCardTemplateRepository.findById(id) != null &&
					this.businessCardTemplateRepository.findById(id).get() != null ) {
				return this.businessCardTemplateRepository.findById(id).get();
			}
		}
		return null;
	}

	public List<BusinessCardTemplate> getBusinessCardTemplates() {
		return this.businessCardTemplateRepository.findAll();
	}
	
	public BusinessCardTemplate updateBusinessCardTemplate(String id, BusinessCardTemplate businessCardTemplate) {
		if (this.businessCardTemplateRepository.existsById(id)) {
			if (this.businessCardTemplateRepository.findById(id) != null &&
					this.businessCardTemplateRepository.findById(id).get() != null ) {
				return this.businessCardTemplateRepository.save(businessCardTemplate);
			}
		}
		return null;
	}
	
	public BusinessCardTemplate addBusinessCardTemplate(BusinessCardTemplate businessCardTemplate) {
		return this.businessCardTemplateRepository.save(businessCardTemplate);
	}
	
	public BusinessCardTemplate deleteBusinessCardTemplateById(String id) {
		if (this.businessCardTemplateRepository.existsById(id)) {
			if (this.businessCardTemplateRepository.findById(id) != null &&
					this.businessCardTemplateRepository.findById(id).get() != null ) {
				BusinessCardTemplate businessCardTemplateToBeUpdated = this.businessCardTemplateRepository.findById(id).get();
				businessCardTemplateToBeUpdated.setStatus("DELETE");
				return this.businessCardTemplateRepository.save(businessCardTemplateToBeUpdated);
			}
		}
		return null;
	}
	
	
}
