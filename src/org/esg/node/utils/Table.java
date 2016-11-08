package org.esg.node.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Row.class})
public class Table<T> {
	
	private String name;
	private List<T> listOfEntityObjects;

    public Table() {
        listOfEntityObjects = new ArrayList<T>();
    }

    public Table(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems() {
        return listOfEntityObjects;
    } 
    
    @XmlAttribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
