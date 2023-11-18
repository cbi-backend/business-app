package com.business.card.admincapability;

public class Element {
	
	private Long sequence;
	private String type;
	private String style;
	private String name;
	private String default_value;
	
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefault_value() {
		return default_value;
	}
	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}

	public Element() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Element(Long sequence, String type, String style, String name, String default_value) {
		super();
		this.sequence = sequence;
		this.type = type;
		this.style = style;
		this.name = name;
		this.default_value = default_value;
	}
	@Override
	public String toString() {
		return "Element [sequence=" + sequence + ", type=" + type + ", style=" + style + ", name=" + name
				+ ", default_value=" + default_value + "]";
	}
	
}
