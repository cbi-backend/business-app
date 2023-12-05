package com.business.card.appcapability;

public class Element {
	
	private Long sequence;
	private String type;
	private String style;
	private String name;
	private String value;
	
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public Element() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Element(Long sequence, String type, String style, String name, String value) {
		super();
		this.sequence = sequence;
		this.type = type;
		this.style = style;
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Element [sequence=" + sequence + ", type=" + type + ", style=" + style + ", name=" + name
				+ ", value=" + value + "]";
	}
	
}
