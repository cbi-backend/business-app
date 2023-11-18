package com.business.card.admincapability;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("card")
public class BusinessCardTemplate {

	@Id
	private String id; // auto generated
	private List<Element> elements;
	private String primary_color;
	private String secondary_color;
	private String acent_color;
	private String color;
	private String raw_conetent;
	private String design_specific;
	private String type;
	private String last_updated_by_id;  // auto generated
	private String owner_id;  // auto generated
	private String status;  // auto generated
	private String template_id;  // auto generated
	private Date added_date; // auto generated
	private Date last_updated_date; // auto generated
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public String getPrimary_color() {
		return primary_color;
	}

	public void setPrimary_color(String primary_color) {
		this.primary_color = primary_color;
	}

	public String getSecondary_color() {
		return secondary_color;
	}

	public void setSecondary_color(String secondary_color) {
		this.secondary_color = secondary_color;
	}

	public String getAcent_color() {
		return acent_color;
	}

	public void setAcent_color(String acent_color) {
		this.acent_color = acent_color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRaw_conetent() {
		return raw_conetent;
	}

	public void setRaw_conetent(String raw_conetent) {
		this.raw_conetent = raw_conetent;
	}

	public String getDesign_specific() {
		return design_specific;
	}

	public void setDesign_specific(String design_specific) {
		this.design_specific = design_specific;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLast_updated_by_id() {
		return last_updated_by_id;
	}

	public void setLast_updated_by_id(String last_updated_by_id) {
		this.last_updated_by_id = last_updated_by_id;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public Date getAdded_date() {
		return added_date;
	}

	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public BusinessCardTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessCardTemplate(String id, List<Element> elements, String primary_color, String secondary_color,
			String acent_color, String color, String raw_conetent, String design_specific, String type,
			String last_updated_by_id, String owner_id, String status, String template_id, Date added_date,
			Date last_updated_date) {
		super();
		this.id = id;
		this.elements = elements;
		this.primary_color = primary_color;
		this.secondary_color = secondary_color;
		this.acent_color = acent_color;
		this.color = color;
		this.raw_conetent = raw_conetent;
		this.design_specific = design_specific;
		this.type = type;
		this.last_updated_by_id = last_updated_by_id;
		this.owner_id = owner_id;
		this.status = status;
		this.template_id = template_id;
		this.added_date = added_date;
		this.last_updated_date = last_updated_date;
	}

	@Override
	public String toString() {
		return "BusinessCardTemplate [id=" + id + ", elements=" + elements + ", primary_color=" + primary_color
				+ ", secondary_color=" + secondary_color + ", acent_color=" + acent_color + ", color=" + color
				+ ", raw_conetent=" + raw_conetent + ", design_specific=" + design_specific + ", type=" + type
				+ ", last_updated_by_id=" + last_updated_by_id + ", owner_id=" + owner_id + ", status=" + status
				+ ", template_id=" + template_id + ", added_date=" + added_date + ", last_updated_date="
				+ last_updated_date + "]";
	}
	
}
