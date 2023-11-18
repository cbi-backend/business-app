package com.business.card.admincapability;

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
public class BusinessCardTemplateController {

	@Autowired
	private BusinessCardTemplateService businessCardTemplateService;

	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
	}

	@GetMapping("api/v0/template/getById/{id}")
	@ResponseBody
	public BusinessCardTemplate getBusinessCardTemplateById(@PathVariable("id") String id) {
		return this.businessCardTemplateService.getBusinessCardTemplateById(id);
	}

	@GetMapping("api/v0/template/getAll")
	@ResponseBody
	public List<BusinessCardTemplate> getBusinessCardTemplates() {
		return this.businessCardTemplateService.getBusinessCardTemplates();
	}

	@PutMapping("api/v0/template/update/{id}")
	@ResponseBody
	public BusinessCardTemplate updateBusinessCardTemplate(@PathVariable("id") String id, @RequestBody BusinessCardTemplate businessCardTemplate) {
		return this.businessCardTemplateService.updateBusinessCardTemplate(id,businessCardTemplate);
	}

	@PostMapping("api/v0/template/add")
	@ResponseBody
	public BusinessCardTemplate addBusinessCardTemplate(@RequestBody BusinessCardTemplate businessCardTemplate) {
		return this.businessCardTemplateService.addBusinessCardTemplate(businessCardTemplate);
	}

	@PutMapping("api/v0/template/delete/{id}")
	@ResponseBody
	public BusinessCardTemplate deleteBusinessCardTemplateById(@PathVariable("id") String id) {
		return this.businessCardTemplateService.deleteBusinessCardTemplateById(id);
	}
	
}
