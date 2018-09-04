package com.test.java.di;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Value;




public class PropertyDiBean {
	@Value("property")
	private String name ;
	private List<String> listProperty = null ;
	private Map<String,String> mapProperty = null;
	
	public void sayHello() {
		System.out.println("Greeting From "+name);
	}

	public void listProperties() {
		System.out.println("List property:"+Arrays.toString(listProperty.toArray()));
	}
	
	public void printMapProperties() {
		for(Entry<String , String> entry: mapProperty.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getListProperty() {
		return listProperty;
	}
	public void setListProperty(List<String> listProperty) {
		this.listProperty = listProperty;
	}
	public Map<String, String> getMapProperty() {
		return mapProperty;
	}
	public void setMapProperty(Map<String, String> mapProperty) {
		this.mapProperty = mapProperty;
	}
	
} 
