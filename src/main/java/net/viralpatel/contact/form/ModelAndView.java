package net.viralpatel.contact.form;

import java.util.Map;

public class ModelAndView {
	private String viewName;
	private Map<String,String> data;
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	public void addObject(String key, String value){
		this.data.put(key, value);
	}
	
}
