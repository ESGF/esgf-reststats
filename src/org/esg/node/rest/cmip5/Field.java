package org.esg.node.rest.cmip5;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Field {
    private String name;
    private String value;
    
    public Field() {
    }

    @XmlAttribute
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @XmlValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
