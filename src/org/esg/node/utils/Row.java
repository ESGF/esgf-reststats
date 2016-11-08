package org.esg.node.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "row")
@XmlSeeAlso({Field.class})
public class Row {
	private List fieldList;

	@XmlElement(name="field")
	public List getFieldList() {
	    return fieldList;
	}
	public void setFieldList(List fieldList) {
	    this.fieldList = fieldList;
	}
} 
